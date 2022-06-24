package com.tpe.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/* 
 * Bu sınıfın oluşlturulmasındaki amaç : program çalışırken, arka planda oluşan beanları JSON formatında ekrana getirtmek...
 */

@Controller

public class BeanController {
	
	
    @Autowired
    private ApplicationContext applicationContext;
    
    @RequestMapping("/bean")
    @ResponseBody   // Controller sınıflarında konulması gerekiyor, " response da dönecek body i ben gireceğim " demektir.
    public Map<String,String> getBeans(){
        
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        
        Map<String,String> map=new HashMap<>();
        
        for (String beanName : beanNames) {
            
            map.put(beanName, applicationContext.getBean(beanName).toString());
        }
        return map;
    }
	
	

}
