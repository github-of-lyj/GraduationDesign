package lyj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FileMybatisMain {
    public static void main(String[] args) {
        SpringApplication.run(FileMybatisMain.class,args);
    }
}
