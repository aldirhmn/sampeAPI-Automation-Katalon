import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.sql.ResultSet

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

CustomKeywords.'database.db.connectDB'(GlobalVariable.dbUrl, GlobalVariable.dbName, GlobalVariable.dbPort, GlobalVariable.dbUsername, GlobalVariable.dbPassword)

String prodName = 'Corsair'

String prodPrice = 50000000

String available = true

String sellerEmail = 'emailbaruw@gmail.com'

String createdBy = 4

response = WS.sendRequestAndVerify(findTestObject('Products/Add Products - SampleAPI', [('prodName') : prodName , ('prodPrice') : prodPrice , ('available') : available
            , ('sellerEmail') : sellerEmail, ('createdBy') : createdBy]))

//WS.comment(response.getReponseBodyContent())

JsonSlurper slurper = new JsonSlurper()

Map result = slurper.parseText(response.getResponseBodyContent())

String respProductId = result.data.product_id

String respCode = result.code

String respMessage = result.message

String respError = result.error

'Verify if Product ID is Not Null'
WS.verifyNotMatch(respProductId, null, false)

'Verify if Product ID is Has Value'
assert respProductId != null

'Verify if Response Code is 200'
assert respCode == '200'

'Verify if Response Message is Not Null'
assert respMessage != null

'Verify if Response Message is Product Added Successfully'
assert respMessage == 'Product added successfully.'

WS.delay(5)

ResultSet log = CustomKeywords.'database.db.executeQuery'('SELECT * FROM product WHERE id = "' + prodName + '" ORDER BY id desc')

log.next()

String logId = log.getString("id")

String logName = log.getString("name")

String logPrice = log.getString("price")

String logAvail = log.getString("is_available")

String logSellerEmail = log.getString("seller_email")

WS.comment('\nDatabase ID : ' + logId + '\nDatabase Name : ' + logName + '\nDatabase Price : ' + logPrice + '\nDatabase Available : ' + logAvail + 
	'\nDatabase Seller Email :' + logSellerEmail)

'Verify Response ID Equals to Database ID'
WS.verifyMatch(logId, respProductId, false)

'Verify Log Product Name is Equals to Input'
WS.verifyMatch(logName, prodName, false)

'Verify Log Product Price is Equals to Input Price'
WS.verifyMatch(logPrice, prodPrice, false)

'Verify Log Seller Email is Equals to Input Email Seller'
WS.verifyMatch(logSellerEmail, sellerEmail, false)

'Close Database Connection'
CustomKeywords.'database.db.closeDatabaseConnection'()