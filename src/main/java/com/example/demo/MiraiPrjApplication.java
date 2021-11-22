package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiraiPrjApplication {
	
	// 定数
	public static final int APRIL = 4;
	public static final int WORKABLE_AGE = 18;

	// main処理
	public static void main(String[] args) {
		SpringApplication.run(MiraiPrjApplication.class, args);
	}
}
