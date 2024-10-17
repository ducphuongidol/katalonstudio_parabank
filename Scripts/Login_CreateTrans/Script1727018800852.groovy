import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://parabank.parasoft.com/parabank/index.htm;jsessionid=2510AA4F0D505457554D247A59CE16ED')

WebUI.setText(findTestObject('Object Repository/Login_Page/UserName_TextBox'), GlobalVariable.username)

WebUI.setText(findTestObject('Object Repository/Login_Page/Password_TextBox'), GlobalVariable.password)

WebUI.click(findTestObject('Object Repository/Login_Page/Login_Btn'))

WebUI.click(findTestObject('Object Repository/Home_Page/TransferFund_Page'))

WebUI.setText(findTestObject('Object Repository/TransferFund_Page/InputAmount_TextBox'), transaction_amount)

WebUI.click(findTestObject('Object Repository/TransferFund_Page/Confirm_Transaction_Btn'))

WebUI.verifyTextPresent(comp_msg, false)

WebUI.closeBrowser()


