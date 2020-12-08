package com.bjmashibing.userapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/User")
public interface UserApi {

    /**
     * 查看当前服务状态
     * @return
     */
    @GetMapping("/alive")
    String alive();

    @GetMapping("/getById")
    String getById(Integer Id);
}
