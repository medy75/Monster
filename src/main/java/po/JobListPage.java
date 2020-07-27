package po;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class JobListPage extends PageObject{

  private static final Logger log = LogManager.getLogger(JobListPage.class);

  private static final String JOB_LIST_SELECTOR = "#SearchResults";
  private static final String ALL_JOBS_LIST_SELECTOR = JOB_LIST_SELECTOR + " section";
  private static final String JOB_LIST_TITLE_SELECTOR = "h2";

  private static final String PLACEHOLDER_SELECTOR = "#JobPreview > span";
  private static final String JOB_TITLE_SELECTOR = "#JobViewHeader > header > div.heading > h1";

  private static final String SAVE_BUTTON_SELECTOR = "#SaveJob";

  private static final String MENU_MY_JOB_SELECTOR = "#dropdown-My-job-search";
  private static final String MENU_SAVED_JOBS_SELECTOR = "#main-navigation > div > ul > li:nth-child(2) > ul > li:nth-child(6) > a";


  public String saveSecondJob(){
    return saveNthJob(2);
  }

  public String saveLastJob(){
    return saveNthJob(findElements(ALL_JOBS_LIST_SELECTOR).size());
  }

  public SavedJobsPage gotoSavedJobs(){
    log.info("Go to Menu > Saved jobs");
    findElement(MENU_MY_JOB_SELECTOR);
    hover(MENU_MY_JOB_SELECTOR);
    clickOn(MENU_SAVED_JOBS_SELECTOR);
    return new SavedJobsPage();
  }

  private String saveNthJob(int number){
    log.info("Select {} job", number);
    WebElement job = findElements(ALL_JOBS_LIST_SELECTOR).get(number-1);
    String jobTitle = job.findElement(By.cssSelector(JOB_LIST_TITLE_SELECTOR)).getText();
    job.click();
    sleep(500);
    waitForInvisibility(PLACEHOLDER_SELECTOR);
    String mainTitle = findElement(JOB_TITLE_SELECTOR).getText();
    saveJob();
    return jobTitle;
  }

  private void saveJob(){
    log.info("Save job");
    clickOn(SAVE_BUTTON_SELECTOR);
  }

}
