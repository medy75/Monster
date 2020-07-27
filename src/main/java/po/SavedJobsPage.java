package po;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class SavedJobsPage extends PageObject{

  private static final Logger log = LogManager.getLogger(SavedJobsPage.class);

  private static final String SAVED_JOBS_TITLE_SELECTOR = "div.intro-wrapper h1";
  private static final String JOB_TITLES_LIST_SELECTOR = "div.header-actions > div > h2";


  public void isOnSavedJobsPage(){
    log.info("On Saved Jobs page.");
    String title = findElement(SAVED_JOBS_TITLE_SELECTOR).getText();
    Assert.assertEquals(title, "Saved Jobs", "You are not at Saved Jobs page.");
  }

  public void checkSavedJobs(List<String> jobs){
    log.info("Check saved jobs");
    List<WebElement> jobList = findElements(JOB_TITLES_LIST_SELECTOR);
    for (int i = 0; i < jobList.size(); i++){
      String jobTitle = jobList.get(i).getText();
      Assert.assertTrue(doesListContainString(jobs, jobTitle), "List does not contain " + jobTitle);
    }

  }

  private boolean doesListContainString(List<String> list, String text){
    log.debug("Checking that {} is in a list", text);
    return list.contains(text);
  }
}
