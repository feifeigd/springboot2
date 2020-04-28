package com.d7kj.service;

public interface CreditSystemService {
    public int getUserCredit(int userId);
    public boolean addCredit(int userId, int score);
}
