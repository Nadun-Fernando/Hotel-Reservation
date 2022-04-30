/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.dao;

import lk.hotelme.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class CrudUtil {
    private static PreparedStatement getPreparedStatement(String sql,Object... data) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        for (int i = 0; i < data.length; i++) {
            prepareStatement.setObject(i+1, data[i]);
        }
        return prepareStatement;
    }
        public static boolean executeUpdate(String sql, Object... data) throws ClassNotFoundException, SQLException{
            return getPreparedStatement(sql, data).executeUpdate()>0;
        }
        
        public static ResultSet executeQuery(String sql, Object... data) throws ClassNotFoundException, SQLException{
            return getPreparedStatement(sql, data).executeQuery();
        }
}
