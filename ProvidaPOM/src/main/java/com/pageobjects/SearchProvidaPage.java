package com.pageobjects;

import java.io.IOException;

import org.apache.poi.hpsf.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.components.Base;
import com.components.ExcelDataProvider;
import com.components.Screenshot;

public class SearchProvidaPage extends Base {


	// Se agrego el constructor
	public SearchProvidaPage(WebDriver driver) {
		super(driver);

	}
	
	
	// Localizadores
	By configAvanzada = By.id("details-button");
	By procedLink = By.id("proceed-link");
	By userName = By.id("UserIdInput");
	By password = By.id("pwdtxt");
	By passwordTwo = By.id("PASSWORD");
	By domain = By.id("DOMAIN");
	By login = By.id("SignInButtonText");
	
	By btnGenerales = By.xpath("//*[@id=\"root\"]/div[3]/div/div/div[4]/div/div[2]/a");
	
	By btnConsultador = By.cssSelector("#root > div.container > div > div > div:nth-child(1) > div > div.card-footer.border-0.pb-4 > a");
	
	By txtPoliza = By.name("poliza");
	By btnBuscar = By.cssSelector("#root > div.container > div > div > form > div:nth-child(5) > div:nth-child(1) > button");
	
	By lnkNumPoliza = By.cssSelector("#root > div.container > div > div.ml-table-container > div.table-responsive-sm > table > tbody > tr > td:nth-child(1) > a");
	
	By InfoGenral = By.cssSelector("#root > div.container > div.fixed-bottom.ml-table-container > div > table > tbody > tr > td:nth-child(1) > a");
	
	By DatosContacto = By.cssSelector("#root > div.container > div.fixed-bottom.ml-table-container > div > table > tbody > tr > td:nth-child(2) > a");
	
	By Coberturas = By.cssSelector("#root > div.container > div.fixed-bottom.ml-table-container > div > table > tbody > tr > td:nth-child(3) > a");
	
	By Beneficiarios = By.cssSelector("#root > div.container > div.fixed-bottom.ml-table-container > div > table > tbody > tr > td:nth-child(4) > a");
	
	By Servicios = By.cssSelector("#root > div.container > div.fixed-bottom.ml-table-container > div > table > tbody > tr > td:nth-child(5) > a");	
	
	By Agente = By.cssSelector("#root > div.container > div.fixed-bottom.ml-table-container > div > table > tbody > tr > td:nth-child(5) > a");
	
	
	//public void SearchProvida throws InterruptedException {
			//ExcelDataProvider datos = new ExcelDataProvider("./data/PROVIDA.xls");
			//for(int i = 0;i < datos.getNumRows();i++) {
				//datos.setRow(i);
			//}
			
	

		public void loginUser() throws Exception {
			System.out.println("Si entro1");
			Thread.sleep(5000);
			click(configAvanzada);
			click(procedLink);
			
			type("AguilarHernandezG", userName);
			click(password);
			type("arb7ebpAng", passwordTwo);
			type("ALICOCORP", domain);
			screenshot("ALICO");
			click(login);
			Thread.sleep(5000);
			
		}
		
		public void MenuGenerales() throws InterruptedException {
			System.out.println("Si entro2");
			Thread.sleep(2000);
			click(btnGenerales);
			Thread.sleep(2000);
		}
		
		public void SubmenuConsultador() {
			System.out.println("Si entro3");
			click(btnConsultador);
		}
		
		public void typePoliza() {
			System.out.println("Si entro4");
			type("PVN456",txtPoliza);
			
		}
		
		public void BuscarPoliza() throws InterruptedException {
			System.out.println("Si entro5");
			click(btnBuscar);
			Thread.sleep(2000);
			
		}
		
		public void lnkPoliza() {
			System.out.println("Si entro6");
			click(lnkNumPoliza);
		}
		
		public void InfoGeneral() {
			System.out.println("Si entro7");
			click(InfoGenral);
		}
		
		public void DatosContacto() {
			System.out.println("Si entro8");
			click(DatosContacto);
		}
		
		public void Coberturas() {
			System.out.println("Si entro9");
			click(Coberturas);
		}
		public void Beneficiarios() {
			System.out.println("Si entro10");
			click(Beneficiarios);
		}
		public void Servicios() {
			System.out.println("Si entro11");
			click(Servicios);
		}
		public void Agente() {
			System.out.println("Si entro12");
			click(Agente);
		}

}



