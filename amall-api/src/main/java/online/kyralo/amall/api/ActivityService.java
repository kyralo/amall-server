package online.kyralo.amall.api;

import online.kyralo.amall.api.model.ActivityModel;
import online.kyralo.amall.common.api.Res;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/8/19
 * \* Time: 19:53
 * \* Description: 活动存储在redis中
 * \
 */
public interface ActivityService {

    /**
     * 查询活动 通过活动ID
     *
     * @param activityId 活动ID
     * @return 活动
     */
    Res<?> findById(String activityId);

    /**
     * 查询主页当前阶段活动 列表
     *
     * @return 主页当前阶段活动 列表
     */
    Res<?> listHomeActivities();

    /**
     * 新增活动
     *
     * @param activityModel 活动
     * @return 新增的状态
     */
    Res<?> insert(ActivityModel activityModel);

    /**
     * 更新活动
     *
     * @param activityModel 活动
     * @return 更新的状态
     */
    Res<?> update(ActivityModel activityModel);

    /**
     * 下架活动 通过活动ID
     *
     * @param activityId 活动ID
     * @return 删除的状态
     */
    Res<?> remove(String activityId);

}
