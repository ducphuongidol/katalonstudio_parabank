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

// Function to generate a random username
// length of the username
// Generate the username
String username = generateUsername()

// Store the username as a global variable
GlobalVariable.username = username

String password = 'Taokhongbietdau04@'

<<<<<<< Upstream, based on branch 'second_branch' of https://github.com/ducphuongidol/katalonstudio_parabank.git
String value = '123'
=======
String opt = '123'
>>>>>>> f08eb39 commit last day

GlobalVariable.password = password

WebUI.openBrowser('')

WebUI.navigateToUrl('https://parabank.parasoft.com/parabank/index.htm;jsessionid=9E5F4571F1BF188ACB213F84A4F63844')

WebUI.click(findTestObject('Object Repository/Login_Page/Register_Btn'))

WebUI.setText(findTestObject('Object Repository/Registration_detail_page/input_First Name_customer.firstName'), 'phuong')

WebUI.setText(findTestObject('Object Repository/Registration_detail_page/input_Last Name_customer.lastName'), 'phuong')

WebUI.setText(findTestObject('Object Repository/Registration_detail_page/input_Address_customer.address.street'), 'phuong')

WebUI.setText(findTestObject('Object Repository/Registration_detail_page/input_City_customer.address.city'), 'phuong')

WebUI.setText(findTestObject('Object Repository/Registration_detail_page/input_State_customer.address.state'), 'phuong')

WebUI.setText(findTestObject('Object Repository/Registration_detail_page/input_Zip Code_customer.address.zipCode'), 'phuong')

WebUI.setText(findTestObject('Object Repository/Registration_detail_page/input_Phone_customer.phoneNumber'), 'phuong')

WebUI.setText(findTestObject('Object Repository/Registration_detail_page/input_SSN_customer.ssn'), 'phuong')

WebUI.setText(findTestObject('Object Repository/Registration_detail_page/input_Username_customer.username'), GlobalVariable.username)

WebUI.setText(findTestObject('Object Repository/Registration_detail_page/input_Password_customer.password'), GlobalVariable.password)

WebUI.setText(findTestObject('Object Repository/Registration_detail_page/input_Confirm_repeatedPassword'), GlobalVariable.password)

WebUI.click(findTestObject('Object Repository/Registration_detail_page/Confirm_btn'))

WebUI.verifyElementText(findTestObject('Home_Page/welcome_after_register'), 'Welcome ' + GlobalVariable.username)

WebUI.closeBrowser()

String generateUsername() {
    String chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789'

    StringBuilder username = new StringBuilder()

    Random rnd = new Random()

    while (username.length() < 8) {
        int index = ((rnd.nextFloat() * chars.length()) as int)

        username.append(chars.charAt(index))
    }
    
    return username.toString()
}

