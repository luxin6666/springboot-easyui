package com.luxin.springboot01.mapper;

import com.luxin.springboot01.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("select * from product limit #{page},#{rows}")
    List<Product> getProducts(int page,int rows);

    @Insert("insert into product values(null,#{name},#{price},#{num})")
    int saveProduct(Product product);

    @Delete("delete from product where id = #{id}")
    int delProduct(int id);

    @Update("update product set name=#{name},price=#{price},num=#{num} where id=#{id}")
    int updateProduct(Product product);

    @Select("select * from product where name like concat(concat('%',#{name}),'%') limit #{page},#{rows}")
    List<Product> getProductsByName(int page, int rows, String name);

    @Select("select count(*) from product")
    int getCount();

    @Select("select count(*) from product where name like concat(concat('%',#{name}),'%')")
    int getCountByName(String name);

    @Update("update product set num=#{allNum} where id=#{id}")
    int updateProductNum(int id, int allNum);
}
