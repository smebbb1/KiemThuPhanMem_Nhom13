package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;

public class MyTicketPage extends GeneralPage{
    public void DeleteTicket() {
        Constant.WEBDRIVER.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/table/tbody/tr[2]/td[11]/input")).click();
        Constant.WEBDRIVER.switchTo().alert().accept();
    }
    public boolean TestCancelTicket(String ExpectDepartstation, String ExpectArrivestation, String ExpectSeattype, String ExpectDepartdate,
                                     String ExpectAmount) {
        String departStation = Constant.WEBDRIVER.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/table/tbody/tr[2]/td[2]")).getText();
        String arriveStation = Constant.WEBDRIVER.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/table/tbody/tr[2]/td[3]")).getText();
        String seatType = Constant.WEBDRIVER.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/table/tbody/tr[2]/td[4]")).getText();
        String departDate = Constant.WEBDRIVER.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/table/tbody/tr[2]/td[5]")).getText();
        String ticketAmount = Constant.WEBDRIVER.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/table/tbody/tr[2]/td[9]")).getText();

        if (departStation.equals(ExpectDepartstation) && arriveStation.equals(ExpectArrivestation) && seatType.equals(ExpectSeattype) && departDate.equals(ExpectDepartdate)
                && ticketAmount.equals(ExpectAmount)) {
            return false;
        } else {
            return true;
        }
    }
}
