package cn.apps.service.impl;


import cn.apps.dao.BackendUserDao;
import cn.apps.pojo.BackendUser;
import cn.apps.service.BackendUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * (DevUser)表服务实现类
 *
 * @author makejava
 * @since 2023-06-07 10:07:51
 */
@Transactional
@Service("UserService")
public class BackendUserServiceImpl implements BackendUserService {
    @Resource
    private BackendUserDao backendUserDao;

    /**
     * 通过user查询单条数据
     * @param user 对象
     * @return 实例对象
     */
    @Override
    public BackendUser queryByUser(BackendUser user) {
        BackendUser devUser;
        try {
            devUser = backendUserDao.queryByUser(user);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
        return devUser;
    }

}
