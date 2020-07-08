package online.kyralo.amall.common.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * \* Created with IntelliJ IDEA.
 * \* Date: 2018-11-09
 * \* Time: 下午7:07
 * \* Description:数据库连接池配置 ref:https://github.com/alibaba/druid/wiki
 * \
 */
@Configuration
public class DaoConfig {

    @Bean
    @Primary
    public DataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }
}
