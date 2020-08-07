package com.company.Dao;

import com.company.domain.Admin;

public interface AdminDao {
    public Admin get(String adminName,String password);

}
