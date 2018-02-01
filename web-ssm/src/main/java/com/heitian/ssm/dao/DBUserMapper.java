package com.heitian.ssm.dao;

import com.heitian.ssm.model.DBUser;
import com.heitian.ssm.model.DBUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DBUserMapper {
    int countByExample(DBUserExample example);

    int deleteByExample(DBUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DBUser record);

    int insertSelective(DBUser record);

    List<DBUser> selectByExample(DBUserExample example);

    DBUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DBUser record, @Param("example") DBUserExample example);

    int updateByExample(@Param("record") DBUser record, @Param("example") DBUserExample example);

    int updateByPrimaryKeySelective(DBUser record);

    int updateByPrimaryKey(DBUser record);
}