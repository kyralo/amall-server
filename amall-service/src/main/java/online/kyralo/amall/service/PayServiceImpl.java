package online.kyralo.amall.service;

import online.kyralo.amall.api.PayService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * \* Created with Intellij IDEA.
 * \* Author: wangchen
 * \* Date: 2020/9/8
 * \* Time: 8:51
 * \* Description: 支付
 * \
 */

@Transactional(rollbackFor = Exception.class)
@Service
public class PayServiceImpl implements PayService {
}
