package mainpack;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class InteracaoComCombo {
	
	@Test
	public void interageComCombox() {
		
		//------------------------------inicializando o driver-----------------------------------//
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/franc/Downloads/campo_treinamento/componentes.html");
		// ------------------------------------------------------------------------------------- // 
		
// ----- Criando um objeto Select que faz referência a um WebElement, assim posso interagir com Comboxes ----- //
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select (element);
// ------------------------------------------------------------------------------------------------------------//	
		
		
		// Selecionando o item ''Karate'' e validando que realmente está selecionado: 
		combo.selectByVisibleText("Karate");
		assertEquals("Karate", combo.getFirstSelectedOption().getAttribute("value"));
		
		//Selecionando os itens Natacao e Futebol através de seus indices: 
		combo.selectByIndex(0);
		combo.selectByIndex(1);
		
		// Criando uma lista que guarda todas as opções disponíveis no Combox 
		List<WebElement> opcoes = combo.getOptions();
		
		// Lógica para  percorrer a lista ''opcoes '' e validar se dentro dela existe a opção ''Corrida'' disponível.
		boolean existe = false;
		
		for (WebElement opcao : opcoes) {
			
			if (opcao.getText().equals("Corrida")) {
				
				existe = true;
				break;
			}
		}
		
		// Como a opção ''Corrida'' existe dentro do combox, esse assert passará com sucesso, se eu trocar por uma opção inexistente, o teste falhará. 
		assertTrue(existe);
		
	
		
		
		
		
		
		
		
	   
	  
		
		driver.quit();
		
		
		
		
		
		
	
		
		
		
		
	}

}
