package cn.apps.dao;

import cn.apps.pojo.DevUser;

/**
 * @author Siyu
 */
public interface DevUserDao {
    /**
     * 通过user查询单条数据
     *
     * @param user 对象
     * @return 实例对象
     */
    DevUser queryByUser(DevUser user);

}