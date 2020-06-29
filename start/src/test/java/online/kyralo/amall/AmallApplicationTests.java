package online.kyralo.amall;

import com.mongodb.client.MongoCollection;
import lombok.Builder;
import lombok.Data;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.ExecutableFindOperation;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.annotation.Resource;

@SpringBootTest
class AmallApplicationTests {

    @Resource
    private MongoTemplate mongoTemplate;


    @Data
    @Builder
    private static class User {
        private String id;
        private String name;
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void mongoQuery() {

        ExecutableFindOperation.ExecutableFind<User> query = mongoTemplate.query(User.class);
        System.out.println(query.firstValue());


    }

    @Test
    public void mongoSave() {

        User user = User.builder().
                id("1").
                name("wangchen").
                build();

        mongoTemplate.save(user);
    }

}
