import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import javax.sound.midi.*;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

import java.util.*;

public class WebDriver {
	
    private static ChromeDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

 
    



    @Test
    public void test() throws InterruptedException, LineUnavailableException {
        driver.get("https://www.bestbuy.com/site/microsoft-xbox-series-x-black/6477938.p?skuId=6477938");
        driver.findElement(By.className("us-link")).click();
        
     String txt=   driver.findElement(By.className("fulfillment-add-to-cart-button")).getText();
     System.out.println(txt);
     
     while(txt.equals("Coming Soon")){
    	 Thread.sleep(5000);
    	 driver.navigate().refresh();
    	 txt=  driver.findElement(By.className("fulfillment-add-to-cart-button")).getText();
    	 
     }
     
	while(true) {
		 Thread.sleep(1000);
	    byte[] buf = new byte[ 1 ];;
	    AudioFormat af = new AudioFormat( (float )44100, 8, 1, true, false );
	    SourceDataLine sdl = AudioSystem.getSourceDataLine( af );
	    sdl.open();
	    sdl.start();
	    for( int i = 0; i < 1000 * (float )44100 / 1000; i++ ) {
	        double angle = i / ( (float )44100 / 440 ) * 2.0 * Math.PI;
	        buf[ 0 ] = (byte )( Math.sin( angle ) * 100 );
	        sdl.write( buf, 0, 1 );
	    }
	    sdl.drain();
	    sdl.stop();
	}

    
     
        
    }

}
