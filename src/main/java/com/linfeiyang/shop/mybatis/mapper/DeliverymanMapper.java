package com.linfeiyang.shop.mybatis.mapper;

import com.linfeiyang.shop.mybatis.model.Deliveryman;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface DeliverymanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_deliveryman
     *
     * @mbggenerated
     */
    @Insert({
        "insert into t_deliveryman (id, username, ",
        "openId, realName, ",
        "phone, createTime)",
        "values (#{id,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
        "#{openId,jdbcType=VARCHAR}, #{realName,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{createTime,jdbcType=INTEGER})"
    })
    int insert(Deliveryman record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_deliveryman
     *
     * @mbggenerated
     */
    int insertSelective(Deliveryman record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_deliveryman
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "id, username, openId, realName, phone, createTime",
        "from t_deliveryman",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Deliveryman selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_deliveryman
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Deliveryman record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_deliveryman
     *
     * @mbggenerated
     */
    @Update({
        "update t_deliveryman",
        "set username = #{username,jdbcType=VARCHAR},",
          "openId = #{openId,jdbcType=VARCHAR},",
          "realName = #{realName,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "createTime = #{createTime,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Deliveryman record);
}