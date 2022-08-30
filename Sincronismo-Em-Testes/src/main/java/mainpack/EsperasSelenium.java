package mainpack;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EsperasSelenium {
	
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

                   // ESPERA FIXA// 
	
	/* Este é um recurso da linguagem java, da classe Thread; 
	// O método sleep() é usado para parar a execução do thread atual (o que quer que esteja em execução no sistema) por um período específico de tempo e, após esse período de 
	// tempo terminar, o thread que está executando antes começa a executar novamente.
	// É uma opção de espera POUCO usada, pois faz o teste cair muito na performance, e mesmo que o elemento seja encontrado antes do tempo estipulado, a espera seguirá firme
	   até o último segundo. 
	*/ 
   
	@Test
    public void esperaFixa() throws InterruptedException {
    	
    	driver.findElement(By.id("buttonDelay")).click();
    	Thread.sleep(4000);
    	driver.findElement(By.id("novoCampo")).sendKeys("Escrita deu certo");
    	assertEquals("Escrita deu certo", driver.findElement(By.id("novoCampo")).getAttribute("value"));
    	
    }
	
	       // ESPERA IMPLÍCITA // 
	
	/* Esse tipo de espera é "genérica", aqui eu configuro um tempo MÁXIMO de espera, para o driver usar sempre enquanto
	 qualquer elemento não for encontrado. 
	 a principal diferença entre essa e a fixa, é que nesse tipo de espera, mesmo que esteja configurado um tempo
	 de 10 segundos, se o elemento for encontrado em apenas 2 segundos, o fluxo não ficará preso atoa e será liberado;
	
	  - vale lembrar que se o elemento não for encontrado dentro do periodo que especifiquei, o teste falhará e será
	  necessário configurar um tempo maior  
	*/
	
	@Test
	public void esperaImplicita() {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("buttonDelay")).click();
		driver.findElement(By.id("novoCampo")).sendKeys("Escrita deu certo");
		assertEquals("Escrita deu certo", driver.findElement(By.id("novoCampo")).getAttribute("value"));
		
	}
	
	// ESPERA EXPLICÍTA //
	
	/*
	 Esse tipo de espera é o mais recomendado em muitos casos, pois estou deixando claro QUANDO e por QUEM a espera deverá ocorrer; 
	 - assim a performance fica bem melhor 
	 - Nesse tipo de espera também é configurado um tempo MÁXIMO (mesmo processo da espera implicita)
	 */
	
	@Test
	public void esperaExplicita() {
		
		driver.findElement(By.id("buttonDelay")).click();
		
		//Basta criar um objeto da classe WebDriverWait e passa o driver + tempo como parâmetro
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo"))).sendKeys("Escrita deu certo");
		assertTrue(driver.findElement(By.id("novoCampo")).isDisplayed());
	}
	
	
	
}