package com.mio.spring6.iocannotation.bean;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//等价于 <bean id="user" class="...本类名"></bean>
// 其中参数value可以省略，默认是类型首字母小写
//@Component(value="user2")
//@Controller
//@Service
@Repository
public class User {}
