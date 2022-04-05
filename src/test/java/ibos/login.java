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
        login_002();
        login_003();
        //Logout();
        //login_002();
        //employee_mng();
    }

    //-- CHROME OPEN --//
    public static void ChromeOpen(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ibos.peopledesk.io/");
    }

    //-- LOGOUT --//
    public static void Logout(){
            driver.findElement(By.className("profile-menu-img")).click();
            driver.findElement(By.xpath("//*[@id=\"simple-popover\"]/div[3]/div/ul/li[2]")).click();
    }


    //-- LOGIN WITH ACTIVE USER ACCOUNT CREDENTIAL --//

    public static void login_001() {
        WebElement mail = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/form/div[1]/div/div/div[2]/div/div[1]/div/input"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/form/div[1]/div/div/div[2]/div/div[2]/div/input"));
        mail.sendKeys("abir@ibos.io");
        password.sendKeys("@demo123");

        WebElement login = driver.findElement(By.className("btn-basic"));
        login.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        try {
           driver.findElement(By.className("profile-menu-img")).isDisplayed();
           System.out.println("logged in");
           System.out.println("login_001 PASSED\n");
           Logout();
        }
        catch (Exception e){
            System.out.println("can not login");
            System.out.println("login_001 FAILED\n");
        }
    }

    //-- LOGIN WITH IN-ACTIVE USER ACCOUNT CREDENTIAL --//

    public static void login_002(){
        WebElement mail = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/form/div[1]/div/div/div[2]/div/div[1]/div/input"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/form/div[1]/div/div/div[2]/div/div[2]/div/input"));
        mail.sendKeys("demo123@ibos.io");
        password.sendKeys("@demo123");

        WebElement login = driver.findElement(By.className("btn-basic"));
        login.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        try {
            driver.findElement(By.className("profile-menu-img")).isDisplayed();
            System.out.println("logged in");
            System.out.println("login_002 FAILED\n");
            Logout();
        }
        catch (Exception e){
            System.out.println("can not login");
            System.out.println("login_002 PASSED\n");
            driver.navigate().refresh();
        }
    }


    //-- LOGIN WITH ACTIVE - WRONG (PASSWORD) USER ACCOUNT CREDENTIAL --//

    public static void login_003(){
        WebElement mail = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/form/div[1]/div/div/div[2]/div/div[1]/div/input"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/form/div[1]/div/div/div[2]/div/div[2]/div/input"));
        mail.sendKeys("demo@ibos.io");
        password.sendKeys("demo123@");

        WebElement login = driver.findElement(By.className("btn-basic"));
        login.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        try {
            driver.findElement(By.className("profile-menu-img")).isDisplayed();
            System.out.println("logged in");
            System.out.println("login_003 FAILED");
            Logout();
        }
        catch (Exception e){
            System.out.println("can not login");
            System.out.println("login_003 PASSED");
        }
    }


}
