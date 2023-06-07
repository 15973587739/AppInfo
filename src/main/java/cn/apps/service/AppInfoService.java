package cn.apps.service;


import cn.apps.pojo.AppInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (AppInfo)表服务接口
 *
 * @author siyu
 * @since 2023-06-07 10:21:18
 */
public interface AppInfoService {
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
    List<AppInfo> queryAllByLimit(String softwareName,
                                  Integer state,
                                  Integer platform,
                                  Integer one,
                                  Integer tow,
                                  Integer three,
                                  Integer pageBegin,
                                  Integer pageSize);

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
    Integer queryCountByLimit(String softwareName,
                              Integer state,
                              Integer platform,
                              Integer one,
                              Integer tow,
                              Integer three);


}
