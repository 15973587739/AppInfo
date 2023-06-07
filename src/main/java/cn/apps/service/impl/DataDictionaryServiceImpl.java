package cn.apps.service.impl;


import cn.apps.dao.AppInfoDao;
import cn.apps.dao.DataDictionaryDao;
import cn.apps.pojo.AppInfo;
import cn.apps.pojo.DataDictionary;
import cn.apps.service.AppInfoService;
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
@Service("DataDictionaryService")
public class DataDictionaryServiceImpl implements DataDictionaryService {
    @Resource
    private DataDictionaryDao dictionaryDao;


    @Override
    public List<DataDictionary> queryType(String typeCode) {
        List<DataDictionary> list = new ArrayList<DataDictionary>();
        try {
            list = dictionaryDao.queryType(typeCode);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
        return list;
    }
}
