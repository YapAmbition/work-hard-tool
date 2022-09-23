package com.nikfce.wht.work.hard.tool.dao.mapper;

import com.nikfce.wht.work.hard.tool.dao.entity.UserTb;
import com.nikfce.wht.work.hard.tool.dao.entity.UserTbExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

public interface UserTbMapper {
    long countByExample(UserTbExample example);

    int deleteByExample(UserTbExample example);

    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into user (email, serial_number, ",
        "nick_name, password, ",
        "is_delete, created_at, ",
        "updated_at)",
        "values (#{email,jdbcType=VARCHAR}, #{serialNumber,jdbcType=BIGINT}, ",
        "#{nickName,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{isDelete,jdbcType=TINYINT}, #{createdAt,jdbcType=TIMESTAMP}, ",
        "#{updatedAt,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(UserTb record);

    int insertSelective(UserTb record);

    List<UserTb> selectByExampleWithRowbounds(UserTbExample example, RowBounds rowBounds);

    List<UserTb> selectByExample(UserTbExample example);

    @Select({
        "select",
        "id, email, serial_number, nick_name, password, is_delete, created_at, updated_at",
        "from user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.nikfce.wht.work.hard.tool.dao.mapper.UserTbMapper.BaseResultMap")
    UserTb selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserTb record, @Param("example") UserTbExample example);

    int updateByExample(@Param("record") UserTb record, @Param("example") UserTbExample example);

    int updateByPrimaryKeySelective(UserTb record);

    @Update({
        "update user",
        "set email = #{email,jdbcType=VARCHAR},",
          "serial_number = #{serialNumber,jdbcType=BIGINT},",
          "nick_name = #{nickName,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "is_delete = #{isDelete,jdbcType=TINYINT},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "updated_at = #{updatedAt,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserTb record);
}