package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TimeTablePage {
    private final By _btnBookticket_timetable = By.xpath("//*[@id='content']/div/div/table/tbody/tr[17]/td[7]/a");
    public WebElement getBtnBookticket(){
        return Constant.WEBDRIVER.findElement(_btnBookticket_timetable);
    }

}
