package com.components;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

public class Base {
	
	//Se crea el objeto Webdriver y se importa la librería
	private WebDriver driver;
	
	//Se crea el constructor de la clase como objeto Webdriver
	public Base(WebDriver driver) {
		this.driver = driver;
	}
	
	//Se crea el metodo para la conexcion con crhome
	public WebDriver chromeDriverConnection() {
		
		System.setProperty("webdriver.chrome.driver", "./dependencies/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
	//Metodo para ingresar a la URL
	public void url (String URL) {
		driver.get(URL);
	}
	
	//Metodo para escribir texto
	public void type (String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}
	
	//Metodo para dar clic a un boton
	public void click (By locator) {
		driver.findElement(locator).click();
	}
	
    public void keyEnter(By locator){
        driver.findElement(locator).sendKeys(Keys.chord(Keys.ENTER));
    }

    public void keyTab(By locator){
        driver.findElement(locator).sendKeys(Keys.chord(Keys.TAB));
    }
    
// metodo para hacer Scroll
    
    public void scroll () {
    	JavascriptExecutor jsx3 = (JavascriptExecutor)driver;
	    jsx3.executeScript("window.scrollBy(0,500)", "");
    	    	
    }
    
    public void explicitWaitElementVisible(By locator) {
    	WebDriverWait mientrasElementVisible = new WebDriverWait(driver, 10);
    	mientrasElementVisible.until(ExpectedConditions.visibilityOfElementLocated(locator));
	   
    }
    
    public void implicitWait () {
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
 /*   public static void takeSnapShot (By locator, String fileWithPath) throws Exception
    {
        TakesScreenshot scrShot = ((TakesScreenshot) locator);
        
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);
    }*/
   // este metodo saca la screenshot con base a un elemento del a pagina
    public void screenshot(String fileName) throws IOException{
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  // tomar captura de pantalla y almacenarla como formato de archivo
        FileUtils.copyFile(screenshotFile, new File ("C:/Users/hitss/git/ProvidaCucumber/ProvidaPOM/target/test-output/"+ fileName +".png"));  //copia la captura de pantalla y pegala en la ubicaion de deseada, con nombre del archivo deseado 
    	}
    
    
    /*public static void takeScreenshot(WebDriver webdriver, String testCaseName) {
		//Toma el screenshot de la pagina
		File scrFile = ((TakesScreenshot)webdriver).getScreenshotAs(OutputType.FILE);
		//Establecer ruta donde se va a guardar el screenshot
		String screenshotPath = Paths.get("").toAbsolutePath().toString() + File.separator 
				+ "test-output" + File.separator + "ExecutionResult"; 
		
		
		try {
			//Creamos el folder usando la ruta especificada en la variable "screenshot"
			FileHandler.createDir(new File(screenshotPath));
			//Copiar el screenshot generado en el objeto "scrFile" a la ruta especificada en "screneshot"
			FileHandler.copy(scrFile, new File(screenshotPath + File.separator + testCaseName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	     	}
        }*/ 
}    
       
			


