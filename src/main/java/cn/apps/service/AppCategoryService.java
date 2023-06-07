package cn.apps.service;

import cn.apps.pojo.AppCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Siyu
 */
public interface AppCategoryService {
    List<AppCategory> queryParent(String parentId);
}