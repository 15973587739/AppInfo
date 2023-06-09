package cn.apps.dao;

import cn.apps.pojo.BackendUser;

public interface BackendUserDao {
    /**
     * 通过user查询单条数据
     *
     * @param user 对象
     * @return 实例对象
     */
    BackendUser queryByUser(BackendUser user);
}