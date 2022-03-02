package ibos;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class EmployeeManagement extends BasePeopledesk{

    public static void main(String[] args) {
        ChromeOpen();
        GetUrl("https://ibos.peopledesk.io/");
        login();
        employee_mng_001();
        employee_mng_002();
    }
    public static WebDriver driver;

    public static void login() {
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/form/div[1]/div/div/div[2]/div/div[1]/div/input")).sendKeys("abir@ibos.io");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/form/div[1]/div/div/div[2]/div/div[2]/div/input")).sendKeys("@demo123");
        WebElement login = driver.findElement(By.className("btn-basic"));
        login.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
//Search for Invalid Name
    public static void employee_mng_001(){
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[5]/div/form/div[2]/div[2]/div/div[2]/div/div")).click();
        String searchName = "Zee";
        System.out.println("Module: Employee Management");
        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"main\"]/div[5]/div/form/div[2]/div/div/div[2]/div[1]/ul/li[1]/div/div/input"));
        searchBar.sendKeys(searchName);
        searchBar.sendKeys(Keys.RETURN);

        try {
            boolean elemFound = driver.findElement(By.xpath("//*[@id=\"main\"]/div[5]/div/form/div[2]/div/div/div[2]/div[2]/div/table/tbody/tr[1]/td[2]/div")).isDisplayed();
            System.out.println("Search Result Came");
        }
        catch (Exception e){
            System.out.println("No Search Result");
        }
    }
    //Search for Valid Name
    public static void employee_mng_002(){
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[5]/div/form/div[2]/div[2]/div/div[2]/div/div")).click();
        String searchName = "Abir";
        System.out.println("Module: Employee Management");
        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"main\"]/div[5]/div/form/div[2]/div/div/div[2]/div[1]/ul/li[1]/div/div/input"));
        searchBar.sendKeys(searchName);
        searchBar.sendKeys(Keys.RETURN);

        try {
            boolean elemFound = driver.findElement(By.xpath("//*[@id=\"main\"]/div[5]/div/form/div[2]/div/div/div[2]/div[2]/div/table/tbody/tr[1]/td[2]/div")).isDisplayed();
            System.out.println("Search Result Came");
        }
        catch (Exception e){
            System.out.println("No Search Result");
        }
    }
}
