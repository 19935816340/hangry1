package com.company.Dao;

import com.company.domain.Food;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FoodDao {
    public ArrayList<Food> get(String name) throws SQLException;
}
