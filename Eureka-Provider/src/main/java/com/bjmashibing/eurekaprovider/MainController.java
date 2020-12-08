package com.bjmashibing.eurekaprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Value("${server.port}")
    String port;

    @Autowired
    HealthStatusService hsrv;

    @GetMapping("/getHi")
    public String getHi(){
        return "Hi Provider，port：" + port;
    }

    @GetMapping("/health")
    public String health(@RequestParam("status") Boolean status) {
        hsrv.setStatus(status);
        return hsrv.getStatus();
    }

}
