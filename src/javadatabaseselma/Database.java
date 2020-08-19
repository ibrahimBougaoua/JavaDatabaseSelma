/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadatabaseselma;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

/**
 *
 * @author b
 */
public class Database {
    
    private static final Connection con  = null;
    private static final String database = "BDDAdmin";
    private static final String username = "root";
    private static final String password = null;
    
    /**
     * Database
     * @throws SQLException 
     */
    public Database() throws SQLException {
    	   Database.getConnectionDb();
    }
    
    /**
    * @return
    * @throws SQLException
    */
    public static Connection getConnectionDb() throws SQLException {
    	return DriverManager.getConnection( "jdbc:mysql://localhost/" + database , username , password );	
    }
}
