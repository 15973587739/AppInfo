package cn.test.service;

import cn.test.entity.DevUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (DevUser)表服务接口
 *
 * @author makejava
 * @since 2023-06-07 10:07:51
 */
public interface DevUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DevUser queryById(Long id);

    /**
     * 分页查询
     *
     * @param devUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<DevUser> queryByPage(DevUser devUser, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param devUser 实例对象
     * @return 实例对象
     */
    DevUser insert(DevUser devUser);

    /**
     * 修改数据
     *
     * @param devUser 实例对象
     * @return 实例对象
     */
    DevUser update(DevUser devUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
