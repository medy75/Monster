package po;


import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NewAccountPage extends PageObject {

  private static final Logger log = LogManager.getLogger(NewAccountPage.class);

  private static final String EMAIL_FIELD_SELECTOR = "#c_elem_0";
  private static final String PASSWORD_FIELD_SELECTOR = "#a_elem_1";
  private static final String RE_PASSWORD_FIELD_SELECTOR = "#a_elem_2";
  private static final String JOB_CORP_SELECT_SELECTOR = "#elem_3";
  private static final String TAC_SWITCH_SELECTOR = "#id_option_label_elem_5-true > span.checkbox-custom.checkbox-toggle";
  private static final String CREATE_ACCOUNT_BUTTON_SELECTOR = "#main-content > div > div.ng-scope > div > ng-form > div > div > div:nth-child(8) > div > button:nth-child(2)";


  public NewAccountPage() {

  }

  public DashboardPage createAccount() {
    log.info("Filling account form");
    sendKeys(EMAIL_FIELD_SELECTOR, "test+" + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC) + "@test.cz");
    sendKeys(PASSWORD_FIELD_SELECTOR, "Password%123");
    sendKeys(RE_PASSWORD_FIELD_SELECTOR, "Password%123");
    selectByValue(JOB_CORP_SELECT_SELECTOR, "number:89314");
    clickOn(TAC_SWITCH_SELECTOR);
    waitForClickability(CREATE_ACCOUNT_BUTTON_SELECTOR);
    log.info("Click on Create Account button");
    clickOn(CREATE_ACCOUNT_BUTTON_SELECTOR);
    waitForInvisibility(EMAIL_FIELD_SELECTOR);
    return new DashboardPage();
  }

}
