package database

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.sql.DriverManager

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import groovy.sql.Sql
import java.sql.*
import java.util.Date
import java.text.SimpleDateFormat

import java.sql.ResultSet
import java.sql.Statement


public class db {
	private static Connection connection = null;
//Open Connection to Database	
	@Keyword
	def connectDB(String url, String dbname, String port, String username, String password) {
		String conn = "jdbc:mysql://" + url + ":" + port + "/" + dbname + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT"
			if (connection != null && !connection.isClosed()) {
			connection.close()
		}
		connection = DriverManager.getConnection(conn, username, password)
		return connection
	}

//Execute Query
	@Keyword
	def executeQuery(String query) {
		Statement stm = connection.createStatement()
		ResultSet rs = stm.executeQuery(query)
		return rs
	}
//Closing the connection
	@Keyword

	def closeDatabaseConnection() {
		if (connection != null && !connection.isClosed()) {
			connection.close()
		}
		connection = null
	}
}
