import { LinkOutlined } from '@ant-design/icons';
import type { Settings as LayoutSettings } from '@ant-design/pro-components';
import { SettingDrawer } from '@ant-design/pro-components';
import type { RequestConfig, RunTimeLayoutConfig } from '@umijs/max';
import { history, Link } from '@umijs/max';
import React from 'react';
import {
  AvatarDropdown,
  AvatarName,
  Footer,
  Question,
  SelectLang,
} from '@/components';
import { currentUser as queryCurrentUser } from '@/services/ant-design-pro/api';
import defaultSettings from '../config/defaultSettings';
import { errorConfig } from './requestErrorConfig';
import '@ant-design/v5-patch-for-react-19';
import {message} from "antd";
import {RequestOptions} from "@@/plugin-request/request";

const isDev = process.env.NODE_ENV === 'development';
const loginPath = '/user/login';

/**
 * @see https://umijs.org/docs/api/runtime-config#getinitialstate
 * */
export async function getInitialState(): Promise<{
  settings?: Partial<LayoutSettings>;
  currentUser?: API.CurrentUser;
  loading?: boolean;
  fetchUserInfo?: () => Promise<API.CurrentUser | undefined>;
}> {
  const fetchUserInfo = async () => {
    try {
      const msg = await queryCurrentUser({
        skipErrorHandler: true,
      });
      return msg.data;
    } catch (_error) {
      history.push(loginPath);
    }
    return undefined;
  };
  // 如果不是登录页面，执行
  const { location } = history;
  if (
    ![loginPath, '/user/register', '/user/register-result'].includes(
      location.pathname,
    )
  ) {
    const currentUser = await fetchUserInfo();
    return {
      fetchUserInfo,
      currentUser,
      settings: defaultSettings as Partial<LayoutSettings>,
    };
  }
  return {
    fetchUserInfo,
    settings: defaultSettings as Partial<LayoutSettings>,
  };
}

// ProLayout 配置（保持不变）
export const layout: RunTimeLayoutConfig = ({
  initialState,
  setInitialState,
}) => {
  return {
    actionsRender: () => [
      <Question key="doc" />,
      <SelectLang key="SelectLang" />,
    ],
    avatarProps: {
      src: initialState?.currentUser?.avatar,
      title: <AvatarName />,
      render: (_, avatarChildren) => {
        return <AvatarDropdown>{avatarChildren}</AvatarDropdown>;
      },
    },
    waterMarkProps: {
      content: initialState?.currentUser?.name,
    },
    footerRender: () => <Footer />,
    onPageChange: () => {
      const { location } = history;
      // 如果没有登录，重定向到 login
      if (!initialState?.currentUser && location.pathname !== loginPath) {
        history.push(loginPath);
      }
    },
    bgLayoutImgList: [
      {
        src: 'https://mdn.alipayobjects.com/yuyan_qk0oxh/afts/img/D2LWSqNny4sAAAAAAAAAAAAAFl94AQBr',
        left: 85,
        bottom: 100,
        height: '303px',
      },
      {
        src: 'https://mdn.alipayobjects.com/yuyan_qk0oxh/afts/img/C2TWRpJpiC0AAAAAAAAAAAAAFl94AQBr',
        bottom: -68,
        right: -45,
        height: '303px',
      },
      {
        src: 'https://mdn.alipayobjects.com/yuyan_qk0oxh/afts/img/F6vSTbj8KpYAAAAAAAAAAAAAFl94AQBr',
        bottom: 0,
        left: 0,
        width: '331px',
      },
    ],
    links: isDev
      ? [
        <Link key="openapi" to="/umi/plugin/openapi" target="_blank">
          <LinkOutlined />
          <span>使用文档</span>
        </Link>,
      ]
      : [],
    menuHeaderRender: undefined,
    childrenRender: (children) => {
      return (
        <>
          {children}
          {isDev && (
            <SettingDrawer
              disableUrlParams
              enableDarkTheme
              settings={initialState?.settings}
              onSettingChange={(settings) => {
                setInitialState((preInitialState) => ({
                  ...preInitialState,
                  settings,
                }));
              }}
            />
          )}
        </>
      );
    },
    ...initialState?.settings,
  };
};

interface BackendResponse {
  code: number;
  data?: any;
  msg?: string;
}

/**
 * @name request 配置
 */
export const request: RequestConfig = {
  baseURL: 'http://localhost:8088',
  ...errorConfig,

  // 添加请求拦截器，自动携带token
  requestInterceptors: [
    (config: RequestOptions) => {
      try {
        // 后端登录返回字段名是 accessToken，存取时请保持一致
        const token = localStorage.getItem('accessToken') || '';
        const headers = {
          ...(config.headers || {}),
          ...(token ? { Authorization: `Bearer ${token}` } : {}),
        };
        return { ...config, headers };
      } catch (_e) {
        // 若读取 localStorage 出错，则返回原始配置（不修改 url）
        return config;
      }
    },
  ],

  // 响应拦截器，处理token过期等情况
  responseInterceptors: [
    (response) => {
      // 有的 umi/request 实现这里传入的是解析后的 JSON，有的传入原始 Response。
      // 先尝试按解析后 JSON 的方式处理：
      try {
        const backend = response as unknown as BackendResponse;
        // 成功并且返回了 token（例如登录接口），则保存 token
        if (backend?.code === 200 && backend?.data) {
          const d = backend.data;
          if (d.accessToken) {
            localStorage.setItem('accessToken', d.accessToken);
          }
          if (d.refreshToken) {
            localStorage.setItem('refreshToken', d.refreshToken);
          }
        }
        // 如果后端返回非 200，尽量给用户提示（errorThrower 一般会抛出，这里做一次兜底）
        if (backend?.code && backend.code !== 200) {
          message.error(backend.msg || '请求失败');
        }
      } catch (_e) {}

      return response;
    },
  ],
};
