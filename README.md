# ARouterBaseProject

#### 项目介绍
基本组件化的Base框架，在原有的BaseProject中引入了ARouter作为路由，更改了gradle配置。可以在gradle.properties中配置业务组建是否单独编译。

#### 软件架构
MVP+Retrofit+RxAndroid+Glide


#### 安装教程


#### 使用说明

1. 如需要单独编译某个插件可以在根目录下的gradle.properties中配置
2. 如需新增module时可按照已经配置好的4个的module来配置名称，并添加到gradle.properties以及app的gradle中
3. 如需要修改module名称，需要在3个地方修改：
       
      A. gradle.properties,定义变量名称
       
      B. 主项目（app）的gradle文件中，修改依赖库的选择编译条件
       
      C. module本身的gradle中，修改选择编译applicationId的条件
4. 不要向项目推送带有业务逻辑的代码，项目本身只是一个通用的框架
5. 推送代码时如遇涉及到到使用功能的更新或修改要做好注释并及时更新 README

#### 参与贡献

1. Fork 本项目
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request
