package cn.apps.dao;

import cn.apps.pojo.AppInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Siyu
 */
public interface AppInfoDao {

    /**
     * 查询指定行数据
     * 查询条件
     * @param softwareName
     * @param state
     * @param platform
     * @param one
     * @param tow
     * @param three
     * @param pageBegin 分页对象
     * @param pageSize 分页大小
     * @return 对象列表
     */
    List<AppInfo> queryAllByLimit(@Param("softwareName")String softwareName,
                                  @Param("state")Integer state,
                                  @Param("platform")Integer platform,
                                  @Param("one")Integer one,
                                  @Param("tow")Integer tow,
                                  @Param("three")Integer three,
                                  @Param("pageBegin") Integer pageBegin,
                                  @Param("pageSize") Integer pageSize);

    /**
     * 查询指定行数据
     * 查询条件
     * @param softwareName
     * @param state
     * @param platform
     * @param one
     * @param tow
     * @param three
     * @return 对象列表
     */
    Integer queryCountByLimit(@Param("softwareName")String softwareName,
                                  @Param("state")Integer state,
                                  @Param("platform")Integer platform,
                                  @Param("one")Integer one,
                                  @Param("tow")Integer tow,
                                  @Param("three")Integer three);


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AppInfo queryById(@Param("id")Integer id);

    /**
     * 修改数据
     *
     * @param appInfo 实例对象
     * @return 影响行数
     */
    int update(AppInfo appInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(@Param("id")Integer id);
}