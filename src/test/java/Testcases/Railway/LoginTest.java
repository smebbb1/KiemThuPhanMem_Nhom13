package Testcases.Railway;


import Common.Constant.Constant;
import PageObjects.Railway.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");

        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC01() {
        System.out.println("TC01 - User can log into Raiway with valid username and password");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        Str actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getLblWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Test
    public void TC02() {
        System.out.println("TC02 - User can't login with blank 'Username' textbox");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();

        loginPage.getTxtUsername().sendKeys("");
        loginPage.getTxtPassword().sendKeys(Constant.PASSWORD);
        loginPage.getBtnLogin().click();

        String actualErrorMsg = loginPage.getLblLoginErrorMsg().getText();
        String expectedErrorMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }
    @Test
    public void TC03() {
        System.out.println("TC03 - User cannot log into Railway with invalid password ");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();

        loginPage.getTxtUsername().sendKeys(Constant.USERNAME);
        loginPage.getTxtPassword().sendKeys("");
        loginPage.getBtnLogin().click();

        String actualErrorMsg = loginPage.getLblLoginErrorMsg().getText();
        String expectedErrorMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }
    @Test
    public void TC04(){
        System.out.println("TC04 - Login page displays when un-logged User clicks on 'Book ticket' tab ");
        BookticketPage bookticketPage = new BookticketPage();
        bookticketPage.open();
        String actualErrorMsg = bookticketPage.getLblBookTicketErrorMsg().getText();
        String expectedErrorMsg = "Login page";

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");

    }
    @Test
    public void TC05(){
        System.out.println("TC05 - System shows message when user enters wrong password several times ");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        for (int i =0; i<4;i++){


            loginPage.getTxtUsername().sendKeys(Constant.USERNAME);
            loginPage.getTxtPassword().sendKeys("asajahsha");
            loginPage.getBtnLogin().submit();
            loginPage.getTxtUsername().clear();
            loginPage.getTxtPassword().clear();

        }
        String actualErrorMsg = loginPage.getLblLoginErrorMsg().getText();
        String expectedErrorMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }
    @Test
    public void TC06() {
        System.out.println("TC06 - Additional pages display once the user is logged in");
        HomePage homePage = new HomePage();
        homePage.open();

        // Step 1: Navigate to the Login page
        LoginPage loginPage = homePage.gotoLoginPage();

        // Step 2: Log in with valid credentials
        loginPage.getTxtUsername().sendKeys("ngocdang121212@gmail.com");
        loginPage.getTxtPassword().sendKeys("123456789");
        loginPage.getBtnLogin().click();

        WebElement myTicketTab = homePage.getTabMyTicket();
        WebElement changePasswordTab = homePage.getTabChangePassword();
        WebElement logoutTab = homePage.getTabLogout();

        Assert.assertTrue(myTicketTab.isDisplayed(), "\"My ticket\" tab is not displayed");
        Assert.assertTrue(changePasswordTab.isDisplayed(), "\"Change password\" tab is not displayed");
        Assert.assertTrue(logoutTab.isDisplayed(), "\"Logout\" tab is not displayed");
        homePage.gotoMyTicketPage();
        homePage.gotoChangePasswordPage();
    }
    @Test
    public void TC07() {
        System.out.println("TC07 - User can create new account");
        HomePage homePage = new HomePage();
        homePage.open();

        RegisterPage registerPage = homePage.gotoRegisterPage();
        registerPage.getTxtEmail().sendKeys("dangpro112345@gmail.com");
        registerPage.getTxtPassword().sendKeys("1234512345");
        registerPage.getTxtConfirmPassword().sendKeys("1234512345");
        registerPage.getTxtPID().sendKeys("1234512345");
        registerPage.getBtnRegister().submit();
        String actualErrorMsg = registerPage.getLblRegisterMsg().getText();
        String expectedMessage = "Thank you for registering your account";
        Assert.assertEquals(actualErrorMsg, expectedMessage, "Error message is not displayed as expected");
    }
    @Test
    public void TC08() {
        System.out.println("TC08 - User can't login with an account hasn't been activated");
        HomePage homePage = new HomePage();
        homePage.open();
        String email = "dangpro1111@gmail.com";
        String password = "12345";
        String pid = "12345";
        // create new account but do not activate it
        RegisterPage registerPage = homePage.gotoRegisterPage();
        registerPage.getTxtEmail().sendKeys(email);
        registerPage.getTxtPassword().sendKeys(password);
        registerPage.getTxtConfirmPassword().sendKeys(password);
        registerPage.getTxtPID().sendKeys(pid);
        registerPage.getBtnRegister().submit();
        //
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.getTxtUsername().sendKeys(email);
        loginPage.getTxtPassword().sendKeys(password);
        loginPage.getBtnLogin().click();

        String actualErrorMsg = loginPage.getLblLoginErrorMsg().getText();
        String expectedMessage = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualErrorMsg, expectedMessage, "Error message is not displayed as expected");
    }
    @Test
    public void TC09() {
        System.out.println("TC09 - User can change password");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();;
        loginPage.getTxtUsername().sendKeys("dangtest9@gmail.com");
        loginPage.getTxtPassword().sendKeys("1234512345");
        loginPage.getBtnLogin().click();
        ChangePasswordPage changePasswordPage = homePage.gotoChangePasswordPage();
        changePasswordPage.getTxtCurrentPassword().sendKeys("1234512345");
        changePasswordPage.getTxtNewPassword().sendKeys("123412341");
        changePasswordPage.getTxtConfirmPassword().sendKeys("123412341");
        changePasswordPage.getBtnChangePassword().click();


        String actualErrorMsg = changePasswordPage.getLblchangePasswordErrorMsg().getText();
        String expectedMessage = "Your password has been updated";
        Assert.assertEquals(actualErrorMsg, expectedMessage, "Error message is not displayed as expected");
    }
    @Test
    public void TC10() {
        System.out.println("TC10 - User can't create account with 'Confirm password' is not the same with 'Password'");
        HomePage homePage = new HomePage();
        homePage.open();
        String email = "dangtest102@gmail.com";
        String password = "1234512345";
        String confirmpassword = "1234512344";
        String pid = "123456789";

        RegisterPage registerPage = homePage.gotoRegisterPage();
        registerPage.getTxtEmail().sendKeys(email);
        registerPage.getTxtPassword().sendKeys(password);
        registerPage.getTxtConfirmPassword().sendKeys(confirmpassword);
        registerPage.getTxtPID().sendKeys(pid);
        registerPage.getBtnRegister().submit();

        String actualErrorMsg = registerPage.getLblRegisterErrorMsg1().getText();
        String expectedMessage = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualErrorMsg, expectedMessage, "Error message is not displayed as expected");

    }
    @Test
    public void TC11() {
        System.out.println("TC10 - User can't create account with 'Confirm password' is not the same with 'Password'");
        HomePage homePage = new HomePage();
        homePage.open();
        String email = "dangpro1122@gmail.com";
        String password = "";
        String confirmpassword = "";
        String pid = "";

        RegisterPage registerPage = homePage.gotoRegisterPage();
        registerPage.getTxtEmail().sendKeys(email);
        registerPage.getTxtPassword().sendKeys(password);
        registerPage.getTxtConfirmPassword().sendKeys(confirmpassword);
        registerPage.getTxtPID().sendKeys(pid);
        registerPage.getBtnRegister().submit();
        //
        String actualErrorMsg1 = registerPage.getLblRegisterErrorMsg1().getText();
        String expectedMessage1 = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualErrorMsg1, expectedMessage1, "Error message is not displayed as expected");
        //
        String actualErrorMsg2 = registerPage.getLblRegisterErrorMsg2().getText();
        String expectedMessage2 = "Invalid password length.";
        Assert.assertEquals(actualErrorMsg2, expectedMessage2, "Error message is not displayed as expected");
        //
        String actualErrorMsg3 = registerPage.getLblRegisterErrorMsg2().getText();
        String expectedMessage3 = "Invalid ID length.";
        Assert.assertEquals(actualErrorMsg3, expectedMessage3, "Error message is not displayed as expected");


    }

    @Test
    public void TC15(){
        System.out.println("TC15 - User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page");
        HomePage homePage = new HomePage();
        homePage.open();
        String email = "dangtest14a@gmail.com";
        String password = "1234512345";
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.getTxtUsername().sendKeys(email);
        loginPage.getTxtPassword().sendKeys(password);
        loginPage.getBtnLogin().click();

        TimeTablePage timeTablePage = homePage.gotoTimeTablePage();
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        boolean isBookTicketFound = false;
        int attempts = 0;
        while (!isBookTicketFound && attempts < 4) { // Thử lại tối đa 3 lần
            try {
                timeTablePage.getBtnBookticket().click();
                isBookTicketFound = true;
                break;
            } catch (org.openqa.selenium.NoSuchElementException e) {
                System.out.println("Error: Not finding book ticket button of Hue - Saigon. Attempt: " + (attempts + 1));
                // Làm mới trang
                Constant.WEBDRIVER.navigate().refresh();
                // Lặp lại từ đầu
                timeTablePage = homePage.gotoTimeTablePage();
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                attempts++;
            }
        }

        if (isBookTicketFound) {
            try {
                String ActualDepartFrom = Constant.WEBDRIVER.findElement(By.xpath("//*[@id=\"content\"]/div[1]/form/fieldset/ol/li[2]/select/option[@selected='selected']"))
                        .getText();
                String ActualArriveAt = Constant.WEBDRIVER.findElement(By.xpath("//*[@id=\"ArriveStation\"]/select/option[@selected='selected']"))
                        .getText();
                Assert.assertEquals(ActualDepartFrom, "Huế", "Depart Station  is not displayed as expected");
                Assert.assertEquals(ActualArriveAt, "Sài Gòn", "Arrive Station is not displayed as expected");
            } catch (org.openqa.selenium.NoSuchElementException e) {
                System.out.println("Error: Not finding expected elements on Book ticket page.");
            }
        } else {
            System.out.println("Error: Unable to find Book ticket button after 4 attempts.");
        }
    }
    @Test
    public void TC14A() throws InterruptedException {
        System.out.println("TC14 - User can book 1 ticket at a time");
        HomePage homePage = new HomePage();
        homePage.open();
        String email = "dangtest14a@gmail.com"; //dangtest14a@gmail.com
        String password = "1234512345";
        LoginPage loginPage = homePage.gotoLoginPage();;
        loginPage.getTxtUsername().sendKeys(email);
        loginPage.getTxtPassword().sendKeys(password);
        loginPage.getBtnLogin().click();
        BookticketPage bookticketPage = homePage.gotoBookTicketPage();

        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        /// kiểm tra xem có giá trị sài gòn không
        boolean isDepartFromOptionFound = false;
        int attempts = 0;
        while (attempts < 20) { // Thử lại tối đa 3 lần
            List<WebElement> departFromOptions = bookticketPage.getBtnDepartFrom().findElements(By.tagName("option"));
            for (WebElement option : departFromOptions) {
                if (option.getText().equals("Sài Gòn")) {
                    option.click();
                    isDepartFromOptionFound = true;
                    break; // Dừng vòng lặp foreach nếu tìm thấy "Sài Gòn"
                }
            }

            if (isDepartFromOptionFound) {
                break;
            }


            // Làm mới trang chỉ khi cần thiết
            Constant.WEBDRIVER.navigate().refresh();
            attempts++;
        }

        bookticketPage.getBtnDepartDate().click();
        String ValueDate;
        ValueDate = String.valueOf((bookticketPage.getBtnDepartDateOption().getText()));
        bookticketPage.getBtnDepartDateOption().click();

        bookticketPage.getBtnDepartFrom().click();
        bookticketPage.getBtnDepartFromOption().click();

        bookticketPage.getBtnArriveAt().click();
        bookticketPage.getBtnArriveAtOption().click();

        bookticketPage.getBtnSeatType().click();
        bookticketPage.getBtnSeatTypeOption().click();

        bookticketPage.getBtnTicketAmount().click();
        bookticketPage.getBtnTicketAmountOption().click();

        Constant.WEBDRIVER.findElement(By.xpath("//input[@type='submit']")).click();



        String actualSuccessMsg = bookticketPage.getLblSuccessMsg().getText();
        String actualDepartDate = Constant.WEBDRIVER.findElement(By.xpath("//*[@id='content']/div/table/tbody/tr[2]/td[4]")).getText();
        String actualDepartFrom = Constant.WEBDRIVER.findElement(By.xpath("//*[@id='content']/div/table/tbody/tr[2]/td[1]")).getText();
        String actualArriveAt = Constant.WEBDRIVER.findElement(By.xpath("//*[@id='content']/div/table/tbody/tr[2]/td[2]")).getText();
        String actualSeatType = Constant.WEBDRIVER.findElement(By.xpath("//*[@id='content']/div/table/tbody/tr[2]/td[3]")).getText();
        String actualAmount = Constant.WEBDRIVER.findElement(By.xpath("//*[@id='content']/div/table/tbody/tr[2]/td[7]")).getText();

        String expectedSuccessMessage = "Ticket booked successfully!";
//        homePage.gotoBookTicketPage();
//        String expectedDepartDate= bookticketPage.getBtnDepartDateOption().getText();
        String expectedDepartDate= ValueDate;
        String expectedDepartFrom= "Sài Gòn";
        String expectedArriveAt= "Nha Trang";
        String expectedSeatType= "Soft bed with air conditioner";
        String expectedAmount= "1";


        Assert.assertEquals(actualSuccessMsg, expectedSuccessMessage, "Error message is not displayed as expected");
        Assert.assertEquals(actualDepartDate, expectedDepartDate, "Error message is not displayed as expected");
        Assert.assertEquals(actualDepartFrom, expectedDepartFrom, "Error message is not displayed as expected");
        Assert.assertEquals(actualArriveAt, expectedArriveAt, "Error message is not displayed as expected");
        Assert.assertEquals(actualSeatType, expectedSeatType, "Error message is not displayed as expected");
        Assert.assertEquals(actualAmount, expectedAmount, "Error message is not displayed as expected");


    }
    @Test
    public void TC16(){
        System.out.println("TC16 - User can cancel a ticket");
        HomePage homePage = new HomePage();
        homePage.open();
        String email = "dangtest14a@gmail.com"; //dangtest14a@gmail.com
        String password = "1234512345";
        LoginPage loginPage = homePage.gotoLoginPage();;
        loginPage.getTxtUsername().sendKeys(email);
        loginPage.getTxtPassword().sendKeys(password);
        loginPage.getBtnLogin().click();
        //
        BookticketPage bookticketPage = homePage.gotoBookTicketPage();
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        //đặt vé
        bookticketPage.getBtnDepartDate().click();
        String ValueDepartDate;
        ValueDepartDate = String.valueOf((bookticketPage.getBtnDepartDateOption().getText()));
        bookticketPage.getBtnDepartDateOption().click();

        bookticketPage.getBtnDepartFrom().click();
        String ValueDepartFrom;
        ValueDepartFrom = String.valueOf((bookticketPage.getBtnDepartDateOption().getText()));
        bookticketPage.getBtnDepartFromOption().click();

        bookticketPage.getBtnArriveAt().click();
        String ValueAriveAt;
        ValueAriveAt = String.valueOf((bookticketPage.getBtnDepartDateOption().getText()));
        bookticketPage.getBtnArriveAtOption().click();

        bookticketPage.getBtnSeatType().click();
        String ValueSeat;
        ValueSeat = String.valueOf((bookticketPage.getBtnDepartDateOption().getText()));
        bookticketPage.getBtnSeatTypeOption().click();

        bookticketPage.getBtnTicketAmount().click();
        String ValueAmount;
        ValueAmount = String.valueOf((bookticketPage.getBtnDepartDateOption().getText()));
        bookticketPage.getBtnTicketAmountOption().click();

        Constant.WEBDRIVER.findElement(By.xpath("//input[@type='submit']")).click();
        //
        MyTicketPage myTicketPage = homePage.gotoMyTicketPage();
        myTicketPage.DeleteTicket();
        Assert.assertTrue(myTicketPage.TestCancelTicket(ValueDepartFrom,ValueAriveAt,ValueSeat,ValueDepartDate,ValueAmount),"The canceled ticket is not disappeared.");


    }





}


