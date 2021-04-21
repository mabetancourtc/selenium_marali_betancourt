package Practico10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class registrationFacebookTest {
    public WebDriver getDriver(String URL){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        return driver;
    }

     //Crear un método de test llamado fullRegistrationTest
    //Completar los campos de registro con los siguientes valores:
    //First Name: “John”
    //Last Name: “Smith”
    //Mobile: “5555555”
    //New Password: “123456789”
    //Birthday: Jun 26 1980
    //Gender: Male

    @Test
    public void fullRegistrationTest()throws InterruptedException{
        WebDriver driver = getDriver("https://www.facebook.com");

        driver.findElement(By.partialLinkText("Crear cuenta nueva")).click();

        Thread.sleep(2000);
        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("reg_email__")).sendKeys("5555555");
        driver.findElement(By.id("password_step_input")).sendKeys("123456789");


        setBirthdate(driver, "26", "jun", "1980");


        List<WebElement> listaSexos = driver.findElements(By.name("sex"));
        Assert.assertEquals(listaSexos.size(), 3);

        WebElement sexElement = listaSexos.get(1);
        sexElement.click();

        Thread.sleep(6000);
        driver.close();


    }

    private void setBirthdate (WebDriver driver, String dia, String mes, String año){
        WebElement dayElement = driver.findElement(By.id("day"));
        Select daySelect = new Select(dayElement);
        daySelect.selectByVisibleText(dia);

        WebElement monthElement = driver.findElement(By.id("month"));
        Select monthSelect = new Select(monthElement);
        monthSelect.selectByVisibleText(mes);

        WebElement yearElement = driver.findElement(By.id("year"));
        Select yearSelect = new Select(yearElement);
        yearSelect.selectByVisibleText(año);


    }







}
