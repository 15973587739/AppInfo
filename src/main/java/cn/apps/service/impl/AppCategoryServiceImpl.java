package cn.apps.service.impl;


import cn.apps.dao.AppCategoryDao;
import cn.apps.dao.DataDictionaryDao;
import cn.apps.pojo.AppCategory;
import cn.apps.pojo.DataDictionary;
import cn.apps.service.AppCategoryService;
import cn.apps.service.DataDictionaryService;
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
@Service("AppCategoryService")
public class AppCategoryServiceImpl implements AppCategoryService {
    @Resource
    private AppCategoryDao appCategoryDao;


    @Override
    public List<AppCategory> queryParent(String parentId) {
        List<AppCategory> list = new ArrayList<AppCategory>();
        try {
            list = appCategoryDao.queryParent(parentId);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
        return list;
    }
}
