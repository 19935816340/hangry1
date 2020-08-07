package com.company.Dao.Impl;

import com.company.Dao.AdminDao;
import com.company.domain.Admin;
import com.company.utils.JDBCUtils;

import java.sql.*;

public class AdminDaoImpl implements AdminDao {
    private Connection conn = null;
    private PreparedStatement ps =null;
    private ResultSet rs = null;

    @Override
    public Admin get(String adminName,String password) {
        String sql = "select * from admin where adminName = ? and password = ?;";
        Admin admin = new Admin();
        try{
            conn = JDBCUtils.getConnection();
            conn.getAutoCommit();
            ps = conn.prepareStatement(sql);
            ps.setString(1,adminName);
            ps.setString(2,password);
            rs = ps.executeQuery();
            while (rs.next()){
                admin.setAdminId(rs.getInt(1));
                admin.setAdminName(rs.getString(2));
                admin.setPassword(rs.getString(3));
            }

        } catch (SQLException e) {
            try{
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return admin;
    }
}
