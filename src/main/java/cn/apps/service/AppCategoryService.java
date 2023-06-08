package cn.apps.service;

import cn.apps.pojo.AppCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Siyu
 */
public interface AppCategoryService {
    /**
     * 查询分类
     * @param parentId
     * @return
     */List<AppCategory> queryParent(Integer parentId);
}