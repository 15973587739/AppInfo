package cn.test.service;

import cn.test.entity.DataDictionary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (DataDictionary)表服务接口
 *
 * @author makejava
 * @since 2023-06-07 10:22:11
 */
public interface DataDictionaryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DataDictionary queryById(Long id);

    /**
     * 分页查询
     *
     * @param dataDictionary 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<DataDictionary> queryByPage(DataDictionary dataDictionary, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param dataDictionary 实例对象
     * @return 实例对象
     */
    DataDictionary insert(DataDictionary dataDictionary);

    /**
     * 修改数据
     *
     * @param dataDictionary 实例对象
     * @return 实例对象
     */
    DataDictionary update(DataDictionary dataDictionary);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
