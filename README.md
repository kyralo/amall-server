# 前言
基于 SpringBoot 开发的电商项目, 持续开发中 ... 

## 项目简介
Amall 项目是一个前后端分离的、基于B2C模式的电商项目.
目前主要包括前台商城系统 [后续将开发后台管理系统],
商城系统包括 首页、商品展示、商品搜索、购物车、订单流程、商品秒杀、
用户信息、用户收藏、用户账单等模块;

### API文档效果图
![](https://cdn.kyralo.online/web/amall/amall-api.png)

### 前端项目地址
[amall-web](https://github.com/kyralo/amall-web)

## 技术
- 基本骨架: Springboot + Mybatis
- 数据库: MySQL (使用阿里Druid数据库连接池技术)
- 鉴权: Spring Security + jwt (token鉴权)
- 缓存: Redis (购物车, 热点数据, 秒杀)
- 消息队列: RabbitMQ (秒杀模块)
- 支付: Alipay
- 邮件: Spring Mail (注册账号绑定)
- 日志记录: Logback
- web服务器: Tomcat
- 路由转发: Nginx
- 文件上传: [Alioss](https://www.alibabacloud.com/help/zh/doc-detail/31884.htm?spm=a2c63.p38356.879954.8.5d66219ffQTiYM#task-njz-hf4-tdb)
- Api文档: Swagger (样式引用了GitHub上作者caspar-chen写的样式)
- 项目构建工具: Maven

## 项目结构

    ├── amall-api                [ 对外接口 ]         
    ├── amall-code-generator     [ 代码生成 ]
    ├── amall-common             [ 通用配置 ]
    ├── amall-dao                [ 数据交互 ]
    ├── amall-dependencies       [ 依赖管理 ]
    ├── amall-docker-compose
    ├── amall-manager            [ 业务层逻辑下沉 ]
    ├── amall-service            [ 业务逻辑 ]
    ├── amall-web                [ API ]
    ├── start                    [ 启动入口 ]   
    


