package cn.apps.service.impl;


import cn.apps.dao.DevUserDao;
import cn.apps.pojo.DevUser;
import cn.apps.service.DevUserService;
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
@Service("devUserService")
public class DevUserServiceImpl implements DevUserService {
    @Resource
    private DevUserDao devUserDao;

    /**
     * 通过user查询单条数据
     * @param user 对象
     * @return 实例对象
     */
    @Override
    public DevUser queryByUser(DevUser user) {
        DevUser devUser;
        try {
            devUser = devUserDao.queryByUser(user);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
        return devUser;
    }

}
