package Practico11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SpotifyWithCssSelectorTest {
    //Ejercicio 7
    // Crear una clase llamada SpotifyWithCssSelectorTest
    //Crear un método llamado spotifyByPlaceHolderTest
    //Ingresar al sitio: https://www.spotify.com/uy/signup/
    //Completar todos los campos con Css Selector placeholder

    public WebDriver getSpotifyDriver (String URL){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        return driver;
    }

    @Test
    public void spotifyByPlaceHolderTest () throws  InterruptedException{
        WebDriver driver = getSpotifyDriver("https://www.spotify.com/uy/signup/");
        driver.findElement(By.cssSelector("input[placeholder='Introduce tu correo electrónico.']")).sendKeys("prueba100023@gmail.com");

        driver.findElement(By.cssSelector("input[placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("prueba100023@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder='Crea una contraseña.']")).sendKeys("123456789");
        driver.findElement(By.cssSelector("input[placeholder='Introduce un nombre de perfil.']")).sendKeys("PruebaSelenium");

        //¿Cuál es tu fecha de nacimiento?
        driver.findElement(By.cssSelector("input[placeholder='DD']")).sendKeys("09");

        Select drpMes = new Select(driver.findElement(By.xpath("//*[@name='month']")));
        drpMes.selectByValue("02");

        driver.findElement(By.cssSelector("input[placeholder='AAAA']")).sendKeys("1980");

        //Seleccionar ¿Cuál es tu sexo? Mujer
        driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div/form/fieldset/div/div[2]/label/span[2]")).click();

        //Seleccionar Prefiero no recibir publicidad de Spotify
        driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div/form/div[6]/div/label/span[2]")).click();

        //Seleccionar Compartir mis datos de registro con los proveedores de contenido de Spotify para fines de marketing.
        driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div/form/div[7]/div/label/span[2]/span")).click();

        //Hacer clic en Registrarte
        driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div/form/div[9]/div/button/div[1]")).click();

        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.spotify.com/uy/signup/?sp_t_counter=1");



    }


}
