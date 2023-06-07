package cn.test.service;

import cn.test.entity.AppCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 手游类别(AppCategory)表服务接口
 *
 * @author makejava
 * @since 2023-06-07 10:20:14
 */
public interface AppCategoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AppCategory queryById(Long id);

    /**
     * 分页查询
     *
     * @param appCategory 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<AppCategory> queryByPage(AppCategory appCategory, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param appCategory 实例对象
     * @return 实例对象
     */
    AppCategory insert(AppCategory appCategory);

    /**
     * 修改数据
     *
     * @param appCategory 实例对象
     * @return 实例对象
     */
    AppCategory update(AppCategory appCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
