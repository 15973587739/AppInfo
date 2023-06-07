package cn.apps.service;

import cn.apps.pojo.DevUser;

/**
 * @Author: SIYU
 * (DevUser)表服务接口
 * @Description: TODO
 * @DateTime: 2023/6/7 11:48
 **/
public interface DevUserService {
    /**
     * 通过user查询单条数据
     *
     * @param user 对象
     * @return 实例对象
     */
    DevUser queryByUser(DevUser user);
}
