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

public class Amazon {
	
    private static ChromeDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

 
    



    @Test
    public void test2() throws InterruptedException, LineUnavailableException {
        driver.get("https://www.amazon.com/gp/product/B09DP86ZDH");
      
        
     String txt=   driver.findElement(By.id("availability")).getText();
     System.out.println(txt);
     
     while(txt.contains("Currently unavailable.")){
    	 Thread.sleep(5000);
    	 driver.navigate().refresh();
     txt=   driver.findElement(By.id("availability")).getText();
    	 
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
