package iterasys;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class Consulta {
	String url;
	WebDriver driver;
	
	@Before
	public void iniciar() {
		url="https://www.iterasys.com.br";
		System.setProperty("webdriver.chrome.driver", "C:\\temp\\ws-eclipse-estudo-selenium\\iterasys\\Chrome Driver\\88\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
	}
	
	@After
	public void finalizar() {
		driver.quit();
	}
	
	@Dado("^que cliente acessa o site da Iterasys$")
	public void que_cliente_acessa_o_site_da_Iterasys() {
	   driver.get(url);
	}

	@Quando("^realizo um consulta por \"([^\"]*)\"$")
	public void realizo_um_consulta_por(String termo)  {
	   driver.findElement(By.id("searchtext")).clear();
	   driver.findElement(By.id("searchtext")).sendKeys(Keys.chord(termo));
	   driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
	}

	@Entao("^exibe um conjunto de cursos$")
	public void exibe_um_conjunto_de_cursos()  {
	    assertEquals("Interasys - Cursos de Teste e QA",driver.getTitle());
	}

	@Quando("^clico no curso Inicio Rapido em Teste de Software$")
	public void clico_no_curso_Inicio_Rapido_em_Teste_de_Software()  {
	    driver.findElement(By.cssSelector("span.mais")).click();
	}

	@Entao("^valido que a duracao do curso sera \"([^\"]*)\" horas$")
	public void valido_que_a_duracao_do_curso_sera_horas(String horas) {
	   assertEquals("60 Horas de duração", driver.findElement(By.cssSelector("li.carga-horaria")).getText());
	}
}










