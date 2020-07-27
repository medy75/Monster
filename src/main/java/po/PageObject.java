package po;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverManager;

public class PageObject {

  private static final Logger log = LogManager.getLogger(PageObject.class);

  protected WebDriver driver = DriverManager.getDriver();

  protected WebElement findElement(String cssSelector){
    return findElement(By.cssSelector(cssSelector));
  }

  protected WebElement findElement(By by){
    log.debug("Search element by {}", by.toString());
    waitForElement(by);
    return driver.findElement(by);
  }

  protected List<WebElement> findElements(String cssSelector){
    return findElements(By.cssSelector(cssSelector));
  }

  protected List<WebElement> findElements(By by){
    waitForElement(by);
    return driver.findElements(by);
  }

  protected void clickOn(String cssSelector){
    waitForClickability(cssSelector);
    findElement(cssSelector).click();
  }

  protected void sendKeys(String cssSelector, String text){
    findElement(cssSelector).sendKeys(text);
  }

  protected void selectByValue(String cssSelector, String value){
    new Select(findElement(cssSelector)).selectByValue(value);
  }

  protected void waitForVisibility(String cssSelector) {
    waitForVisibility(By.cssSelector(cssSelector));
  }

  protected void waitForInvisibility(String cssSelector) {
    waitForInvisibility(By.cssSelector(cssSelector));
  }

  protected void waitForClickability(String cssSelector) {
    waitForClickability(By.cssSelector(cssSelector));
  }

  private void waitForElement(By by){
    (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(by));
  }

  private void waitForVisibility(By by) {
    (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(by));
  }

  private void waitForInvisibility(By by) {
    (new WebDriverWait(driver, 10)).until(ExpectedConditions.invisibilityOfElementLocated(by));
  }

  private void waitForClickability(By by) {
    (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
  }

  protected void hover(String cssSelector){
    Actions action = new Actions(driver);
    WebElement we = driver.findElement(By.cssSelector(cssSelector));
    action.moveToElement(we).build().perform();
  }

  protected void sleep(long millis){
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
