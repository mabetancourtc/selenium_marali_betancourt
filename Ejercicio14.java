package Practico1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Ejercicio14 {
    @Test
    public void accederNetflix(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get ("https://www.netflix.com/cl/");

        //Mostrar los elementos h1 y h2 que hay en el sitio
        List<WebElement> listaH1 = driver.findElements(By.tagName("h1"));
        System.out.println("La Cantidad de elementos H1 del sitio " + driver.getTitle() + " son: " + listaH1.size());
          for (WebElement elementoH1: listaH1){
            System.out.println("H1: " + elementoH1.getText());
        }

        List<WebElement> listaH2 = driver.findElements(By.tagName("h2"));
        System.out.println("La Cantidad de elementos H2 del sitio " + driver.getTitle() + " son: " + listaH2.size());
         for (WebElement elementoH2: listaH2){
            System.out.println("H2: " + elementoH2.getText());
        }

        //Refrescar la página
        driver.navigate().refresh();

        //Mostrar el texto de los botones que se encuentran en la página
        List<WebElement> botones= driver.findElements(By.tagName("button"));
        for (WebElement elementboton: botones){
            System.out.println("Boton: " + elementboton.getText());
        }

        //Mostrar la cantidad de elementos div que contiene el sitio
        List<WebElement> elementosDiv= driver.findElements(By.tagName("div"));
        System.out.println("La cantidad de elementos div es: " + elementosDiv.size());

        //Obtener y mostrar el título de la página
        String titulo = driver.getTitle();
        System.out.println(titulo);

        //Mostrar la cantidad de elementos de tipos link
        List<WebElement> elementosA= driver.findElements(By.tagName("a"));
        System.out.println("La cantidad de elementos Link es: " + elementosA.size());


    }


}
