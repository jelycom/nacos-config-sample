package cn.jely.cd.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("config")
@RefreshScope
public class ConfigController {

//    @NacosValue(value = "${useLocalCache}",autoRefreshed = true)
    @Value(value = "${useLocalCache}")
    private boolean useLocalCache;

    /**
     * http://localhost:8080/config/get
     */
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ResponseBody
    public String get() {
        return String.valueOf(useLocalCache);
    }
}