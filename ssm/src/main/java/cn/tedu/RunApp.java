package cn.tedu;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="cn.tedu.mapper")//基准路径  要扫描那些配置文件
public class RunApp {

	public static void main(String[] args) {
		 SpringApplication.run(RunApp.class, args);

	}

}
