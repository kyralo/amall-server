package online.kyralo.amall.api;

import online.kyralo.amall.api.model.TbCommoditySpuModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class TbCommoditySpuServiceTest {

    @Resource
    private TbCommoditySpuService service;

    @Test
    void findById() {
        System.out.println(service.findById("63f6659a097e467eb10483bf56d6a34e"));
    }

    @Test
    void insert() {
    }

    @Test
    void update() {
        TbCommoditySpuModel tbCommoditySpuModel = TbCommoditySpuModel.builder()
                .id("63f6659a097e467eb10483bf56d6a34e")
                .brandId("3")
                .bannerUrl("3")
                .categoryId(3)
                .mainUrl("3")
                .spuDesc("3")
                .status(3)
                .name("3")
                .unit("3")
                .sellingPoint("")
                .build();
        System.out.println(service.update(tbCommoditySpuModel));
    }

    @Test
    void deleteById() {
        System.out.println(service.deleteById("63f6659a097e467eb10483bf56d6a34e"));
    }
}