package com.mio.spring6.iocannotation.autowired.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //指定这是配置类
@ComponentScan("com.mio.spring6.iocannotation.autowired") //开启组件扫描
public class SpringConfig {
}
