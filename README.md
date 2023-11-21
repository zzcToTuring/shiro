# shiro
了解学习 shiro 权限控制 相关内容，主要内容有：

### 在无框架模式使用
+ 认识shiro框架

+ 入门案例，创建shiroManager

+ 角色、权限分配

+ 加密

+ 自定义realm(讲述较少，详情见springboot版)

### 在springboot框架中使用

+ 项目搭建(pom.xml文件、项目配置、application.yml，mybatis-plus等内容配置完成)

+ springboot部分：userService创建方法(方便从数据库中查询相关信息)

+ 初始化shiro

创建real配置：myReal,shiroConfig

  > controller访问：mainController
    
  > index.html页面
  
### 多个 realm 的认证策略设置

### rememberMe 与 登出：

+ shiroConfig配置：
  
  * ShiroConfig_cook设置rememberMe启用、cookie设置、拦截器设置
  
+ index页面、controller同时做相关修改
  
  * 登出只需在拦截器中做相应配置即可
  
### 角色授权、权限设置
    
+ controller设置:在后端哪些方法不仅仅登录，还要权限：mainController_role 
  
+ PermissionsException设置：没权限跳转页面不友好，同时控制台报错，若用户没权限/认证失败展示相应内容
            
+ myReal修改：增加权限/角色认证：myReal_role(注意其格式和要求参数)
            
+ 前端页面：
                
  * 若角色没有权限，在前端页面不应该展示，使用thymeleaf框架进行展示/隐藏处理(详情见index文件/note)
