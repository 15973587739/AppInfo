package cn.apps.service.impl;


import cn.apps.dao.AppInfoDao;
import cn.apps.dao.DevUserDao;
import cn.apps.pojo.AppInfo;
import cn.apps.pojo.DevUser;
import cn.apps.service.AppInfoService;
import cn.apps.service.DevUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (DevUser)表服务实现类
 *
 * @author makejava
 * @since 2023-06-07 10:07:51
 */
@Transactional
@Service("AppInfoService")
public class AppInfoServiceImpl implements AppInfoService{
    @Resource
    private AppInfoDao appInfoDao;

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
    @Override
    public List<AppInfo> queryAllByLimit(String softwareName, Integer state, Integer platform, Integer one, Integer tow, Integer three, Integer pageBegin, Integer pageSize) {
        List<AppInfo> list = new ArrayList<AppInfo>();
        try {
            list = appInfoDao.queryAllByLimit(softwareName, state, platform, one, tow, three,(pageBegin-1)*pageSize, pageSize);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
        return list;
    }


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
    @Override
    public Integer queryCountByLimit(String softwareName, Integer state, Integer platform, Integer one, Integer tow, Integer three) {
        Integer result = 0;
        try {
            result = appInfoDao.queryCountByLimit(softwareName, state, platform, one, tow, three);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }
}
