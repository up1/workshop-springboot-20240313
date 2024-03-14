package com.example.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class HelloApplication {

	public static void main(String[] args) {
		 ConfigurableApplicationContext context
				 = SpringApplication.run(HelloApplication.class, args);
		 String[] beans = context.getBeanDefinitionNames();
        Arrays.stream(beans).forEach(System.out::println);
		System.out.println(context.getBeanDefinitionCount());

		MyBean b1 = context.getBean(MyBean.class);
		MyBean b2 = context.getBean(MyBean.class);
		b1.setMessage("From b1");
		b2.setMessage("From b2");
		System.out.println(b1.getMessage());
		System.out.println(b2.getMessage());
	}

}
