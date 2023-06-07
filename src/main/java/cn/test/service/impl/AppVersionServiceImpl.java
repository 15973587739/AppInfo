package cn.test.service.impl;

import cn.test.entity.AppVersion;
import cn.test.dao.AppVersionDao;
import cn.test.service.AppVersionService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (AppVersion)表服务实现类
 *
 * @author makejava
 * @since 2023-06-07 10:21:38
 */
@Service("appVersionService")
public class AppVersionServiceImpl implements AppVersionService {
    @Resource
    private AppVersionDao appVersionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AppVersion queryById(Long id) {
        return this.appVersionDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param appVersion 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<AppVersion> queryByPage(AppVersion appVersion, PageRequest pageRequest) {
        long total = this.appVersionDao.count(appVersion);
        return new PageImpl<>(this.appVersionDao.queryAllByLimit(appVersion, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param appVersion 实例对象
     * @return 实例对象
     */
    @Override
    public AppVersion insert(AppVersion appVersion) {
        this.appVersionDao.insert(appVersion);
        return appVersion;
    }

    /**
     * 修改数据
     *
     * @param appVersion 实例对象
     * @return 实例对象
     */
    @Override
    public AppVersion update(AppVersion appVersion) {
        this.appVersionDao.update(appVersion);
        return this.queryById(appVersion.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.appVersionDao.deleteById(id) > 0;
    }
}
