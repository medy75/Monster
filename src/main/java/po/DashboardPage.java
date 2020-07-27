package po;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DashboardPage extends PageObject{

  private static final Logger log = LogManager.getLogger(DashboardPage.class);

  private static final String PHILIPS_JOBS_SELECTOR = "#main-footer > div.row.footer-links > div:nth-child(4) > ul > li:nth-child(3) > a";

  public JobListPage goToPhilipsJobs(){
    log.info("Go to Philips jobs page");
    waitForVisibility(PHILIPS_JOBS_SELECTOR);
    clickOn(PHILIPS_JOBS_SELECTOR);
    return new JobListPage();
  }

}
