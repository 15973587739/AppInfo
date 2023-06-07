package cn.apps.service;

import cn.apps.pojo.BackendUser;

/**
 * @author Siyu
 */
public interface BackendUserService {
    /**
     * 通过user查询单条数据
     *
     * @param user 对象
     * @return 实例对象
     */
    BackendUser queryByUser(BackendUser user);
}