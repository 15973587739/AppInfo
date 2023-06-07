package cn.apps.dao;

import cn.apps.pojo.AppInfo;
import cn.apps.pojo.DataDictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Siyu
 */
public interface DataDictionaryDao {
    List<DataDictionary> queryType(@Param("typeCode")String typeCode);
}