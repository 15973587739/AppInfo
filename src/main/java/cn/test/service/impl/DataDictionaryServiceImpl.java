package cn.test.service.impl;

import cn.test.entity.DataDictionary;
import cn.test.dao.DataDictionaryDao;
import cn.test.service.DataDictionaryService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (DataDictionary)表服务实现类
 *
 * @author makejava
 * @since 2023-06-07 10:22:11
 */
@Service("dataDictionaryService")
public class DataDictionaryServiceImpl implements DataDictionaryService {
    @Resource
    private DataDictionaryDao dataDictionaryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DataDictionary queryById(Long id) {
        return this.dataDictionaryDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param dataDictionary 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<DataDictionary> queryByPage(DataDictionary dataDictionary, PageRequest pageRequest) {
        long total = this.dataDictionaryDao.count(dataDictionary);
        return new PageImpl<>(this.dataDictionaryDao.queryAllByLimit(dataDictionary, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param dataDictionary 实例对象
     * @return 实例对象
     */
    @Override
    public DataDictionary insert(DataDictionary dataDictionary) {
        this.dataDictionaryDao.insert(dataDictionary);
        return dataDictionary;
    }

    /**
     * 修改数据
     *
     * @param dataDictionary 实例对象
     * @return 实例对象
     */
    @Override
    public DataDictionary update(DataDictionary dataDictionary) {
        this.dataDictionaryDao.update(dataDictionary);
        return this.queryById(dataDictionary.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.dataDictionaryDao.deleteById(id) > 0;
    }
}
