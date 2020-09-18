package online.kyralo.amall;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;

@SpringBootTest
class AmallApplicationTests {

    @Resource
    private ExecutorService executorService;

    @Test
    public void loads1() {

        long start = System.currentTimeMillis();

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        integers.forEach(i -> executorService.submit(() -> System.out.println(i)));

        System.out.println("-------->>> " + (System.currentTimeMillis() - start));
    }

    @Test
    public void loads2(){
        long start = System.currentTimeMillis();

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        integers.forEach(System.out::println);

        System.out.println("-------->>> " + (System.currentTimeMillis() - start));
    }

}
