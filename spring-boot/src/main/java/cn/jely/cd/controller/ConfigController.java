package cn.jely.cd.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("config")
public class ConfigController {

    @NacosValue(value = "${useLocalCache}",autoRefreshed = true)
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