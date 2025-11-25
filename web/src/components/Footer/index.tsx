import { GithubOutlined } from '@ant-design/icons';
import { DefaultFooter } from '@ant-design/pro-components';
import React from 'react';

const Footer: React.FC = () => {
  return (
    <DefaultFooter
      style={{
        background: 'none',
      }}
      copyright="Copyright ©2025 佛山市中技环保节能设备有限公司 版权所有"
      links={[
        {
          key: '1',
          title: '中技产品 · 中国站',
          href: 'http://www.zjhbgr.com/',
          blankTarget: true,
        },
        {
          key: 'github',
          title: <GithubOutlined />,
          href: 'https://github.com/ZhongjiCloud',
          blankTarget: true,
        },
        {
          key: '2',
          title: 'Zhong ji Products · Global',
          href: 'https://www.zhogee666.com/',
          blankTarget: true,
        },
      ]}
    />
  );
};

export default Footer;
