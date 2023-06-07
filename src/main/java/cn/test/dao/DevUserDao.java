package cn.test.dao;

import cn.test.entity.DevUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (DevUser)表数据库访问层
 *
 * @author makejava
 * @since 2023-06-07 10:07:51
 */
public interface DevUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DevUser queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param devUser 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<DevUser> queryAllByLimit(DevUser devUser, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param devUser 查询条件
     * @return 总行数
     */
    long count(DevUser devUser);

    /**
     * 新增数据
     *
     * @param devUser 实例对象
     * @return 影响行数
     */
    int insert(DevUser devUser);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DevUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DevUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DevUser> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<DevUser> entities);

    /**
     * 修改数据
     *
     * @param devUser 实例对象
     * @return 影响行数
     */
    int update(DevUser devUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

