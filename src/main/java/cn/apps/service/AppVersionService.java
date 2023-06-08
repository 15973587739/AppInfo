package cn.apps.service;

import cn.apps.pojo.AppVersion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Siyu
 */
public interface AppVersionService {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @param appId 主键
     * @return 实例对象
     */
    AppVersion queryVersion(Integer id,Integer appId);
    /**
     * 通过ID查询多条数据
     *
     * @param id 主键
     * @param appId 主键
     * @return 实例对象
     */
    List<AppVersion> queryVersionInfo(Integer id,Integer appId);
    /**
     * 新增数据
     *
     * @param appVersion 实例对象
     * @return 影响行数
     */
    int insert(AppVersion appVersion);
}