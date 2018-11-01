package com.taylor;/**
 * ${author} on 2018/11/1.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangxiaolu
 * @描述
 * @since 2018/11/1 17:03
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/say")
    public String sayHello() {
        String s = discoveryClient.getLocalServiceInstance().getHost() + discoveryClient.getLocalServiceInstance().getPort();
        return "hello world!" + s;
    }

}
