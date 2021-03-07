package com.example.restservice;

import com.example.restservice.model.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor () {
        System.out.println("MyBeanPostProcessor 实例化......");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Person){
            Person person = (Person) ((Person) bean);
            person.setName("fengyan");
            person.setAge(36);
        }
        System.out.println("spring中bean实例:" + beanName + " 初始化之前处理......");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("spring中bean实例:" + beanName + " 初始化之后处理......");
        return bean;
    }
}
