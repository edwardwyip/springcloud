package com.bjmashibing.userconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    ConsumerApi api;

    @GetMapping("/alive")
    public String alive() {
        return api.alive();
    }

}
