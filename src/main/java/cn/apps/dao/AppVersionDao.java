package cn.apps.dao;

import cn.apps.pojo.AppVersion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Siyu
 */
public interface AppVersionDao {
    AppVersion queryVersion(@Param("id")Integer id,@Param("appId")Integer appId);
}