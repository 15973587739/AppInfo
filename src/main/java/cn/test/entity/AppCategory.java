package cn.test.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 手游类别(AppCategory)实体类
 *
 * @author makejava
 * @since 2023-06-07 10:20:14
 */
public class AppCategory implements Serializable {
    private static final long serialVersionUID = -43428166019381472L;
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 分类编码
     */
    private String categorycode;
    /**
     * 分类名称
     */
    private String categoryname;
    /**
     * 父级节点id
     */
    private Long parentid;
    /**
     * 创建者（来源于backend_user用户表的用户id）
     */
    private Long createdby;
    /**
     * 创建时间
     */
    private Date creationtime;
    /**
     * 更新者（来源于backend_user用户表的用户id）
     */
    private Long modifyby;
    /**
     * 最新更新时间
     */
    private Date modifydate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategorycode() {
        return categorycode;
    }

    public void setCategorycode(String categorycode) {
        this.categorycode = categorycode;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public Long getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Long createdby) {
        this.createdby = createdby;
    }

    public Date getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
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

}

