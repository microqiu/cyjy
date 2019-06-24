package com.linfeiyang.shop.mybatis.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.shortDescribe
     *
     * @mbggenerated
     */
    private String shortDescribe;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.image
     *
     * @mbggenerated
     */
    private String image;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.inventory
     *
     * @mbggenerated
     */
    private Integer inventory;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.price
     *
     * @mbggenerated
     */
    private BigDecimal price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.unit
     *
     * @mbggenerated
     */
    private String unit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.barCode
     *
     * @mbggenerated
     */
    private String barCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.standard
     *
     * @mbggenerated
     */
    private String standard;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.discount
     *
     * @mbggenerated
     */
    private BigDecimal discount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.createTime
     *
     * @mbggenerated
     */
    private Integer createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.updateTime
     *
     * @mbggenerated
     */
    private Integer updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product.describe
     *
     * @mbggenerated
     */
    private String describe;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_product
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.id
     *
     * @return the value of t_product.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.id
     *
     * @param id the value for t_product.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.name
     *
     * @return the value of t_product.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.name
     *
     * @param name the value for t_product.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.shortDescribe
     *
     * @return the value of t_product.shortDescribe
     *
     * @mbggenerated
     */
    public String getShortDescribe() {
        return shortDescribe;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.shortDescribe
     *
     * @param shortDescribe the value for t_product.shortDescribe
     *
     * @mbggenerated
     */
    public void setShortDescribe(String shortDescribe) {
        this.shortDescribe = shortDescribe == null ? null : shortDescribe.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.image
     *
     * @return the value of t_product.image
     *
     * @mbggenerated
     */
    public String getImage() {
        return image;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.image
     *
     * @param image the value for t_product.image
     *
     * @mbggenerated
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.inventory
     *
     * @return the value of t_product.inventory
     *
     * @mbggenerated
     */
    public Integer getInventory() {
        return inventory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.inventory
     *
     * @param inventory the value for t_product.inventory
     *
     * @mbggenerated
     */
    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.price
     *
     * @return the value of t_product.price
     *
     * @mbggenerated
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.price
     *
     * @param price the value for t_product.price
     *
     * @mbggenerated
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.unit
     *
     * @return the value of t_product.unit
     *
     * @mbggenerated
     */
    public String getUnit() {
        return unit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.unit
     *
     * @param unit the value for t_product.unit
     *
     * @mbggenerated
     */
    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.barCode
     *
     * @return the value of t_product.barCode
     *
     * @mbggenerated
     */
    public String getBarCode() {
        return barCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.barCode
     *
     * @param barCode the value for t_product.barCode
     *
     * @mbggenerated
     */
    public void setBarCode(String barCode) {
        this.barCode = barCode == null ? null : barCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.standard
     *
     * @return the value of t_product.standard
     *
     * @mbggenerated
     */
    public String getStandard() {
        return standard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.standard
     *
     * @param standard the value for t_product.standard
     *
     * @mbggenerated
     */
    public void setStandard(String standard) {
        this.standard = standard == null ? null : standard.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.discount
     *
     * @return the value of t_product.discount
     *
     * @mbggenerated
     */
    public BigDecimal getDiscount() {
        return discount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.discount
     *
     * @param discount the value for t_product.discount
     *
     * @mbggenerated
     */
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.createTime
     *
     * @return the value of t_product.createTime
     *
     * @mbggenerated
     */
    public Integer getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.createTime
     *
     * @param createTime the value for t_product.createTime
     *
     * @mbggenerated
     */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.updateTime
     *
     * @return the value of t_product.updateTime
     *
     * @mbggenerated
     */
    public Integer getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.updateTime
     *
     * @param updateTime the value for t_product.updateTime
     *
     * @mbggenerated
     */
    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product.describe
     *
     * @return the value of t_product.describe
     *
     * @mbggenerated
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product.describe
     *
     * @param describe the value for t_product.describe
     *
     * @mbggenerated
     */
    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }
}