<h1 align="center"> 微图书管理平台-API </h1>

<p align="center">
  <a href="https://github.com/spring-projects/spring-boot">
    <img src="https://img.shields.io/badge/springboot-2.1.5-blue" alt="spring-boot">
  </a>
  <a href="https://github.com/apache/shiro">
    <img src="https://img.shields.io/badge/shiro-1.4.1-blue" alt="shiro">
  </a>
  <a href="https://github.com/Zealon159/book-ms-interface/blob/master/LICENSE">
    <img src="https://img.shields.io/badge/License-MIT-yellow" alt="license">
  </a>
</p>

演示地址：[http://books.zealon.cn/](http://books.zealon.cn/)

## 项目介绍

此项目为微图书的接口工程，基于Spring Boot & MyBatis & Shiro & Redis 等框架构建

- 通用项目结构、配置文件、精简的POM
- 统一响应结果封装，支持 Fluent Interface 风格 
- 统一异常处理
- 基础CRUD抽象封装

前端采用 Vue.js 、Element-UI 开发：[点击进入仓库](https://github.com/Zealon159/book-ms-ui)

### 工程结构

主要分了4个包，业务应用包app，系统功能包system，公用包common，以及核心包core，明细如下：

```
- src/main/java
	- cn.zealon.book
  	- app / 业务应用包
  		- book / 图书
  		- dictionary / 数据字典
  		- index / 系统主页
  		- user / 用户信息
  	- common / 公共包
  		- base / 抽象基类
  		- config / 工程配置
  		- domain / 公共域对象
  		- result / 响应结果封装
  		- utils / 工具类
  	- core / 核心包 
    	- cache / 缓存
    	- datasource / 数据源
    	- exception / 异常处理
    	- log / 操作日志
    	- schedule / 调度任务
  	- system / 系统功能包
    	- attachment / 附件
    	- org / 组织、用户、角色、权限
    	- security / 安全处理(shiro)
    - Application.java / 项目启动类
- src/main/resources
	- mappers / MyBatis映射文件
	- application.yml / 应用配置文件
	- application-dev.yml / 开发环境配置
	- application-prod.yml / 生产环境配置
```

## 快速开始

1. 初始化数据库脚本

2. 配置 `application-dev.yml` 

   1. 配置MySQL数据库账户密码

   2. 配置Redis账户密码

   3. 配置系统属性文件

      ```
      system:
        properties:
          # 删除开关（上线演示，避免删除全部数据）
          delete-switch: false
          # 上传白名单
          upload-white: 127.0.0.1
          # 操作系统物理路径
          upload-path: /Users/admin/local/
          # 附件相对目录
          attachment-dir: attachment/
          # 访问URL映射
          attachment-access: /attachment/**
      ```

      由于线上演示一些功能做了开关限制，这里把 `delete-switch` 配置为false就取消了限制哈。

      同样的，上传白名单限制 `upload-white` ，配置为空就取消了限制了。

      再就是附件上传根目录 `upload-path` ，注意 windows 系统和 linux 系统路径区别就行了。

3. 启动工程

   运行 Application 启动项目，默认端口 8002，可以在 `application.yml` 中修改端口，注意修改后，vue工程配置文件的代理部分也需要修改。

## 指南

### 登录

登录授权使用了 shiro 安全框架实现，如果修改用户登录验证部分，改写 cn.zealon.book.system.security.shiro.ShiroRealm 的 doGetAuthenticationInfo 函数。

