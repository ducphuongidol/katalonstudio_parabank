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
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.ConditionType as ConditionType

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://parabank.parasoft.com/parabank/index.htm;jsessionid=2510AA4F0D505457554D247A59CE16ED')

WebUI.setText(findTestObject('Object Repository/Login_Page/UserName_TextBox'), GlobalVariable.username)

WebUI.setText(findTestObject('Object Repository/Login_Page/Password_TextBox'), GlobalVariable.password)

WebUI.click(findTestObject('Login_Page/Login_Btn'))

WebUI.click(findTestObject('Home_Page/Update_Contact_Info_btn'))

// Perform actions based on the data
WebUI.setText(findTestObject('Update_Contact_Info/Page_ParaBank  Update Profile/FirstName_TxtBx'), firstname)

WebUI.setText(findTestObject('Update_Contact_Info/Page_ParaBank  Update Profile/LastName_TxtBx'), lastname)

WebUI.setText(findTestObject('Update_Contact_Info/Page_ParaBank  Update Profile/address_txtbx'), address)

WebUI.setText(findTestObject('Update_Contact_Info/Page_ParaBank  Update Profile/city_txtbx'), city)

WebUI.setText(findTestObject('Update_Contact_Info/Page_ParaBank  Update Profile/state_txtbx'), state)

WebUI.setText(findTestObject('Update_Contact_Info/Page_ParaBank  Update Profile/zipcode_txtbx'), zipcode)

WebUI.setText(findTestObject('Update_Contact_Info/Page_ParaBank  Update Profile/phone_txtbx'), phone)

WebUI.click(findTestObject('Update_Contact_Info/Page_ParaBank  Update Profile/UpdateProfile_Btn'))

// Determine the object name based on the phone variable
String objectName = phone

if (phone == '<script>') {
    WebUI.waitForElementPresent(findTestObject('Update_Contact_Info/Page_ParaBank  Update Profile/Updated_msg_failed'), 30)
    WebUI.verifyElementText(findTestObject('Update_Contact_Info/Page_ParaBank  Update Profile/Updated_msg_failed'), expected_msg)
} 

else if (phone == '') {
    WebUI.verifyElementText(findTestObject('Update_Contact_Info/Page_ParaBank  Update Profile/Page_ParaBank_AfterInputBlankValue/FirstName_required'), firstname_error)
    WebUI.verifyElementText(findTestObject('Update_Contact_Info/Page_ParaBank  Update Profile/Page_ParaBank_AfterInputBlankValue/LastName_required'), lastname_error)
    WebUI.verifyElementText(findTestObject('Update_Contact_Info/Page_ParaBank  Update Profile/Page_ParaBank_AfterInputBlankValue/Address_required'), address_error)
    WebUI.verifyElementText(findTestObject('Update_Contact_Info/Page_ParaBank  Update Profile/Page_ParaBank_AfterInputBlankValue/City_required'), city_error)
    WebUI.verifyElementText(findTestObject('Update_Contact_Info/Page_ParaBank  Update Profile/Page_ParaBank_AfterInputBlankValue/State_required'), state_error)
    WebUI.verifyElementText(findTestObject('Update_Contact_Info/Page_ParaBank  Update Profile/Page_ParaBank_AfterInputBlankValue/ZipCode_required'), zipcode_error)
}

else {
    WebUI.waitForElementPresent(findTestObject('Update_Contact_Info/Page_ParaBank  Update Profile/Updated_msg_succeed'), 30)
    WebUI.verifyElementText(findTestObject('Update_Contact_Info/Page_ParaBank  Update Profile/Updated_msg_succeed'), expected_msg)
}

WebUI.closeBrowser()


