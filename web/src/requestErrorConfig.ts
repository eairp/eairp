import type { RequestOptions } from '@@/plugin-request/request';
import type { RequestConfig } from '@umijs/max';
import { message, notification } from 'antd';

// 与后端约定的响应数据格式
interface ResponseStructure {
  code: number;
  data?: any;
  msg?: string;
}

/**
 * @name 错误处理
 * pro 自带的错误处理， 可以在这里做自己的改动
 * @doc https://umijs.org/docs/max/request#配置
 */
export const errorConfig: RequestConfig = {
  // 请求拦截器
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

  // 响应拦截器
  responseInterceptors: [
    (response) => {
      // 有的 umi/request 实现这里传入的是解析后的 JSON，有的传入原始 Response。
      // 先尝试按解析后 JSON 的方式处理：
      try {
        const backend = response as unknown as ResponseStructure;
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
