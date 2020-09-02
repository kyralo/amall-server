package online.kyralo.amall.api;

import online.kyralo.amall.common.api.Res;

/**
 * @author wangchen
 */
public interface SeckillService {

    /**
     * 查询秒杀信息 主页
     *
     * @return 秒杀信息
     */
    Res<?> listSeckillsForHomePage();

    /**
     * 查询秒杀信息 秒杀页
     *
     * @return 秒杀信息
     */
    Res<?> listSeckillsForSeckillPage();
}
