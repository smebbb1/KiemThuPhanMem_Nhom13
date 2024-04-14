package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookticketPage extends GeneralPage {
    private final By _lblBookTicketErrorMsg = By.xpath("//h1");
    private final By _btnDepartDate = By.xpath("//*[@name='Date']");
    private final By _btnDepartDateOption = By.xpath("//*[@name='Date']/option[6]");
    private final By _btnDepartFrom = By.xpath("//*[@name='DepartStation']");
    private final By _btnDepartFromOption = By.xpath("//*[@name='DepartStation']/option[1]");
    private final By _btnArriveAT = By.xpath("//*[@name='ArriveStation']");
    private final By _btnArriveATOption = By.xpath("//*[@name='ArriveStation']/option[2]");
    private final By _btnSeatType = By.xpath("//*[@name='SeatType']");
    private final By _btnSeatTypeOption = By.xpath("//*[@name='SeatType']/option[6]");
    private final By _btnTicketAmount = By.xpath("//*[@name='TicketAmount']");
    private final By _btnTicketAmountOption = By.xpath("//*[@name='TicketAmount']/option[1]");
    private final By _btnSuccessMsg = By.xpath("//*[@id='content']/h1");
    // Locator
    // Element
    // Method
    public WebElement getLblBookTicketErrorMsg() {
        return Constant.WEBDRIVER.findElement(_lblBookTicketErrorMsg);
    }
    public  BookticketPage open() {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL1);
        return this;
    }
    public WebElement getBtnDepartDate(){
        return Constant.WEBDRIVER.findElement(_btnDepartDate);
    }
    public WebElement getBtnDepartDateOption(){
        return Constant.WEBDRIVER.findElement( _btnDepartDateOption);
    }
    public WebElement getBtnDepartFrom(){
        return Constant.WEBDRIVER.findElement(_btnDepartFrom);
    }
    public WebElement getBtnDepartFromOption(){
        return Constant.WEBDRIVER.findElement( _btnDepartFromOption);
    }
    public WebElement getBtnArriveAt(){
        return Constant.WEBDRIVER.findElement(_btnArriveAT);
    }
    public WebElement getBtnArriveAtOption(){
        return Constant.WEBDRIVER.findElement(_btnArriveATOption);
    }
    public WebElement getBtnSeatType(){
        return Constant.WEBDRIVER.findElement(_btnSeatType);
    }
    public WebElement getBtnSeatTypeOption(){
        return Constant.WEBDRIVER.findElement(_btnSeatTypeOption);
    }
    public WebElement getBtnTicketAmount(){
        return Constant.WEBDRIVER.findElement(_btnTicketAmount);
    }
    public WebElement getBtnTicketAmountOption(){
        return Constant.WEBDRIVER.findElement(_btnTicketAmountOption);
    }

    //
    public WebElement getLblSuccessMsg(){
        return Constant.WEBDRIVER.findElement(_btnSuccessMsg);
    }
    public BookticketPage check(){
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(10));
        return null;
    }
}