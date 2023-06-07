package cn.test.service.impl;

import cn.test.entity.BackendUser;
import cn.test.dao.BackendUserDao;
import cn.test.service.BackendUserService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (BackendUser)表服务实现类
 *
 * @author makejava
 * @since 2023-06-07 10:21:55
 */
@Service("backendUserService")
public class BackendUserServiceImpl implements BackendUserService {
    @Resource
    private BackendUserDao backendUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BackendUser queryById(Long id) {
        return this.backendUserDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param backendUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<BackendUser> queryByPage(BackendUser backendUser, PageRequest pageRequest) {
        long total = this.backendUserDao.count(backendUser);
        return new PageImpl<>(this.backendUserDao.queryAllByLimit(backendUser, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param backendUser 实例对象
     * @return 实例对象
     */
    @Override
    public BackendUser insert(BackendUser backendUser) {
        this.backendUserDao.insert(backendUser);
        return backendUser;
    }

    /**
     * 修改数据
     *
     * @param backendUser 实例对象
     * @return 实例对象
     */
    @Override
    public BackendUser update(BackendUser backendUser) {
        this.backendUserDao.update(backendUser);
        return this.queryById(backendUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.backendUserDao.deleteById(id) > 0;
    }
}
