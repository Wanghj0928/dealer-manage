package com.jiawawulian.dealermanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jiawawulian.dealermanage.dao")
public class DealerManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(DealerManageApplication.class, args);
	}
}
