//1-pacote 
package iterasys2;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//2-bibliotecas
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


//3-classes
public class Cursos {
	//3.1-atributos
	String url;
	WebDriver driver;
	
	//3.2-metódos
	@Before
	public void iniciar() {
		url = "https://www.iterasys.com.br";
		System.setProperty("webdriver.chrome.driver", "C:\\temp\\ws-eclipse-estudo-selenium\\iterasys2\\Chrome Driver\\88\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
	}
	
	@After
	public void finalizar() {	
		driver.quit();
		
	}
	
	
	@Test
	public void consultarCurso() {
		driver.get(url);//essa linhabre o navegador com essa url
		driver.findElement(By.id("searchtext")).clear();
		driver.findElement(By.id("searchtext")).sendKeys(Keys.chord("Mantis"));
		//tirar o screeshot
		driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
		
		//pagina que lista os cursos
		driver.findElement(By.cssSelector("span.comprar")).click();
		
		//pagina do carrinho de comprar
		
		//Resultados esperados
		String titulo = "Matis";
		String preco = "49,99";
		
		assertEquals(titulo,driver.findElement(By.cssSelector("span.item-title")).getText());
		assertEquals(preco,driver.findElement(By.cssSelector("span.new-price")).getText());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}	
