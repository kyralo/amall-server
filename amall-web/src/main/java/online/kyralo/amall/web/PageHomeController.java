package online.kyralo.amall.web;

import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import online.kyralo.amall.api.*;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.constants.OrderConstant;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.common.utils.JwtUtil;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.web.vo.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.List;

import static online.kyralo.amall.common.constants.SecurityConstant.HEADER_STRING;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/18
 * \* Time: 23:47
 * \* Description: PC端页面 主页
 * \
 */

@RestController
@RequestMapping("/api/v1/home")
@Api(tags = "PC端页面 主页")
@Validated
public class PageHomeController {

    @Resource
    private TbCommodityCategoryService tbCommodityCategoryService;
    @Resource
    private ActivityService activityService;
    @Resource
    private TbUserService tbUserService;
    @Resource
    private CartService cartService;
    @Resource
    private TbUserCollectionService tbUserCollectionService;
    @Resource
    private TbOrderService tbOrderService;
    @Resource
    private SeckillService seckillService;
    @Resource
    private CommodityService commodityService;


    @GetMapping("/pc/user")
    @ApiOperation(value = "查询主页信息", response = PHomeVO.class)
    public Res<?> getPcHomePageInfo(@RequestHeader(value = HEADER_STRING, required = false) String token) {

        PHomeVO page = new PHomeVO();

        // 类型 列表
        Object commodityKindsBO = tbCommodityCategoryService.listCommodityCategories().getData();
        List<PHomeVO.CommodityKind> commodityKinds = Lists.newArrayList();
        CopyUtil.copyBean(commodityKinds, commodityKindsBO);
        page.setKinds(commodityKinds);

        // 活动 列表
        Object pageActivitiesBO = activityService.listHomeActivities().getData();
        List<PActivityVO> activities = Lists.newArrayList();
        CopyUtil.copyBean(pageActivitiesBO, activities);
        page.setActivities(activities);

        // 用户信息
        if (token != null && !"".equals(token)) {
            String userId = JwtUtil.getUserNameFromToken(token);
            // 用户登录过且token在有效时间内 执行
            if (userId != null) {
                Object userBO = tbUserService.queryById(userId).getData();
                if (userBO != null) {
                    TbUserVO user = new TbUserVO();
                    CopyUtil.copyBean(userBO, user);
                    page.setUser(user);

                    // 购物车 数量
                    Integer cartCountBO = (Integer) cartService.countByUserId(userId).getData();
                    page.setCartCount(cartCountBO);

                    // 收藏夹 数量
                    Integer collectionCountBO = (Integer) tbUserCollectionService.countByUserId(userId).getData();
                    page.setCollectionCount(collectionCountBO);

                    // 待付订单 数量
                    Integer notPayOrderCountBO = (Integer) tbOrderService.countOrdersByUserIdAndStatus(userId, OrderConstant.ORDER_NOT_PAID).getData();
                    page.setOrderCount(notPayOrderCountBO);
                } else {
                    userId = "";
                    page.setUser(null);
                }

                // 推荐商品 列表
                Object recommondCommoditiesBO = commodityService.listHomeRecommondCommodities(userId).getData();
                List<TbCommodityVO> recommondCommodities =
                        CopyUtil.copyList(recommondCommoditiesBO, TbCommodityVO.class);
                page.setRecommendCommodities(recommondCommodities);

            }
        }

        // 秒杀
        Object seckillBO = seckillService.listSeckillsForHomePage().getData();
        PHomeVO.Seckill seckill = new PHomeVO.Seckill();
        CopyUtil.copyBean(seckillBO, seckill);
        page.setSeckill(seckill);

        // 商品首页展示模块 列表
        Object showModulesBO = commodityService.listHomeShowModules().getData();
        List<PHomeVO.ShowModule> showModules = CopyUtil.copyList(showModulesBO, PHomeVO.ShowModule.class);
        page.setShowModules(showModules);


        return ResUtil.success(page);
    }
}
