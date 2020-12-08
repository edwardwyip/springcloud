package com.bjmashibing.eurekaconsumer;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MainController {

    // 抽象接口
    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    EurekaClient eurekaClient;


    @GetMapping("/getHi")
    public String getHi(){
        return "Hi Consumer";
    }

    @GetMapping("/client")
    public String client() {
        // eureka注册的服务
        List<String> services = discoveryClient.getServices();

        for (String service : services) {
            System.out.println(service);
        }

        return "Hi Client";
    }

    @GetMapping("/client2")
    public Object client2() {
        // 拉取eureka中provider的信息
        return discoveryClient.getInstances("provider");
    }

    @GetMapping("/client3")
    public Object client3() {
        // 拉取eureka中provider的信息
        List<ServiceInstance> provider = discoveryClient.getInstances("provider");
        for (ServiceInstance instance : provider) {
            System.out.println(ToStringBuilder.reflectionToString(instance));
        }
        return "hi client3";
    }

    @GetMapping("/client4")
    public Object client4() {
        // 具体服务
//        List<InstanceInfo> instances = eurekaClient.getInstancesById("admin-PC:provider:80");

        // 使用服务名，找列表
        List<InstanceInfo> instances = eurekaClient.getInstancesByVipAddress("provider", false);
        for (InstanceInfo instance : instances) {
            System.out.println(ToStringBuilder.reflectionToString(instance));
        }

        if (instances.size() > 0) {
            InstanceInfo instance = instances.get(0);
            if (instance.getStatus() == InstanceInfo.InstanceStatus.UP) {
                String url = "http://" + instance.getHostName() + ":" + instance.getPort() + "/getHi";
                System.out.println("url:" + url);

                RestTemplate restTemplate = new RestTemplate();

                String respStr = restTemplate.getForObject(url, String.class);

                System.out.println("respStr:" + respStr);
            }
        }

        return "hi client4";
    }

}
