package online.kyralo.amall.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.*;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/9/16
 * \* Time: 11:49
 * \* Description: 线程池配置
 * \
 */
@Configuration
public class ThreadPoolConfig {

    @Primary
    @Bean
    public ExecutorService executorService(){
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),  new CustomizableThreadFactory("amall-thread-pool-"));
    }

}
