package stepsdefinitions;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.components.Base;
import com.components.Screenshot;
import com.pageobjects.SearchProvidaPage;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchProvidaStepsDefinitions {

	private WebDriver driver;
	
	//Se crea un objeto para utilizar los metodos de la clase SearchProvidaPage
	SearchProvidaPage searchProvidaPage;
	
	@Given("^I enter the chrome browser$")
	public void i_enter_the_chrome_browser() throws Throwable {
		searchProvidaPage = new SearchProvidaPage(driver);
		driver = searchProvidaPage.chromeDriverConnection();
		searchProvidaPage.url("https://ssologin-qa.metlife.com/siteminderagent/forms/ADms19/login.fcc?TYPE=167772161&REALMOID=06-000af0e3-14a2-1ca6-8d18-676bac18f041&GUID=0&SMAUTHREASON=0&METHOD=GET&SMAGENTNAME=$SM$wXppiWyb83Qc33OagUJ69JumV2uy0q327G43wN3zU14JEbOT6t%2fPdBCCJjXOoodw&TARGET=$SM$https%3a%2f%2fqa%2eprovidamx%2emetlife%2ecom%2fProvidaWeb%2f");
		driver.manage().window().maximize();
		System.out.println("Ya sali del metodo I enter the chrome browser");
	}

	@And("^Enter the page Provida with valid credentials$")
	public void enter_the_page_Provida_with_valid_credentials() throws Throwable {
		searchProvidaPage.loginUser();
	}
	
	@When("^I enter to Generales$")
	public void i_enter_to_Generales() throws Throwable {
		
		searchProvidaPage.MenuGenerales();  
		
	
	}

	@And("^Selec to Consultador$")
	public void selec_to_Consultador() throws Throwable {
	    searchProvidaPage.SubmenuConsultador();
	   
	}

	@And("^Enter the policy number$")
	public void enter_the_policy_number() throws Throwable {
	  searchProvidaPage.typePoliza(); 
	}

	@And("^Click on Buscar$")
	public void click_on_Buscar() throws Throwable {
	    searchProvidaPage.BuscarPoliza();
	   
	}

	@Then("^Click on link policy number$")
	public void click_on_link_policy_number() throws Throwable {
	    searchProvidaPage.lnkPoliza();
	   
	}

	

	@And("^Valid section Informacion General$")
	public void valid_section_Informacion_General() throws Throwable {
	    searchProvidaPage.InfoGeneral();
	    
	}
	
	

	@And("^Valid section Datos de contacto$")
	public void valid_section_Datos_de_contacto() throws Throwable {
	    searchProvidaPage.DatosContacto();
	    
	}

	@And("^Valid section Coberturas$")
	public void valid_section_Coberturas() throws Throwable {
	   searchProvidaPage.Coberturas();
	  
	}

	@And("^Valid section Beneficiarios$")
	public void valid_section_Beneficiarios() throws Throwable {
		searchProvidaPage.Beneficiarios();
		
	}

	@And("^Valid section Servicios$")
	public void valid_section_Servicios() throws Throwable {
	    searchProvidaPage.Servicios();
	   
	}

	@And("^Valid section Agentes$")
	public void valid_section_Agentes() throws Throwable {
	    searchProvidaPage.Agente();
	   	}

	@And("^Logout$")
	public void logout() throws Throwable {
	    driver.quit();
	   
	}


	
	
}
