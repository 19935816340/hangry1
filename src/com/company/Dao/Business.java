package com.company.Dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Business {
    public void add(com.company.domain.Business business) throws SQLException;
    public com.company.domain.Business login(int u, String p);
    public ArrayList<com.company.domain.Business> souSuo(String name,String n);
    public void drop(Integer id);
    public ArrayList<com.company.domain.Business> findAll() throws SQLException;
}
