## zkWeb-en

zkWeb is zookeeper web to manager and monitor zookeeper cluster with builtin H2 database.This is based on TaoBao God（yasenagat）'s zkWeb code,and have a big upgrade and modification,It can run as two methods:

1. put <war-file> to tomcat and execute it!
2. java -jar <jar-file> to execute it!

### old zkWeb code address

yasenagat-zkweb svn: [http://code.taobao.org/svn/zkweb/](http://code.taobao.org/svn/zkweb/ "yasenagat-zkweb")

### Major Modification

- Upgrade depend jars include spring\zookeeper ...
- Upgrade easyui to EasyUI for jQuery 1.5.5.4、jQuery v1.12.4
- Optimize page layout,such as: multi-tabs switch,one zk to one tab;add filter within cfg pages.
- Support High version of Tomcat,and tested ok with tomcat 8
- Add zookeeper cluster's state-monitor function,and use four-word cmd to get state infomation
- Add zookeeper loop-check connect state
- Front-end web add i18n Internationalization plugin，Support english and zh_CN，and server-end data don't added this.
- Upgrade to use spring boot 2
- Add favicon.ico
- jsp -> Thymeleaf

## ZooKeeperWEB
zookeeper web管理和监控界面，使用内置的H2数据库，此版本基于github主zhitom的zkWeb源码基础之上进行了mysql数据源的升级和修改，有两种运行方式:

1. 直接将war包放入tomcat即可运行！
2. 直接运行: java -jar <jar-file>

### 旧zkWeb源码地址

yasenagat-zkweb svn: [http://code.taobao.org/svn/zkweb/](http://code.taobao.org/svn/zkweb/ "yasenagat-zkweb")

### 重大修改点

- 升级依赖的第三方库，包括spring、zookeeper等
- 升级easyui到EasyUI for jQuery 1.5.5.4、jQuery v1.12.4
- 优化页面布局，如：支持多TAB切换，一个zk连接一个TAB标签；在配置界面增加过滤器；
- 支持tomcat高版本，目前在tomcat8测试通过
- 增加zk集群状态的监控功能，使用了四字命令获取监控信息
- 增加zk集群自动检测连接状态功能
- 前端web增加i18n国际化插件，支持界面英文展示，注：服务端数据未支持国际化。
- 使用spring boot 2升级改造,可以不依赖tomcat
- 增加了浏览器图标favicon.ico
- jsp -> Thymeleaf

### screen snapshot

connected: [https://user-images.githubusercontent.com/2204457/41921088-a39f7856-7994-11e8-8620-90cd81dc33ce.png](https://user-images.githubusercontent.com/2204457/41921088-a39f7856-7994-11e8-8620-90cd81dc33ce.png "connected")

disconnected: [https://user-images.githubusercontent.com/2204457/41921099-a9d53620-7994-11e8-868c-1da341334184.png](https://user-images.githubusercontent.com/2204457/41921099-a9d53620-7994-11e8-868c-1da341334184.png "disconnected")

## spring boot修改备注

- 打jar包,webapp/resources无法访问,需修改代码addResourceHandlers:
		- `registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/",
        		"classpath:/META-INF/resources/webapp/resources/");`

- 打war包,webapp/resources被默认打包到根目录下导致无法访问,需要打包到WEB-INF/classes/resources

- 改造为使用Thymeleaf模版后,目前已经将webapp目录移除了
- pom-jar.xml for jar,pom-tomcat.xml for tomcat

## docker一键启动命令
```
docker run -p 8099:8099 --name zkweb  -d peterpoker/zkweb:v1.2.1
```


## docker 打包
参考src下的Dockerfile文件中的使用说明


### 注意：
-这个版本的ZooKeeperWEB工具fork的是zhitom的zkweb项目，上面的内容都是原作者原创内容。

-地址：github[https://github.com/zhitom/zkweb]

## 我已完成工作，ZooKeeperWEB对zkweb的升级
- 支持mysql，oracle等流行关系数据库的运行

- 打包成war包，稳定运行在centos7 tomcat裸机生产环境下，拦截器ZkWebMvcConfigurer 和 配置类的分离[解决拦截器使得配置类中数据源bean失效的问题]

- 稳定运行在mysql关系数据库上，解决了c3p0数据源连接mysql 8小时断连的问题

- ZooKeeperWEB目的是稳定运行在生产环境，用于生产环境的zookeeper集群节点数据管理，已完成了从H2的内嵌数据库到关系数据库mysql的迁移


## TODO
- 未来将加入权限管理模块，用于开发团队成员对zookeeper集群 操作权限的管理
- 解决经常性弹出节点连接失效的窗口问题