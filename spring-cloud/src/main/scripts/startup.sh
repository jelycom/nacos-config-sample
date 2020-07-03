#!/bin/bash
#dirname $0，取得当前执行的脚本文件的父目录
#cd `dirname $0`，进入这个目录(切换当前工作目录)
#pwd，显示当前工作目录(cd执行后的)
basepath=$(cd `dirname $0`; pwd)
#项目启动占用内存就在128m以上，所以设置Xms128m,,可以加入 -Dspring.profile.active=xxx来切换环境及配置
#对应的需要在nacos中配置相应的环境默认为${spring.application.name}-{spring.profile.active}.${spring.cloud.nacos.config.file-extension}
#本例中是example-xxx.properties,因没有指定namespace,需要在Public命名空间下添加
java -Dfile.encoding=utf-8 -jar $basepath/spring-cloud-0.1.0.jar -Xms1024m -Xmx2048m -XX:MaxNewSize=512m &
