package com.MeYok.dao;

import com.MeYok.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDao {

    @Select("SELECT * FROM tbl_book WHERE id = #{id}")
    Book getById(Integer id);

}
