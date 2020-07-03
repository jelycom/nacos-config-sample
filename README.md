# nacos-config-sample
Nacos config sample Project (with user auth)
>NACOS 1.2.1及1.3.0通过其它版本未验证
## spring-boot
```text
Spring boot config演示，配置由false改为true,没有问题，但是true改为false要等很长时间才更新
注解使用@NacosValue
```
## spring-cloud
```text
Spring Cloud Config演示
注解使用@Value
```
###添加权限验证
如果要验证用户名密码需要在nacos server的配置文件conf/application.properties中，修改
```
nacos.core.auth.enabled=false
```
为
```
nacos.core.auth.enabled=true
```
### 添加用户(可选)
并添加可以访问命名空间的用户(推荐只读).也可使用默认nacos/nacos测试使用.
### 添加配置
默认为example.properties,也可指定profile，当然需要为指定的profile添加配置.
如test,则对应example-test.properties,这个配置需要在nacos指定的命名空间及组内配置好.
无法获取和更新配置请首先确认是否引入正确版本的依赖，然后可以在ClientWorker.class中打断电调试看看具体请求的内容
```text
result = this.agent.httpGet("/v1/cs/configs", (List)null, params, this.agent.getEncode(), readTimeout);
```
如果result code 403 content返回有 Unkown user! 就要对引入版本以及用户密码进行检查.
### 本地开发和运行环境分开
实际工作中开发环境的配置与测试/线上等环境配置不同，要么本地将多种环境的配置文件配置好，直接启动时激活相应的环境，也可以通过shell脚本更新修改，但都不是很方便，并且容易泄漏，通过配置中心能比较好的解决，但是加入配置中心后本地开发配置如果还是去配置中心又不是很方便并且。
本项目就使用maven打包插件来将项目打包后的配置从配置中心获取，当然也可以通过shell脚本，jenkins等ci工具来处理,让开发人员无需关心其它环境配置。

