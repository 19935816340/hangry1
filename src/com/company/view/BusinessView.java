package com.company.view;

import com.company.domain.Business;

import java.sql.SQLException;

public interface BusinessView {

    //public void add(com.company.domain.Business business) throws SQLException;
    //    public com.company.domain.Business login(String u, String p);
    //    public ArrayList<com.company.domain.Business> souSuo(String name);
    //    public void drop(Integer id);
    //    public ArrayList<com.company.domain.Business> findAll() throws SQLException;


    // 登录
    public Business login();
    //删除
    public void drop();
    //添加
    public void add() throws SQLException;
    //搜索
    public void souSuo();
    //查找所有的店铺
    public void findAll() throws SQLException;
}
