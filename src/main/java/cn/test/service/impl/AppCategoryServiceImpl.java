package cn.test.service.impl;

import cn.test.entity.AppCategory;
import cn.test.dao.AppCategoryDao;
import cn.test.service.AppCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 手游类别(AppCategory)表服务实现类
 *
 * @author makejava
 * @since 2023-06-07 10:20:14
 */
@Service("appCategoryService")
public class AppCategoryServiceImpl implements AppCategoryService {
    @Resource
    private AppCategoryDao appCategoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AppCategory queryById(Long id) {
        return this.appCategoryDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param appCategory 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<AppCategory> queryByPage(AppCategory appCategory, PageRequest pageRequest) {
        long total = this.appCategoryDao.count(appCategory);
        return new PageImpl<>(this.appCategoryDao.queryAllByLimit(appCategory, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param appCategory 实例对象
     * @return 实例对象
     */
    @Override
    public AppCategory insert(AppCategory appCategory) {
        this.appCategoryDao.insert(appCategory);
        return appCategory;
    }

    /**
     * 修改数据
     *
     * @param appCategory 实例对象
     * @return 实例对象
     */
    @Override
    public AppCategory update(AppCategory appCategory) {
        this.appCategoryDao.update(appCategory);
        return this.queryById(appCategory.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.appCategoryDao.deleteById(id) > 0;
    }
}
