package cn.apps.dao;

import cn.apps.pojo.AppCategory;
import cn.apps.pojo.DataDictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Siyu
 */
public interface AppCategoryDao {
    List<AppCategory> queryParent(@Param("parentId")String parentId);
}