package cn.apps.service;

import cn.apps.pojo.DataDictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Siyu
 */
public interface DataDictionaryService {
    List<DataDictionary> queryType(String typeCode);
}