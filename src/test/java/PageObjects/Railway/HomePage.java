package PageObjects.Railway;


import Common.Constant.Constant;
import org.openqa.selenium.WebElement;

public class HomePage extends GeneralPage {
    // Locator
    // Element
    // Method
    public  HomePage open() {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return this;
    }
    public WebElement getTabMyTicket() {
        return Constant.WEBDRIVER.findElement(tabMyTicket);
    }
    public WebElement getTabChangePassword() {
        return Constant.WEBDRIVER.findElement(tabChangePassword);
    }

    public MyTicketPage gotoMyTicketPage() {
        getTabMyTicket().click();
        return new MyTicketPage();
    }
    public ChangePasswordPage gotoChangePasswordPage() {
        getTabChangePassword().click();
        return new ChangePasswordPage();
    }


}