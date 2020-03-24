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

### 身份认证

登录身份授权使用了 Shiro 安全框架实现，Shiro 核心组件说明：

核心组件说明：

| 组件               | 说明                                                         |
| ------------------ | ------------------------------------------------------------ |
| SecurityManager    | 安全管理器，图中没有对此说明，但安全管理器又起到了最重要的作用，它对 所有组件起到统一管理的作用。可以理解为Shiro架构本身。 |
| Realms             | 域，图中也没有对此说明，Shiro从Realm获取安全数据(如用户、角色、权限)， 就是说SecurityManager要验证用户身份，那么它需要从Realm获取相应的用户 进行比较以确定用户身份是否合法；也需要从Realm得到用户相应的角色/权限 进行验证用户是否能进行操作；可以把Realm看成DataSource，即安全数据源。 |
| Authentication     | 认证管理器，起到用户登录认证的作用。                         |
| Authorization      | 授权管理器，访问授权控制，相当于角色权限管理，即确定“谁”可以访问“什么”。 |
| Session Management | 会话管理。                                                   |

其中我们的安全管理器在 `common.config.ShiroConfig` 类下配置，同时也配置了会话管理、资源拦截配置、Realm、等等。

如果修改用户登录验证部分，那么要改写 `system.security.shiro.ShiroRealm` 类的 `doGetAuthenticationInfo` 函数，登录成功后将用户信息存储至 `principal` 中，这样只要用户登录后持续保持会话，就可以在任何地方获取我们的用户信息啦。

角色权限部分，则在 `doGetAuthorizationInfo` 函数中处理，目前本项目没有实现shiro操作权限。可以通过声明式注解指定的接口，实现权限验证，详细使用请参阅官网。

### 应用开发

系统对实体、持久层、服务层、控制器层，都做了一定的抽象，其父类在 `common.base` 包中。

#### 实体层

实体类继承 `BaseEntity` 即可，不需要有 id、创建时间等属性，都在父类中实现。

#### 持久层

持久层接口，继承 `BaseMapper`，泛型参数填写实体类，实现方法写在 `mapper.xml` 中即可，如果没有特殊的函数，不需要在 `mapper.java` 中编写方法。如：

```
public interface OrgDeptMapper extends BaseMapper<OrgDept> {
    /** 获取部门数据源 */
    @Select("select id,name text from org_dept order by sort_number")
    List<SelectVO> getDeptSelect();
}
```

其中CRUD方法，不需要编写(父类中已实现)，可直接应用。

#### 服务层

服务层继承 `AbstractBaseService` ，泛型参数填写实体类，如没有特殊函数，同样的不需要写一行代码。如：

```
@Service
public class OrgDeptService extends AbstractBaseService<OrgDept> {

}
```

`AbstractBaseService` 默认实现了基本的 CRUD 函数，子类不用写这些基本的函数，如有业务逻辑，则可以重写这些方法或增加自定义方法即可。

如重写某一个函数，实现一定的业务逻辑：

```
@Override
public Result deleteById(Integer id) {
    Integer userCount = orgUserMapper.findCountByDept(id);
    if (userCount > 0) {
        return ResultUtil.verificationFailed().buildMessage("删除失败，该部门下还有" + userCount + "个用户，请先移动用户至其它部门！");
    }
    return super.deleteById(id);
}
```

#### 控制器层

控制器层继承 `BaseController` ，声明 `@RestController` 标识Rest接口，引入对应的服务类，定义API接口映射即可：

```
@RestController
@RequestMapping("system/org/dept")
public class OrgDeptController extends BaseController {
    // your code ...
}
```

前后端分离项目涉及跨域问题，其中 `BaseController` 中使用了跨域注解支持，其它 controler 就不用单独声明了。

#### 响应结果

响应结果结构，code 为状态码，msg 为通知消息，data 为响应数据。

如果普通的操作，只返回 msg 即可；如果请求查询，则返回 data 数据。

```
{
    "code":200,
    "msg":"操作成功",
    "data":null
}
```

系统对响应结果做了完善的封装，只需要一行代码即可实现各类操作的响应处理。如：

```
public Result create(){
    // 默认成功
    return ResultUtil.success();
    
    // 默认失败
    return ResultUtil.fail();
    
    // 默认成功不返回通知
    return ResultUtil.successAndNoMsg();
    
    // 默认成功自定义通知
    return ResultUtil.success().buildMessage("你好啊");
    
    // 默认成功自定义响应数据
    return ResultUtil.success("我是数据ヾ(◍°∇°◍)ﾉﾞ");
    
    // 等等...
}
```

#### 分页

分页响应结果封装到了了 `PageVO` 里，分页服务定义此类为返回值。

系统使用了分页插件实现分页，如下示例：

```
public PageVO<User> getPageList(Params params) {
   Integer page = params.getInt("page");
   Integer limit = params.getInt("limit");
   PageHelper.startPage(page, limit);
   Page<User> pageList = (Page<User>) this.mapper.selectAll();
   return new PageVO<>(pageList.getTotal(),200,"",pageList);
}
```

只要在DB读取的代码上面加上  `PageHelper.startPage(page, limit);` 即可实现分页SQL处理，SQL语句无需填写 `limit {#start},{#limit}` 的限制。

#### 大数据量分页

这种普通的分页，在数据量不太多的情况下还可以，若数据量达到大几十万、或百万以上级别，性能就明显慢了，且随着数据量的增加越来越慢，所以建议不能再用这种普通的分页方式了。

普通的分页：

```
SELECT user_name,user_id FROM org_user where dept_id=2 
ORDER BY user_id asc LIMIT 5000000 ,100 
```

原因是limit 这种方式，会遍历前面无关的 5000000 行数据，再向后查询100条，所以当数据量越大就会越慢咯。那么我们跳过前面5000000 行无关的数据页遍历，可以直接通过索引定位到第5000001，第5000002行，这样操作是不是更快了可以优化为快速定位要访问的数据行，如：

```
SELECT a.user_name,a.user_id FROM org_user a, 
(select user_id from org_user where dept_id=2 ORDER BY user_id asc LIMIT 5000000 ,100 ) b 
where a.user_id = b.user_id;
```

这样数据库查询引擎会通过索引跳过无关数据行，然后查询相关数据行了，当然查询条件必须要命中索引才行。

抛砖引玉，如果海量数据分页，就不建议单存使用数据库实现了，可以考虑用使用缓存+数据库的、或缓存等的方式。

> 在我们生产环境，使用索引定位行的方式优化过大数据量分页查询，总数据量在8000W行左右，没优化前查询一次平均需要用200秒才能查完，优化后只要3秒左右。

#### 线程池

目前系统没有用到线程池的业务，但是已经配置了一个公共线程池，在一些需要异步执行的业务上可以直接使用（如业务数据写入之后，异步发送通知、异步记录日志等）。配置位置：`common.config.ThreadPoolConfig` ，可以自定义线程数等参数、名称。使用的时候直接引用，如：

```
@Autowired
private ExecutorService messageQueueThreadPool;

private void sendMsg(){
    this.messageQueueThreadPool.execute(new Runnable() {
        @Override
        public void run() {
            System.out.println("推送消息");
        }
    });
}
```

## License

[MIT](https://github.com/Zealon159/book-ms-interface/blob/master/LICENSE)

Copyright (c) 2020 光彩盛年

