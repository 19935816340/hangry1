package com.company.Dao.Impl;

import com.company.Dao.Business;
import com.company.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BusinessDaoImpl implements Business {
    private Connection conn = null;
    private PreparedStatement ps =null;
    ResultSet rs =null;
    @Override
    public void add(com.company.domain.Business business) throws SQLException {
        com.company.domain.Business business1 = new com.company.domain.Business();
        conn = JDBCUtils.getConnection();
        conn.getAutoCommit();
        String sql = "insert into business (password,businessName,businessAddress,businessExplain,starPrice,deliveryPrice)values(?,?,?,?,?,?);";
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1,business.getPassword());
            ps.setString(2,business.getName());
            ps.setString(3,business.getAddr());
            ps.setString(4,business.getEx());
            ps.setBigDecimal(5,business.getStarPrice());
            ps.setBigDecimal(6,business.getSendPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            try{
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }


    }

    @Override
    public com.company.domain.Business login(int u, String p) {
        StringBuilder stringBuilder = new StringBuilder();
        com.company.domain.Business business = new com.company.domain.Business();
        String sql = "select * from business where businessId = ? and password = ?;";
        try{

            conn = JDBCUtils.getConnection();
            conn.getAutoCommit();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,u);
            ps.setString(2,p);
            rs = ps.executeQuery();
            if (rs.next()){
                business.setId(rs.getInt(1));
                business.setAddr(rs.getString(4));
                business.setEx(rs.getString(5));
                business.setPassword(rs.getString(2));
                business.setName(rs.getString(3));
                business.setSendPrice(rs.getBigDecimal(7));
                business.setStarPrice(rs.getBigDecimal(6));
                System.out.println("登录成功");
            }

        } catch (Exception e) {
            System.out.println("登录失败");
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return business;
    }

    @Override
    public ArrayList<com.company.domain.Business> souSuo(String name,String n) {
        ArrayList<com.company.domain.Business> list = new ArrayList<>();
        if (n.equalsIgnoreCase("y")){
        String sql ="select * from business where businessName like ?;";
        try{
            conn = JDBCUtils.getConnection();
            conn.getAutoCommit();
            ps = conn.prepareStatement(sql);
            ps.setString(1,"%"+name+"%");
            rs = ps.executeQuery();
            while (rs.next()){
                com.company.domain.Business business = new com.company.domain.Business();
                business.setId(rs.getInt(1));
                business.setAddr(rs.getString(4));
                business.setEx(rs.getString(5));
                business.setPassword(rs.getString(2));
                business.setName(rs.getString(3));
                business.setSendPrice(rs.getBigDecimal(7));
                business.setStarPrice(rs.getBigDecimal(6));
                list.add(business);
                System.out.println(business);
            }
        } catch (SQLException e) {
            try{
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return list;
    }else {
            String sql ="select * from business where businessAddress like ?;";
            try{
                conn = JDBCUtils.getConnection();
                conn.getAutoCommit();
                ps = conn.prepareStatement(sql);
                ps.setString(1,"%"+name+"%");
                rs = ps.executeQuery();
                while (rs.next()){
                    com.company.domain.Business business = new com.company.domain.Business();
                    business.setId(rs.getInt(1));
                    business.setAddr(rs.getString(4));
                    business.setEx(rs.getString(5));
                    business.setPassword(rs.getString(2));
                    business.setName(rs.getString(3));
                    business.setSendPrice(rs.getBigDecimal(7));
                    business.setStarPrice(rs.getBigDecimal(6));
                    list.add(business);
                    System.out.println(business);
                }
            } catch (SQLException e) {
                try{
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                e.printStackTrace();
            }
            return list;
        }
    }

    @Override
    public void drop(Integer id) {
        String sql = "delete from business where businessId = ? ;";
        try{
            conn = JDBCUtils.getConnection();
            conn.getAutoCommit();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
        } catch (Exception e) {
            try{
                conn.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<com.company.domain.Business> findAll() throws SQLException {
        ArrayList<com.company.domain.Business> list = new ArrayList<>();
        String sql = "select * from business where ?;";
        try{
            conn = JDBCUtils.getConnection();
            conn.getAutoCommit();
            ps = conn.prepareStatement(sql);
            ps.setString(1,"1=1");
            rs = ps.executeQuery();
            while (rs.next()){
                com.company.domain.Business business = new com.company.domain.Business();
                business.setId(rs.getInt(1));
                business.setAddr(rs.getString(4));
                business.setEx(rs.getString(5));
                business.setPassword(rs.getString(2));
                business.setName(rs.getString(3));
                business.setSendPrice(rs.getBigDecimal(7));
                business.setStarPrice(rs.getBigDecimal(6));
                System.out.println(business);
                list.add(business);
            }

        } catch (SQLException e) {
            try{
                conn.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return list;

    }
}

