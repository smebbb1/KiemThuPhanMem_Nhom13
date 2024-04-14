package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    //locators
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    protected final By tabMyTicket = By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']");
    protected final By tabChangePassword = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");
    private final By _lblChangePasswordMessage = By.xpath("//*[@id=\"ChangePW\"]/fieldset/p[1]");
    private final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
    private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    protected final By tabTimeTable = By.xpath("//*[@id='menu']/ul/li[4]/a");
    //elements
    protected WebElement getTabLogin()
    {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }
    public WebElement getTabLogout()
    {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }
    protected WebElement getLblWelcomeMessages()
    {
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }
    protected WebElement getTabChangePassword() {
        return Constant.WEBDRIVER.findElement(tabChangePassword);
    }
    public WebElement getLblchangePasswordErrorMsg() {
        return Constant.WEBDRIVER.findElement(_lblChangePasswordMessage);
    }
    protected WebElement getTabRegister()
    {
        return Constant.WEBDRIVER.findElement(tabRegister);
    }
    protected WebElement getTabBookTicket()
    {
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }
    public WebElement getTabMyTicket() {
        return Constant.WEBDRIVER.findElement(tabMyTicket);
    }

    //Methods
    public String getLblWelcomeMessage()
    {
        return this.getLblWelcomeMessages().getText();
    }

    public LoginPage gotoLoginPage()
    {
        this.getTabLogin().click();
        return new LoginPage();
    }
    public RegisterPage gotoRegisterPage()
    {
        this.getTabRegister().click();
        return new RegisterPage();
    }
    public BookticketPage gotoBookTicketPage()
    {
        this.getTabBookTicket().click();
        return new BookticketPage();
    }
    public WebElement getTabTimeTable() {
        return Constant.WEBDRIVER.findElement(tabTimeTable);
    }
    public TimeTablePage gotoTimeTablePage() {
        getTabTimeTable().click();
        return new TimeTablePage();
    }
    public MyTicketPage gotoMyTicketPage() {
        getTabMyTicket().click();
        return new MyTicketPage();
    }

}