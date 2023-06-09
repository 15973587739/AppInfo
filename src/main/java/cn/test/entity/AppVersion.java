package cn.test.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (AppVersion)实体类
 *
 * @author makejava
 * @since 2023-06-07 10:21:38
 */
public class AppVersion implements Serializable {
    private static final long serialVersionUID = -90288661495920239L;
    /**
     * 主键id
     */
    private Long id;
    /**
     * appId（来源于：app_info表的主键id）
     */
    private Long appid;
    /**
     * 版本号
     */
    private String versionno;
    /**
     * 版本介绍
     */
    private String versioninfo;
    /**
     * 发布状态（来源于：data_dictionary，1 不发布 2 已发布 3 预发布）
     */
    private Long publishstatus;
    /**
     * 下载链接
     */
    private String downloadlink;
    /**
     * 版本大小（单位：M）
     */
    private Double versionsize;
    /**
     * 创建者（来源于dev_user开发者信息表的用户id）
     */
    private Long createdby;
    /**
     * 创建时间
     */
    private Date creationdate;
    /**
     * 更新者（来源于dev_user开发者信息表的用户id）
     */
    private Long modifyby;
    /**
     * 最新更新时间
     */
    private Date modifydate;
    /**
     * apk文件的服务器存储路径
     */
    private String apklocpath;
    /**
     * 上传的apk文件名称
     */
    private String apkfilename;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppid() {
        return appid;
    }

    public void setAppid(Long appid) {
        this.appid = appid;
    }

    public String getVersionno() {
        return versionno;
    }

    public void setVersionno(String versionno) {
        this.versionno = versionno;
    }

    public String getVersioninfo() {
        return versioninfo;
    }

    public void setVersioninfo(String versioninfo) {
        this.versioninfo = versioninfo;
    }

    public Long getPublishstatus() {
        return publishstatus;
    }

    public void setPublishstatus(Long publishstatus) {
        this.publishstatus = publishstatus;
    }

    public String getDownloadlink() {
        return downloadlink;
    }

    public void setDownloadlink(String downloadlink) {
        this.downloadlink = downloadlink;
    }

    public Double getVersionsize() {
        return versionsize;
    }

    public void setVersionsize(Double versionsize) {
        this.versionsize = versionsize;
    }

    public Long getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Long createdby) {
        this.createdby = createdby;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Long getModifyby() {
        return modifyby;
    }

    public void setModifyby(Long modifyby) {
        this.modifyby = modifyby;
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    public String getApklocpath() {
        return apklocpath;
    }

    public void setApklocpath(String apklocpath) {
        this.apklocpath = apklocpath;
    }

    public String getApkfilename() {
        return apkfilename;
    }

    public void setApkfilename(String apkfilename) {
        this.apkfilename = apkfilename;
    }

}

