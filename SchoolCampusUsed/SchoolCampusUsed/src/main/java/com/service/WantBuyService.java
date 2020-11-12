package com.service;

import com.domain.WantBuy;

import java.util.List;

public interface WantBuyService {
    /*查询列表所有数据*/
    List<WantBuy> findAll();

    /*根据id删除评论*/
    int deleteMessageById(Integer id);

    /*添加留言*/
    int addMessage(WantBuy wantBuy);
}
