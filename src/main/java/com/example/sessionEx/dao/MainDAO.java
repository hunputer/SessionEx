package com.example.sessionEx.dao;

import com.example.sessionEx.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainDAO {

    List<UserVO> getUser();
}
