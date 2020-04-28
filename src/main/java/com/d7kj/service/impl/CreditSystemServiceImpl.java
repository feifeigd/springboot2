package com.d7kj.service.impl;

import com.d7kj.service.CreditSystemService;
import org.springframework.stereotype.Service;

@Service
public class CreditSystemServiceImpl implements CreditSystemService {
    @Override
    public int getUserCredit(int userId) {
        throw new UnsupportedOperationException("积分系统未完成，不能调用");
        //return 0;
    }

    @Override
    public boolean addCredit(int userId, int score) {
        throw new UnsupportedOperationException("积分系统未完成，不能调用");
        //return false;
    }
}
