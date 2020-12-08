package com.bjmashibing.userprovider;

import com.bjmashibing.userapi.UserApi;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {

    @Override
    public String alive() {
        return "ooxxoo";
    }

    @Override
    public String getById(Integer Id) {
        return null;
    }
}
