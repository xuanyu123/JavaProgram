package com.controller;

import com.domain.User;
import com.domain.WantBuy;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.WantBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/message")
public class WantBuyController {
    @Autowired
    private WantBuyService wantBuyService;

    /**
     * 添加数据
     * @param wantBuy
     * @return
     */
    @RequestMapping(value = "/setMessage.do",method = {RequestMethod.POST})
    public void setMessage(@RequestBody WantBuy wantBuy, HttpServletResponse response) throws IOException {
        int count = wantBuyService.addMessage(wantBuy);
        HashMap<String, Integer> map = new HashMap<>();
        if(count == 1){
            map.put("code",1);
        }else{
            map.put("code",0);
        }
        response.getWriter().write(new ObjectMapper().writeValueAsString(map));
    }

    /**
     * 查询所有留言
     * @param
     * @return
     */
    @RequestMapping(value = "/getMessage.do",method = {RequestMethod.GET})
    public @ResponseBody List<WantBuy> findAll(){
        return wantBuyService.findAll();
    }

    /**
     * 删除
     * @param
     * @return
     */
    @RequestMapping(value = "/deleteMessage.do",method = {RequestMethod.POST})
    public void deleteMessage(@RequestBody Integer msgId,HttpServletResponse response) throws IOException {
        int code = wantBuyService.deleteMessageById(msgId);

    }
}
