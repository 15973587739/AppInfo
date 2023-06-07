package cn.test.service;

import cn.test.entity.BackendUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (BackendUser)表服务接口
 *
 * @author makejava
 * @since 2023-06-07 10:21:55
 */
public interface BackendUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BackendUser queryById(Long id);

    /**
     * 分页查询
     *
     * @param backendUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<BackendUser> queryByPage(BackendUser backendUser, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param backendUser 实例对象
     * @return 实例对象
     */
    BackendUser insert(BackendUser backendUser);

    /**
     * 修改数据
     *
     * @param backendUser 实例对象
     * @return 实例对象
     */
    BackendUser update(BackendUser backendUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
