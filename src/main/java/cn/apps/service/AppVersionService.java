package cn.apps.service;

import cn.apps.pojo.AppVersion;
import org.apache.ibatis.annotations.Param;

/**
 * @author Siyu
 */
public interface AppVersionService {
    AppVersion queryVersion(Integer id,Integer appId);
}