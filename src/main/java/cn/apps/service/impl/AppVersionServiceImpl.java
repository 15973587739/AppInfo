package cn.apps.service.impl;


import cn.apps.dao.AppCategoryDao;
import cn.apps.dao.AppVersionDao;
import cn.apps.pojo.AppCategory;
import cn.apps.pojo.AppVersion;
import cn.apps.service.AppCategoryService;
import cn.apps.service.AppVersionService;
import cn.apps.utils.EmptyUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DevUser)表服务实现类
 *
 * @author siyu
 * @since 2023-06-07 10:07:51
 */
@Transactional
@Service("AppVersionService")
public class AppVersionServiceImpl implements AppVersionService {
    @Resource
    private AppVersionDao appVersionDao;

    @Override
    public AppVersion queryVersion(Integer id,Integer appId){
        AppVersion version = null;
        try {
            version = appVersionDao.queryVersion(id,appId);//版本号
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
        return version;
    }

    @Override
    public List<AppVersion> queryVersionInfo(Integer id, Integer appId) {
        List<AppVersion> list = null;
        try {
            list = appVersionDao.queryVersionInfo(id,appId);//版本号
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
        return list;
    }

    @Override
    public int insert(AppVersion appVersion) {
        Integer result = 0;
        try {
            result = appVersionDao.insert(appVersion);//对象
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }
}
