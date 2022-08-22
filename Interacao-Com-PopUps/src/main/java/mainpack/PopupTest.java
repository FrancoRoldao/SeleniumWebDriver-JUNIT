package mainpack;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopupTest {
	
	private WebDriver driver;
	
	@Before
	public void inicializaTestes() {
		
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/franc/Downloads/campo_treinamento/componentes.html");
		driver.manage().window().maximize();
	}
	
	@After
	public void finalizaTestes() {
		driver.quit();
	}
	
	

	@Test
	public void interageComPopupEValidaCampoExistente() {
		
		driver.findElement(By.id("buttonPopUpEasy")).click();
		// setando o driver para o popup
		driver.switchTo().window("Popup");
		
		assertTrue(driver.findElement(By.tagName("textarea")).isDisplayed());
		// voltando para a página principal 
		driver.switchTo().window("");
	}
}
