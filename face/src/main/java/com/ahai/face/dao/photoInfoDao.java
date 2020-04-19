package com.ahai.face.dao;

import com.ahai.face.photo.photoInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface photoInfoDao {

    //根据主键删除
    int deleteByPrimaryKey(Integer id);
    //插入数据
    int insert(photoInfo record);
    //选择性插入
    int insertSelective(photoInfo record);
    //根据主键查询
    photoInfo selectByPrimaryKey(Integer id);
    //根据主键选择性更新
    int updateByPrimaryKeySelective(photoInfo record);
    //更新全部
    int updateByPrimaryKey(photoInfo record);
    //查询所有的数据
    int count();
}
