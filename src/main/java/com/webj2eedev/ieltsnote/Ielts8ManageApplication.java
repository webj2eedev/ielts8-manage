package com.webj2eedev.ieltsnote;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.webj2eedev"}, exclude = {TransactionAutoConfiguration.class})
@ImportResource("classpath*:config/spring.xml")
@MapperScan({"com.webj2eedev.ieltsnote.dao"})
@EnableScheduling
@Configuration
public class Ielts8ManageApplication {
	public static void main(String[] args) {
		SpringApplication.run(Ielts8ManageApplication.class, args);
	}
}
