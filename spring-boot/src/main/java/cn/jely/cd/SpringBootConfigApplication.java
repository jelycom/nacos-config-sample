package cn.jely.cd;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Document: https://nacos.io/zh-cn/docs/quick-start-spring-boot.html
 * <p>
 * Nacos 控制台添加配置：
 * <p>
 * Data ID：example
 * <p>
 * Group：DEFAULT_GROUP
 * <p>
 * 配置内容：useLocalCache=true
 */
@SpringBootApplication
@NacosPropertySource(dataId = "example",autoRefreshed = true)
public class SpringBootConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConfigApplication.class, args);
    }
}
