package com.service.impl;

import com.dao.WantBuyDao;
import com.domain.WantBuy;
import com.service.WantBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WantBuyServiceImpl implements WantBuyService {
    @Autowired
    private WantBuyDao wantBuyDao;

    @Override
    public List<WantBuy> findAll() {
        return wantBuyDao.findAll();
    }

    @Override
    public int deleteMessageById(Integer id) {
        return wantBuyDao.deleteMessageById(id);
    }

    @Override
    public int addMessage(WantBuy wantBuy) {
        int count = wantBuyDao.addWantBuy(wantBuy);
        return count;
    }
}
