package mainpack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidaTituloPagina {
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
	public void validaTitulo() {
		
		assertEquals("Campo de Treinamento", driver.getTitle());
	}

}
