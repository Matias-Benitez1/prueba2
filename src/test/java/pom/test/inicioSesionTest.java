package pom.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.events.*;
import pom.events.inicioSesion;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class inicioSesionTest {
	WebDriver driver;
	inicioSesion InicioSesion;

	@BeforeClass
	public void beforeClass() {
		InicioSesion = new inicioSesion(driver);
		driver = InicioSesion.ChromeDriverConnection();
		driver.manage().window().maximize();
		InicioSesion.visit("https://demo.testfire.net/login.jsp");
	}

	@Test
	public void testInicioSesion() throws InterruptedException {
		String currentTestCase = new Throwable().getStackTrace()[0].getMethodName();
		
		try {
			InicioSesion.inicioSesionPagina();
			InicioSesion.transferir();
			InicioSesion.message();
			InicioSesion.cerrarSesion();
			
		}  catch (Exception e) {
			// TODO: handle exception
			System.out.println(" *** Algo fallo en el test nombre: " + currentTestCase);
		}
		//InicioSesion.test();
		//InicioSesion.transferir();
		//InicioSesion.cerrarSesion();
		
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}
}
