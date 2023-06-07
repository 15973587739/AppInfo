package cn.apps.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 手游类别(AppCategory)实体类
 *
 * @author SIYU
 * @since 2023-06-07 09:46:21
 */
public class AppCategory implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 分类编码
     */
    private String categoryCode;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 父级节点id
     */
    private Integer parentId;

    /**
     * 创建者（来源于backend_user用户表的用户id）
     */
    private Integer createdBy;

    /**
     * 创建时间
     */
    private Date creationTime;

    /**
     * 更新者（来源于backend_user用户表的用户id）
     */
    private Integer modifyBy;

    /**
     * 最新更新时间
     */
    private Date modifyDate;



    /**
     * 主键ID
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 分类编码
     */
    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    /**
     * 分类名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * 父级节点id
     */
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 创建者（来源于backend_user用户表的用户id）
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
    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    /**
     * 更新者（来源于backend_user用户表的用户id）
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
}