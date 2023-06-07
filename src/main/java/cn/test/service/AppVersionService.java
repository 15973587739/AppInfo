package cn.test.service;

import cn.test.entity.AppVersion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (AppVersion)表服务接口
 *
 * @author makejava
 * @since 2023-06-07 10:21:38
 */
public interface AppVersionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AppVersion queryById(Long id);

    /**
     * 分页查询
     *
     * @param appVersion 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<AppVersion> queryByPage(AppVersion appVersion, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param appVersion 实例对象
     * @return 实例对象
     */
    AppVersion insert(AppVersion appVersion);

    /**
     * 修改数据
     *
     * @param appVersion 实例对象
     * @return 实例对象
     */
    AppVersion update(AppVersion appVersion);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
