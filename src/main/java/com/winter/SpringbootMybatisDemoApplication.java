package com.winter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.Jedis;

@SpringBootApplication
@MapperScan("com.winter.mapper")
public class SpringbootMybatisDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisDemoApplication.class, args);
	}

	private Jedis jedis;
	@Bean
	public Jedis jedis(){
		//连接redis服务器，192.168.0.100:6379
		jedis = new Jedis("101.132.191.77", 6379);
		//权限认证
		jedis.auth("123456");
		return jedis;
	}
}
