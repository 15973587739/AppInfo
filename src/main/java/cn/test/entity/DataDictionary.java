package cn.test.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (DataDictionary)实体类
 *
 * @author makejava
 * @since 2023-06-07 10:22:11
 */
public class DataDictionary implements Serializable {
    private static final long serialVersionUID = 274893102749725241L;
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 类型编码
     */
    private String typecode;
    /**
     * 类型名称
     */
    private String typename;
    /**
     * 类型值ID
     */
    private Long valueid;
    /**
     * 类型值Name
     */
    private String valuename;
    /**
     * 创建者（来源于backend_user用户表的用户id）
     */
    private Long createdby;
    /**
     * 创建时间
     */
    private Date creationdate;
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

    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Long getValueid() {
        return valueid;
    }

    public void setValueid(Long valueid) {
        this.valueid = valueid;
    }

    public String getValuename() {
        return valuename;
    }

    public void setValuename(String valuename) {
        this.valuename = valuename;
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

}

