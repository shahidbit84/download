package com.skidata.helperclasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.skidata.testBase.TestBase;

/**
 *************************************************************************************************************
 * @Project SSP - CHBACKOFFICE AND PORTAL
 * @Description
 * DataBaseHelper class will be used to Handle to DB actions and DB Connections
 * @author shmo
 * @version 1.0
 *************************************************************************************************************
 */
public class DataBaseHelper extends TestBase{
	public Connection con;
	public Statement stmt;
	public static final Logger log = Logger.getLogger(DataBaseHelper.class.getName());
	
	public DataBaseHelper(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
		
	}
	
	/**
	 * DB connection E
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Statement getStatement() throws ClassNotFoundException, SQLException{
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String connection = "jdbc:mysql://localhost:3306/customer";
			String userName = "root";
			String password = "password";
			Class.forName(driver);
			con = DriverManager.getConnection(connection, userName, password);
			stmt = con.createStatement();
			return stmt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stmt;
	}
	/**
	 * Method to Insert the Query
	 * @param query
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void insertData(String query) throws ClassNotFoundException, SQLException{
		log("Entered the query as "+query);
		Statement sta = getStatement();
		sta.executeUpdate(query);
	}
	
	/**
	 * Get Query 
	 * @param query
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ResultSet getData(String query) throws ClassNotFoundException, SQLException{
		log("Entered the query as "+query);
		ResultSet data = getStatement().executeQuery(query);
		return data;
	}
	
	/**
	 * Send a Update Query to DB
	 * @param query
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void updateData(String query) throws ClassNotFoundException, SQLException{
		log("Entered the query as "+query);
		getStatement().executeUpdate(query);
		
	}
}
