package cn.apps.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * app_info
 * @author 
 */
public class AppInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 软件名称
     */
    private String softwareName;

    /**
     * APK名称（唯一）
     */
    private String APKName;

    /**
     * 支持ROM
     */
    private String supportROM;

    /**
     * 界面语言
     */
    private String interfaceLanguage;

    /**
     * 软件大小（单位：M）
     */
    private BigDecimal softwareSize;

    /**
     * 更新日期
     */
    private Date updateDate;

    /**
     * 开发者id（来源于：dev_user表的开发者id）
     */
    private Integer devId;

    /**
     * 应用简介
     */
    private String appInfo;

    /**
     * 状态（来源于：data_dictionary，1 待审核 2 审核通过 3 审核不通过 4 已上架 5 已下架）
     */
    private Integer status;

    /**
     * 上架时间
     */
    private Date onSaleDate;

    /**
     * 下架时间
     */
    private Date offSaleDate;

    /**
     * 所属平台（来源于：data_dictionary，1 手机 2 平板 3 通用）
     */
    private Integer flatformId;



    /**
     * 下载量（单位：次）
     */
    private Integer downloads;

    /**
     * 创建者（来源于dev_user开发者信息表的用户id）
     */
    private Integer createdBy;

    /**
     * 创建时间
     */
    private Date creationDate;

    /**
     * 更新者（来源于dev_user开发者信息表的用户id）
     */
    private Integer modifyBy;

    /**
     * 最新更新时间
     */
    private Date modifyDate;

    /**
     * 所属一级分类（来源于：data_dictionary）
     */
    private Integer categoryLevel1;

    /**
     * 所属二级分类（来源于：data_dictionary）
     */
    private Integer categoryLevel2;
    /**
     * 所属三级分类（来源于：data_dictionary）
     */
    private Integer categoryLevel3;

    /**
     * LOGO图片url路径
     */
    private String logoPicPath;

    /**
     * LOGO图片的服务器存储路径
     */
    private String logoLocPath;

    /**
     * 最新的版本id
     */
    private Integer versionId;

    /**
     * 平台类型类
     */
    private DataDictionary flDictionary;
    /**
     * 状态类型类
     */
    private DataDictionary stDictionary;
    /**
     * 所属分类
     */
    private AppCategory one;
    private AppCategory two;
    private AppCategory three;
    /**
     * 版本
     */
    private AppVersion appVersion;




    /**
     * 主键id
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 软件名称
     */
    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    /**
     * APK名称（唯一）
     */
    public String getAPKName() {
        return APKName;
    }

    public void setAPKName(String APKName) {
        this.APKName = APKName;
    }

    /**
     * 支持ROM
     */
    public String getSupportROM() {
        return supportROM;
    }

    public void setSupportROM(String supportROM) {
        this.supportROM = supportROM;
    }

    /**
     * 界面语言
     */
    public String getInterfaceLanguage() {
        return interfaceLanguage;
    }

    public void setInterfaceLanguage(String interfaceLanguage) {
        this.interfaceLanguage = interfaceLanguage;
    }

    /**
     * 软件大小（单位：M）
     */
    public BigDecimal getSoftwareSize() {
        return softwareSize;
    }

    public void setSoftwareSize(BigDecimal softwareSize) {
        this.softwareSize = softwareSize;
    }

    /**
     * 更新日期
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 开发者id（来源于：dev_user表的开发者id）
     */
    public Integer getDevId() {
        return devId;
    }

    public void setDevId(Integer devId) {
        this.devId = devId;
    }

    /**
     * 应用简介
     */
    public String getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(String appInfo) {
        this.appInfo = appInfo;
    }

    /**
     * 状态（来源于：data_dictionary，1 待审核 2 审核通过 3 审核不通过 4 已上架 5 已下架）
     */
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 上架时间
     */
    public Date getOnSaleDate() {
        return onSaleDate;
    }

    public void setOnSaleDate(Date onSaleDate) {
        this.onSaleDate = onSaleDate;
    }

    /**
     * 下架时间
     */
    public Date getOffSaleDate() {
        return offSaleDate;
    }

    public void setOffSaleDate(Date offSaleDate) {
        this.offSaleDate = offSaleDate;
    }

    /**
     * 所属平台（来源于：data_dictionary，1 手机 2 平板 3 通用）
     */
    public Integer getFlatformId() {
        return flatformId;
    }

    public void setFlatformId(Integer flatformId) {
        this.flatformId = flatformId;
    }

    /**
     * 下载量（单位：次）
     */
    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    /**
     * 创建者（来源于dev_user开发者信息表的用户id）
     */
    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 创建时间
     */
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * 更新者（来源于dev_user开发者信息表的用户id）
     */
    public Integer getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }

    /**
     * 最新更新时间
     */
    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * 所属一级分类（来源于：data_dictionary）
     */
    public Integer getCategoryLevel1() {
        return categoryLevel1;
    }

    public void setCategoryLevel1(Integer categoryLevel1) {
        this.categoryLevel1 = categoryLevel1;
    }

    /**
     * 所属二级分类（来源于：data_dictionary）
     */
    public Integer getCategoryLevel2() {
        return categoryLevel2;
    }

    public void setCategoryLevel2(Integer categoryLevel2) {
        this.categoryLevel2 = categoryLevel2;
    }

    /**
     * 所属三级分类（来源于：data_dictionary）
     */
    public Integer getCategoryLevel3() {
        return categoryLevel3;
    }

    public void setCategoryLevel3(Integer categoryLevel3) {
        this.categoryLevel3 = categoryLevel3;
    }

    /**
     * LOGO图片url路径
     */
    public String getLogoPicPath() {
        return logoPicPath;
    }

    public void setLogoPicPath(String logoPicPath) {
        this.logoPicPath = logoPicPath;
    }

    /**
     * LOGO图片的服务器存储路径
     */
    public String getLogoLocPath() {
        return logoLocPath;
    }

    public void setLogoLocPath(String logoLocPath) {
        this.logoLocPath = logoLocPath;
    }

    /**
     * 最新的版本id
     */
    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }


    public AppVersion getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(AppVersion appVersion) {
        this.appVersion = appVersion;
    }

    public DataDictionary getFlDictionary() {
        return flDictionary;
    }

    public void setFlDictionary(DataDictionary flDictionary) {
        this.flDictionary = flDictionary;
    }

    public DataDictionary getStDictionary() {
        return stDictionary;
    }

    public void setStDictionary(DataDictionary stDictionary) {
        this.stDictionary = stDictionary;
    }

    public AppCategory getOne() {
        return one;
    }

    public void setOne(AppCategory one) {
        this.one = one;
    }

    public AppCategory getTwo() {
        return two;
    }

    public void setTwo(AppCategory two) {
        this.two = two;
    }

    public AppCategory getThree() {
        return three;
    }

    public void setThree(AppCategory three) {
        this.three = three;
    }
}