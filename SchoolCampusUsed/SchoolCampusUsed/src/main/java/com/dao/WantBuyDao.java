package com.dao;

import com.domain.WantBuy;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WantBuyDao {
    /*查询所有*/
    @Select("select * from wantbuy order by id desc")
    List<WantBuy> findAll();

    /*根据id删除留言*/
    @Delete("delete from wantbuy where id = #{id}")
    int deleteMessageById(Integer id);

    /*添加数据*/
    @Insert("insert into wantbuy values(null, #{username}, #{message})")
    int addWantBuy(WantBuy wantBuy);
}
