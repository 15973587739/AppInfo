package cn.test.dao;

import cn.test.entity.AppVersion;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (AppVersion)表数据库访问层
 *
 * @author makejava
 * @since 2023-06-07 10:21:38
 */
public interface AppVersionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AppVersion queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param appVersion 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<AppVersion> queryAllByLimit(AppVersion appVersion, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param appVersion 查询条件
     * @return 总行数
     */
    long count(AppVersion appVersion);

    /**
     * 新增数据
     *
     * @param appVersion 实例对象
     * @return 影响行数
     */
    int insert(AppVersion appVersion);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<AppVersion> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<AppVersion> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<AppVersion> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<AppVersion> entities);

    /**
     * 修改数据
     *
     * @param appVersion 实例对象
     * @return 影响行数
     */
    int update(AppVersion appVersion);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

