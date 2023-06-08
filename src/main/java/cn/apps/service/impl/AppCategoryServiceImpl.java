package cn.apps.service.impl;


import cn.apps.dao.AppCategoryDao;
import cn.apps.dao.DataDictionaryDao;
import cn.apps.pojo.AppCategory;
import cn.apps.pojo.DataDictionary;
import cn.apps.service.AppCategoryService;
import cn.apps.service.DataDictionaryService;
import cn.apps.utils.EmptyUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (DevUser)表服务实现类
 *
 * @author siyu
 * @since 2023-06-07 10:07:51
 */
@Transactional
@Service("AppCategoryService")
public class AppCategoryServiceImpl implements AppCategoryService {
    @Resource
    private AppCategoryDao appCategoryDao;


    /**
     * 查询子分类
     * @param parentId
     * @return
     */
    @Override
    public List<AppCategory> queryParent(Integer parentId) {
        List<AppCategory> list = null ;
        try {
            if (EmptyUtils.isNotEmpty(parentId)){
                list = appCategoryDao.queryParent(parentId);//子分类
            }else {
                list = appCategoryDao.queryParent(0);//父分类
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
        return list;
    }



}
