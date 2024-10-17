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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://parabank.parasoft.com/parabank/index.htm;jsessionid=2510AA4F0D505457554D247A59CE16ED')

WebUI.setText(findTestObject('Object Repository/Login_Page/UserName_TextBox'), GlobalVariable.username)

WebUI.setText(findTestObject('Object Repository/Login_Page/Password_TextBox'), GlobalVariable.password)

WebUI.click(findTestObject('Login_Page/Login_Btn'))

WebUI.click(findTestObject('Home_Page/Bill_Pay_Btn'))

WebUI.setText(findTestObject('Bill_Pay/BillPay_Details_Page/PayeeNm_TxBx'), Payee_Name)

WebUI.setText(findTestObject('Bill_Pay/BillPay_Details_Page/Address_TxBx'), Address)

WebUI.setText(findTestObject('Bill_Pay/BillPay_Details_Page/City_TxBx'), City)

WebUI.setText(findTestObject('Bill_Pay/BillPay_Details_Page/State_TxBx'), State)

WebUI.setText(findTestObject('Bill_Pay/BillPay_Details_Page/ZipCode_TxBx'), ZipCode)

WebUI.setText(findTestObject('Bill_Pay/BillPay_Details_Page/Phone_TxBx'), Phone)

WebUI.setText(findTestObject('Bill_Pay/BillPay_Details_Page/AccNum_TxBx'), Account)

WebUI.setText(findTestObject('Bill_Pay/BillPay_Details_Page/VerifyAcc_TxBx'), VerifyAccount)

WebUI.setText(findTestObject('Bill_Pay/BillPay_Details_Page/Amount_TxBx'), Amount)

if ((Account.equals('123') || Account.equals('1')) || Account.equals('1234567890')) {
    // Find the dropdown object
    TestObject dropdown_BillPayPage = findTestObject('Bill_Pay/BillPay_Details_Page/FromAcc_DropDown')

    // Get the selected value
    String FromAccNum = WebUI.getAttribute(dropdown_BillPayPage, 'value')

    WebUI.click(findTestObject('Bill_Pay/BillPay_Details_Page/SendPayment_Btn'))

    // Define your expected text
    String CompletedMsg = (((((('Bill Payment to ' + Payee_Name) + ' in the amount of $') + Amount) + '.00') + ' from account ') + 
    FromAccNum) + ' was successful.'

    // Verify if the actual text matches the expected text
    WebUI.verifyElementText(findTestObject('Bill_Pay/BillPay_Completed_Page/BillPayment_Completed'), CompletedMsg)

    WebUI.click(findTestObject('Home_Page/FindTransactions_Btn'))

    TestObject dropdown_FindTransactionPage = findTestObject('FindTransactions_Page/FindTransaction_SelectAcc')

    String SelectAccount_FindTransaction = WebUI.getAttribute(dropdown_FindTransactionPage, 'value')

    if (SelectAccount_FindTransaction == FromAccNum) {
        WebUI.setText(findTestObject('FindTransactions_Page/FindTransactionByAmt_TxBx'), Amount)

        WebUI.click(findTestObject('FindTransactions_Page/FindTransactionByAmt_Btn'))
    } else {
        WebUI.selectOptionByValue(findTestObject(FindTransactions_Page / FindTransaction_SelectAcc), FromAccNum, false)

        WebUI.setText(findTestObject('FindTransactions_Page/FindTransactionByAmt_TxBx'), Amount)

        WebUI.click(findTestObject('FindTransactions_Page/FindTransactionByAmt_Btn'))
    }
    
    String TranDescPre = 'Bill Payment to ' + Payee_Name

    String TransAmountPre = ('$' + Amount) + '.00'

    WebUI.verifyTextPresent(TranDescPre, false)

    WebUI.verifyTextPresent(TransAmountPre, false)

    for (int i = 1; i < 30; i++) {
        TestObject TransDesPost = new TestObject()

        TransDesPost.addProperty('xpath', ConditionType.EQUALS, ('//*[@id=\'transactionBody\']/tr[' + i) + ']/td[2]')

        String TransDesTextPost = WebUI.getText(TransDesPost)

        TestObject TransAmountPost = new TestObject()

        TransAmountPost.addProperty('xpath', ConditionType.EQUALS, ('//*[@id=\'transactionBody\']/tr[' + i) + ']/td[3]')

        String TransAmountTextPost = WebUI.getText(TransAmountPost)

        System.out.println('TransDesTextPost: ' + TransDesTextPost)

        System.out.println('TransAmountTextPost: ' + TransAmountTextPost)

        if (TransAmountTextPost.equals(TransAmountPre) && TransDesTextPost.equals(TranDescPre)) {
           try {
            if (WebUI.verifyElementPresent(TransDesPost, 10) && WebUI.verifyElementVisible(TransDesPost)) {
                WebUI.waitForElementClickable(TransDesPost, 10);
                WebUI.click(TransDesPost);
                break;
            } else {
                System.out.println("Element not found or not visible: " + TransDesPost);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }
    
    WebUI.verifyElementText(findTestObject('FindTransactions_Page/FindTransaction_TransactionDetailPage/Amount'), TransAmountPre)

    WebUI.verifyElementText(findTestObject('FindTransactions_Page/FindTransaction_TransactionDetailPage/Description'), TranDescPre)
}

