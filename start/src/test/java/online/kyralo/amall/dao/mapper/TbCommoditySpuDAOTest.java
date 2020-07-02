package online.kyralo.amall.dao.mapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import online.kyralo.amall.dao.dataobject.TbCommoditySpuDO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.UUID;

@SpringBootTest
public class TbCommoditySpuDAOTest {

    @Resource
    private TbCommoditySpuDAO dao;

    @Test
    void findById() {
    }

    @Test
    void findByPage() {
        PageHelper.startPage(1, 10);
        Page<TbCommoditySpuDO> byPage = dao.findByPage();
        System.out.println(byPage);
    }

    @Test
    void insert() {
        TbCommoditySpuDO tbCommoditySpuDO = TbCommoditySpuDO.builder()
                .id(UUID.randomUUID().toString().replace("-", ""))
                .brandId("1")
                .bannerUrl("1")
                .categoryId(1)
                .mainUrl("1")
                .spuDesc("1")
                .status(1)
                .name("1")
                .unit("1")
                .sellingPoint("")
                .build();
        System.out.println(dao.insert(tbCommoditySpuDO));
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }
}