package com.company.Dao.Impl;

import com.company.Dao.FoodDao;
import com.company.domain.Food;
import com.company.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoImpl implements FoodDao {
    private Connection conn = null;
    private PreparedStatement ps =null;
    private ResultSet rs = null;

    @Override
    public ArrayList<Food> get(String name) throws SQLException {
        ArrayList<Food> list = new ArrayList<>();

        try {
            conn = JDBCUtils.getConnection();
            conn.getAutoCommit();
            String sql = "select * from food where foodName like ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,  "%"+name+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Food food = new Food();
                food.setFoodName(rs.getString(2));
                food.setPrice(rs.getBigDecimal(4));
                food.setFoodExplain(rs.getString(3));
                food.setbId(rs.getInt(5));
                list.add(food);
            }
        }catch (SQLException e) {
            try{
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
        } finally {
            conn.close();
            ps.close();
        }

    }return  list;
    }
}

