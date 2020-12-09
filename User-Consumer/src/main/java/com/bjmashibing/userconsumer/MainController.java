package com.bjmashibing.userconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    ConsumerApi api;


    @Autowired
    RestService rest;


//
//	@Autowired
//	MashibingApi mapi;


    // 给SpringMVC 编程servlet
    @GetMapping("/alive2")
    public String alive2() {
        /**
         * URL 不能变
         *
         * jar
         * 文档
         */
        return rest.alive();
    }


    public String back() {

        return "呵呵";
    }


    @GetMapping("/alive")
    public String alive() {
        /**
         * URL 不能变
         *
         * jar
         * 文档
         */
        return api.alive();


        /**
         *
         * 降级
         *
         *
         * 隔离
         *
         * 熔断
         *
         * 自己写
         *
         *
         * try{
         *
         *     1.   发起向服务方的请求;
         *     		1.1 判断连接超时
         *     			-> 这次请求 记录到服务里
         *     		http请求  线程消耗
         *
         *
         *     		map(URI,线程数)
         *     		线程池（线程数）
         *        阈值 阀值
         *
         *        计数 连续失败次数 达到阈值
         *        count ++；
         *     if(count == 10){
         *
         *     new romdom  == 1  按时间
         *       发请求
         *
         *
         *     	throw exception;
         *     }
         *
         *
         *         请求/不请求/半请求
         *         开      关         半开
         *
         *     if （当前线程满了）{
         *     	throw exception
         *     }
         *
         *
         *     		1.2 尝试向其他服务器发起请求
         *
         *
         *     注解
         *
         *
         *     2. 还是没成功
         *
         *     }catch(Exception e){
         *
         *     	1.	避免返回不友好的错误信息
         *     			-> 好看点儿的页面  重试按钮 联系邮箱
         *
         *
         *     	2.	return 另外一个东西 写到MQ里 admin 发个邮件
         *
         *     		return "客观稍后再来"；
         *
         *     }
         *
         *
         *     Hystrix 干的就是这件事儿
         */


    }


}
