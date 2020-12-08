package com.bjmashibing.userconsumer;

import com.bjmashibing.userapi.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "user-provider")
public interface ConsumerApi extends UserApi {

}
