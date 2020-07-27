package driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class DriverManager {

  private static final Logger log = LogManager.getLogger(DriverManager.class);
  private static WebDriver driver;

  public static WebDriver getDriver(){
    if (driver == null){
      log.info("Starting new instance of driver");
      ChromeDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
    }
    return driver;
  }
}
