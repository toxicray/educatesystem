package com.ray.educatesystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.ray.educatesystem.mapper")
@EnableAsync
@ServletComponentScan(basePackages = "com.ray.educatesystem.filter")
public class EducatesystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EducatesystemApplication.class, args);
	}

}
