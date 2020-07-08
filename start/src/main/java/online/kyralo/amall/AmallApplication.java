package online.kyralo.amall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author wangchen
 */
@MapperScan("online.kyralo.amall.dao.mapper")
@SpringBootApplication
public class AmallApplication {
    public static void main(String[] args) {
        SpringApplication.run(AmallApplication.class, args);
    }
}
