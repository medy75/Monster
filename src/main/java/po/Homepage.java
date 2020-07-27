package po;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Homepage extends PageObject{

  private static final Logger log = LogManager.getLogger(Homepage.class);

  private static final String CREATE_ACCOUNT_BUTTON_SELECTOR = "#main-content > div > div.ng-scope > div > div > section.content-wrapper-adjuster.content-wrapper-bottom-adjuster.ng-scope > div.tabs-component.tab-selected-index-1 > div > div.tab-pane.ng-scope.active > div > div:nth-child(3) > a > span";

  public Homepage(){
    log.info("Go to homepage");
    driver.get("https://www.monsterworksdemo.com/home/");
  }

  public NewAccountPage clickOnCreateAccountButton(){
    log.info("Click on Create Account button");
    clickOn(CREATE_ACCOUNT_BUTTON_SELECTOR);
    return new NewAccountPage();
  }
}
