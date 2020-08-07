package com.company.Dao.Impl;

import com.company.Dao.Business;
import com.company.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BusinessDaoImpl implements Business {
    private Connection conn = null;
    private PreparedStatement ps =null;
    @Override
    public void add(com.company.domain.Business business) throws SQLException {
        com.company.domain.Business business1 = new com.company.domain.Business();
        conn = JDBCUtils.getConnection();
        conn.getAutoCommit();
        String sql = "insert into business (password,businessName,businessAddress,businessExplain,starPrice,deliveryPrice)values(?,?,?,?,?,?)";
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
}

