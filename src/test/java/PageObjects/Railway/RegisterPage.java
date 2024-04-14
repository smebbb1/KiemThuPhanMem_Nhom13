package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {
    private final By _txtEmail = By.xpath("//input[@id='email']");
    private final By _txtPassword = By.xpath("//input[@id='password']");
    private final By _txtConfirmPassword  = By.xpath("//input[@id='confirmPassword']");
    private final By _txtPID = By.xpath("//input[@id='pid']");
    private final By _btnRegister = By.xpath("//*[@id=\"RegisterForm\"]/fieldset/p/input");
    private final By _lblRegisterMsg = By.xpath("//div[@id='content']/p");
    private final By _lblRegisterErrorMsg1 = By.xpath("//div[@id='content']/p[2]");
    private final By _lblRegisterErrorMsg2 = By.xpath("//*[@id=\"RegisterForm\"]/fieldset/ol/li[2]/label[2]");
    private final By _lblRegisterErrorMsg3 = By.xpath("//*[@id=\"RegisterForm\"]/fieldset/ol/li[4]/label[2]");
    public WebElement getTxtEmail(){
        return Constant.WEBDRIVER.findElement(_txtEmail);
    }
    public WebElement getTxtPassword(){
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }
    public WebElement getTxtConfirmPassword(){
        return Constant.WEBDRIVER.findElement(_txtConfirmPassword);
    }
    public WebElement getTxtPID(){
        return Constant.WEBDRIVER.findElement(_txtPID);
    }
    public WebElement getBtnRegister(){
        return Constant.WEBDRIVER.findElement(_btnRegister);
    }
    public WebElement getLblRegisterMsg() {
        return Constant.WEBDRIVER.findElement(_lblRegisterMsg);
    }
    public WebElement getLblRegisterErrorMsg1() {
        return Constant.WEBDRIVER.findElement(_lblRegisterErrorMsg1);
    }
    public WebElement getLblRegisterErrorMsg2() {
        return Constant.WEBDRIVER.findElement(_lblRegisterErrorMsg2);
    }
    public WebElement getLblRegisterErrorMsg3() {
        return Constant.WEBDRIVER.findElement(_lblRegisterErrorMsg3);
    }
    public void register (String Email, String Password, String ConfirmPassword, String PID) {
        this.getTxtEmail().sendKeys(Email);
        this.getTxtPassword().sendKeys(Password);
        this.getTxtConfirmPassword().sendKeys(ConfirmPassword);
        this.getTxtPID().sendKeys(PID);
        this.getBtnRegister().click();
    }

}
