package online.kyralo.amall.web;

import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import online.kyralo.amall.api.ActivityService;
import online.kyralo.amall.api.TbCommodityCategoryService;
import online.kyralo.amall.api.TbUserService;
import online.kyralo.amall.common.api.Res;
import online.kyralo.amall.common.utils.CopyUtil;
import online.kyralo.amall.common.utils.JwtUtil;
import online.kyralo.amall.common.utils.ResUtil;
import online.kyralo.amall.web.vo.PActivityVO;
import online.kyralo.amall.web.vo.PHomeVO;
import online.kyralo.amall.web.vo.TbUserVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.ArrayList;
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
public class HomeController {

    @Resource
    private TbCommodityCategoryService tbCommodityCategoryService;

    @Resource
    private ActivityService activityService;

    @Resource
    private TbUserService tbUserService;

    @GetMapping("/pc/user")
    @ApiOperation(value = "查询主页信息", response = PHomeVO.class)
    public Res<?> getPageInfo(@RequestHeader(value = HEADER_STRING, required = false) String token) {

        PHomeVO home = new PHomeVO();

        // 类型 列表
        Object commodityKindsBO = tbCommodityCategoryService.listCommodityCategories().getData();
        List<PHomeVO.CommodityKind> commodityKinds = Lists.newArrayList();
        CopyUtil.copyBean(commodityKinds, commodityKindsBO);
        home.setKinds(commodityKinds);

        // 活动 列表
        Object homeActivitiesBO = activityService.listHomeActivities().getData();
        List<PActivityVO> activities = Lists.newArrayList();
        CopyUtil.copyBean(homeActivitiesBO, activities);
        home.setActivities(activities);

        // 用户信息
        if (token != null && !"".equals(token)) {
            String userId = JwtUtil.getUserNameFromToken(token);
            // 用户登录过且token在有效时间内 执行
            if (userId != null) {
                Object data = tbUserService.queryById(userId).getData();
                if (data != null) {
                    TbUserVO user = new TbUserVO();
                    CopyUtil.copyBean(data, user);
                    home.setUser(user);
                } else {
                    home.setUser(null);
                }
            }
        }

        // 购物车 数量


        // 收藏夹 数量


        // 待付订单 数量


        // 秒杀


        // 商品首页展示模块 列表


        // 推荐商品 列表


        return ResUtil.success(home);
    }
}
