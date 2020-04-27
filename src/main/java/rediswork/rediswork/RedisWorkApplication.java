package rediswork.rediswork;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan("rediswork.rediswork.mapper")
@SpringBootApplication
@EnableSwagger2
public class RedisWorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisWorkApplication.class, args);
    }

}
