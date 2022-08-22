package mainpack;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidaPreenchimentoObrigatorio {
	
	private WebDriver driver;
	
	@Before
	public void iniciaTestes() {
		
		 driver = new ChromeDriver();
		 driver.get("file:///C:/Users/franc/Downloads/campo_treinamento/componentes.html");
		 driver.manage().window().maximize();
		}
	
	@After
	public void finalizaTestes() {
		
		driver.quit();
	}
	
	@Test
	public void validaPreenchimentoObrigatorio() {
		
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alerta = driver.switchTo().alert();
		assertTrue(alerta.getText().equals("Nome eh obrigatorio"));
		alerta.accept();
		
		
	}

}
