package online.kyralo.amall.dao.mapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import online.kyralo.amall.dao.dataobject.TbCommoditySpuDO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

@SpringBootTest
public class TbCommoditySpuDAOTest {

    @Resource
    private TbCommoditySpuDAO dao;


    @Test
    void findById() {
        System.out.println(dao.findById("63f6659a097e467eb10483bf56d6a34e"));
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
        TbCommoditySpuDO tbCommoditySpuDO = TbCommoditySpuDO.builder()
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
        System.out.println(dao.updateByPrimaryKey(tbCommoditySpuDO));
    }

    @Resource
    private ExecutorService executorService;

    @Test
    void deleteById() {


    }
}