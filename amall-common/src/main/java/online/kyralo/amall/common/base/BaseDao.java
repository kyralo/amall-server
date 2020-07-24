package online.kyralo.amall.common.base;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author wangchen
 */
public interface BaseDao<T> extends Mapper<T>, MySqlMapper<T>, ConditionMapper<T> {
}
