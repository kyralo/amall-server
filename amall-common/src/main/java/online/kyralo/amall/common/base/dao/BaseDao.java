package online.kyralo.amall.common.base.dao;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author wangchen
 */
public interface BaseDao<T> extends Mapper<T>, MySqlMapper<T> {
}
