package com.manager.model;

import java.io.Serializable;

public class City implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 类型，1为省，2为市
     */
    private Integer type;

    /**
     * 归属省份
     */
    private Long parentId;

    /**
     * 名称
     */
    private String name;

    /**
     * 简称
     */
    private String abbr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return 类型，1为省，2为市
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type
     *            类型，1为省，2为市
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return 归属省份
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * @param parentid
     *            归属省份
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * @return 名称
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return 简称
     */
    public String getAbbr() {
        return abbr;
    }

    /**
     * @param abbr
     *            简称
     */
    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }
}
