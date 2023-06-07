package cn.apps.dao;

import cn.apps.pojo.DevUser;

/**
 * @author Siyu
 */
public interface DevUserDao {

    int deleteByPrimaryKey(Long id);

    int insert(DevUser record);

    int insertSelective(DevUser record);

    DevUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DevUser record);

    int updateByPrimaryKey(DevUser record);
}