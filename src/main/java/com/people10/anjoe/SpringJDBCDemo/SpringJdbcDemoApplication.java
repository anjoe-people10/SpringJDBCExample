package com.people10.anjoe.SpringJDBCDemo;

import com.people10.anjoe.SpringJDBCDemo.model.Alien;
import com.people10.anjoe.SpringJDBCDemo.repo.AlienRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcDemoApplication {

    public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcDemoApplication.class, args);

		Alien alien = context.getBean(Alien.class);

		alien.setId(110);
		alien.setName("Anjoe");
		alien.setTech("Java");

		AlienRepository alienRepository = context.getBean(AlienRepository.class);
		alienRepository.save(alien);

		System.out.println(alienRepository.getAll());
    }

}
