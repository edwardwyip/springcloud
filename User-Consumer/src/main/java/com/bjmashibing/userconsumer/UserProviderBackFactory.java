package com.bjmashibing.userconsumer;

import feign.FeignException;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserProviderBackFactory implements FallbackFactory<ConsumerApi> {

    @Override
    public ConsumerApi create(Throwable cause) {
        // TODO Auto-generated method stub
        return new ConsumerApi() {

            @Override
            public String getById(Integer id) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public String alive() {
                // TODO Auto-generated method stub
                System.out.println(cause);
                if(cause instanceof FeignException.InternalServerError) {

                    return "远程服务器 500" + cause.getLocalizedMessage();
                }else {

                    return "呵呵";
                }
            }

            @Override
            public Map<Integer, String> postMap(Map<String, Object> map) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public Map<Integer, String> getMap3(Map<String, Object> map) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public Map<Integer, String> getMap2(Integer id, String name) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public Map<Integer, String> getMap(Integer id) {
                // TODO Auto-generated method stub
                return null;
            }
        };
    }
}
