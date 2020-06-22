# nacos-config-sample
Nacos config sample Project (with user auth)
>NACOS 1.2.1及1.3.0通过其它版本未验证

##spring-boot
```text
Spring boot config演示，配置由false改为true,没有问题，但是true改为false要等很长时间才更新
注解使用@NacosValue
```
##spring-cloud
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
###添加用户(可选)
并添加可以访问命名空间的用户(推荐只读).也可使用默认nacos/nacos测试使用.
###添加配置
默认为example.properties,也可指定profile，当然需要为指定的profile添加配置.
如test,则对应example-test.properties,这个配置需要在nacos指定的命名空间及组内配置好.
无法获取和更新配置请首先确认是否引入正确版本的依赖，然后可以在ClientWorker.class中打断电调试看看具体请求的内容
```text
result = this.agent.httpGet("/v1/cs/configs", (List)null, params, this.agent.getEncode(), readTimeout);
```
如果result code 403 content返回有 Unkown user! 就要对引入版本以及用户密码进行检查.

