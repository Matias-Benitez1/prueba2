package pom.events;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pom.utils.Base;

public class inicioSesion extends Base {
	public inicioSesion(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By usernameLocator = By.cssSelector("input[id='uid']");
	By passwordLocator = By.cssSelector("input[id='passw']");
	By btnSubmitLocator = By.xpath("//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input");
	By imgLocator = By.xpath("//img[@src='/images/logo.gif']");
	By btnTransferLocator = By.cssSelector("a[id='MenuHyperLink3']");
	By fromAccountLocator = By.cssSelector("select[id='fromAccount']>option[value='800003']");
	By toAccountLocator = By.cssSelector("select[id='toAccount']>option[value='4539082039396288']");
	By montoLocator = By.cssSelector("input[id='transferAmount']");
	By btnTransferMoney = By.cssSelector("input[id='transfer']");
	By logoutLocator = By.cssSelector("a[id='LoginLink']");
	By usernameSignIn = By.cssSelector("body > table:nth-child(4) > tbody > tr > td:nth-child(2) > div > h1");
	//By mesgLocator = By.cssSelector("span[id='_ctl0__ctl0_Content_Main_message']");
	//By msgLocator = By.cssSelector("span[id='_ctl0__ctl0_Content_Main_postResp']");

	public void inicioSesionPagina() throws InterruptedException {
		String currentTestCase = new Throwable().getStackTrace()[0].getMethodName();
		try {
			//if (isDisplayed(imgLocator)) {
				type("jsmith", usernameLocator);
				Thread.sleep(2000);
				type("Demo1234", passwordLocator);
				Thread.sleep(2000);
				click(btnSubmitLocator);
				Thread.sleep(3000);
				//Assert.assertEquals(usernameSignIn, "Hello John Smith" );
			//} else {
				//System.out.println("Pagina no encontrada: ");
			//}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(" *** No se pudo ejecutar el metodo nombre: " + currentTestCase);
		}

	}

	public void transferir() throws InterruptedException {

		String currentTestCase = new Throwable().getStackTrace()[0].getMethodName();

		try {
			click(btnTransferLocator);
			Thread.sleep(3000);
			click(fromAccountLocator);
			Thread.sleep(2000);
			click(toAccountLocator);
			Thread.sleep(2000);
			type("100", montoLocator);
			Thread.sleep(2000);
			click(btnTransferMoney);
			System.out.println("Se ha transferido correctamente");
			Thread.sleep(3000);
			//Assert.assertEquals(msgLocator,"100.0 was successfully transferred from Account 800003 into Account 4539082039396288 at 7/5/22 3:55 PM.");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(" *** No se pudo ejecutar el metodo nombre: " + currentTestCase);
		}
	}
	public void message() {
		String mensajeObtenido = getText(By.cssSelector("span[id='_ctl0__ctl0_Content_Main_postResp']"));
	    mensajeObtenido = mensajeObtenido.substring(0, 5);
	    String mensajeEsperado = "100.0";
	    
	    Assert.assertEquals(mensajeEsperado, mensajeObtenido);
	    System.out.println("El mensaje obtenido es: " + mensajeObtenido);
	    
	    
	}


	public void cerrarSesion() throws InterruptedException {
		String currentTestCase = new Throwable().getStackTrace()[0].getMethodName();

		try {
			click(logoutLocator);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(" *** No se pudo ejecutar el metodo nombre: " + currentTestCase);
		}
		
	}
	
}

	