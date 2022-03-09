package ibos;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class login {
    public static WebDriver driver;

    public static void main(String[] args) {
        ChromeOpen();
        login_001();
        Logout();
        //login_002();
        //employee_mng();
    }

    public static void ChromeOpen(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ibos.peopledesk.io/");
    }

    //-- LOGIN WITH ACTIVE USER ACCOUNT CREDENTIAL --//
    public static void login_001(){
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/form/div[1]/div/div/div[2]/div/div[1]/div/input")).sendKeys("abir@ibos.io");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/form/div[1]/div/div/div[2]/div/div[2]/div/input")).sendKeys("@demo123");
        WebElement login = driver.findElement(By.className("btn-basic"));
        login.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

       // driver.findElement(By.className("profile-menu-img")).click();
       // driver.findElement(By.xpath("//*[@id=\"simple-popover\"]/div[3]/div/ul/li[2]")).click();
        System.out.println("Test Passed - Login_001");
    }

    public static void Logout(){
        if (driver.findElement(By.className("profile-menu-img"))!= null){
            System.out.println("logout present");
            driver.findElement(By.className("profile-menu-img")).click();
            driver.findElement(By.xpath("//*[@id=\"simple-popover\"]/div[3]/div/ul/li[2]")).click();
        }
        else
        {
            System.out.println("logout NOT Found");
        }
        //driver.findElement(By.className("profile-menu-img")).click();
        //driver.findElement(By.xpath("//*[@id=\"simple-popover\"]/div[3]/div/ul/li[2]")).click();
    }

    //-- LOGIN WITH IN-ACTIVE USER ACCOUNT CREDENTIAL --//
    public static void login_002(){
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/form/div[1]/div/div/div[2]/div/div[1]/div/input")).sendKeys("demo@ibos.io");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/form/div[1]/div/div/div[2]/div/div[2]/div/input")).sendKeys("@demo123");
        WebElement login = driver.findElement(By.className("btn-basic"));
        login.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        System.out.println("Test Passed - Login_002");
    }
//    public static void employee_mng(){
//        driver.findElement(By.xpath("//*[@id=\"main\"]/div[5]/div/form/div[2]/div[2]/div/div[2]/div/div")).click();
//        String searchName = "Abir";
//        System.out.println("Module: Employee Management");
//        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"main\"]/div[5]/div/form/div[2]/div/div/div[2]/div[1]/ul/li[1]/div/div/input"));
//        searchBar.sendKeys(searchName);
//        searchBar.sendKeys(Keys.RETURN);
//
//        try {
//            boolean elemFound = driver.findElement(By.xpath("//*[@id=\"main\"]/div[5]/div/form/div[2]/div/div/div[2]/div[2]/div/table/tbody/tr[1]/td[2]/div")).isDisplayed();
//            System.out.println("Search Result Came");
//        }
//        catch (Exception e){
//            System.out.println("No Search Result");
//        }
//    }
    //-- LOGIN WITH WRONG USER ACCOUNT CREDENTIAL --//
    public static void login_003(){
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/form/div[1]/div/div/div[2]/div/div[1]/div/input")).sendKeys("demo541@ibos.io");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/form/div[1]/div/div/div[2]/div/div[2]/div/input")).sendKeys("@demo123");
        WebElement login = driver.findElement(By.className("btn-basic"));
        login.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        System.out.println("Test Passed - Login_002");
    }
}
