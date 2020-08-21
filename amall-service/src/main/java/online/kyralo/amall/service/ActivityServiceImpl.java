package online.kyralo.amall.service;

import online.kyralo.amall.api.ActivityService;
import online.kyralo.amall.api.model.ActivityModel;
import online.kyralo.amall.common.api.Res;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangchen
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ActivityServiceImpl implements ActivityService {

    @Transactional(readOnly = true)
    @Override
    public Res<?> findById(String activityId) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public Res<?> listHomeActivities() {
        return null;
    }

    @Override
    public Res<?> insert(ActivityModel activityModel) {
        return null;
    }

    @Override
    public Res<?> update(ActivityModel activityModel) {
        return null;
    }

    @Override
    public Res<?> remove(String activityId) {
        return null;
    }
}
