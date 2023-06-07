package cn.test.service.impl;

import cn.test.entity.DevUser;
import cn.test.dao.DevUserDao;
import cn.test.service.DevUserService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (DevUser)表服务实现类
 *
 * @author makejava
 * @since 2023-06-07 10:07:51
 */
@Service("devUserService")
public class DevUserServiceImpl implements DevUserService {
    @Resource
    private DevUserDao devUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DevUser queryById(Long id) {
        return this.devUserDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param devUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<DevUser> queryByPage(DevUser devUser, PageRequest pageRequest) {
        long total = this.devUserDao.count(devUser);
        return new PageImpl<>(this.devUserDao.queryAllByLimit(devUser, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param devUser 实例对象
     * @return 实例对象
     */
    @Override
    public DevUser insert(DevUser devUser) {
        this.devUserDao.insert(devUser);
        return devUser;
    }

    /**
     * 修改数据
     *
     * @param devUser 实例对象
     * @return 实例对象
     */
    @Override
    public DevUser update(DevUser devUser) {
        this.devUserDao.update(devUser);
        return this.queryById(devUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.devUserDao.deleteById(id) > 0;
    }
}
