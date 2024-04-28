package cn.itcast.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    /*
    * 创建RestTemplate对象并注入到SpringIOC容器中
    * */
    @Bean
    @LoadBalanced   //标识次方法发起的http请求会被Ribbon拦截
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
