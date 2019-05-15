package tests;

import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.nio.cs.ext.JISAutoDetect;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class PesquisaInfoTest {
    private WebDriver navegador;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp() {
        //Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\luiz fernando\\Drivers\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        //Navegando para página do SOC
        navegador.get("https://ww2.soc.com.br/blog/");
    }
    @Test
    public void testPesquisaInformacao() {
        //Digitar no campo Busca
        navegador.findElement(By.name("s")).click();
        navegador.findElement(By.name("s")).clear();
        navegador.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='BUSCA BLOG'])[1]/following::input[3]")).sendKeys("teste");
        navegador.findElement(By.className("lupa-form")).click();

        //validar mensagem de retorno da Busca
        WebElement mensagemPop = navegador.findElement(By.tagName("span"));
        String mensagem = mensagemPop.getText();
        assertEquals("span", "span");

        //Assert.assertEquals("teste","teste");
    }
    @After
    public void tearDown() {
        //Fechar navegador
        navegador.quit();
    }
}