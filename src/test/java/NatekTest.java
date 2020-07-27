import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import driver.DriverManager;
import po.DashboardPage;
import po.Homepage;
import po.JobListPage;
import po.NewAccountPage;
import po.SavedJobsPage;


public class NatekTest {

  private static final Logger log = LogManager.getLogger(NatekTest.class);
  private WebDriver driver;

  @BeforeMethod
  public void setUp() {
    log.info("Setup");
    driver = DriverManager.getDriver();
  }

  @Test
  public void jobTest() {
    List<String> jobs = new LinkedList<>();
    log.info("Starting jobTest");
    Homepage homepage = new Homepage();
    NewAccountPage newAccountPage = homepage.clickOnCreateAccountButton();
    DashboardPage dashboardPage = newAccountPage.createAccount();
    JobListPage jobListPage = dashboardPage.goToPhilipsJobs();
    jobs.add(jobListPage.saveSecondJob());
    jobs.add(jobListPage.saveLastJob());
    SavedJobsPage savedJobsPage = jobListPage.gotoSavedJobs();
    savedJobsPage.isOnSavedJobsPage();
    savedJobsPage.checkSavedJobs(jobs);
  }

  @AfterMethod
  public void tearDown(ITestResult result) {
    log.info("End of test");
    if (!result.isSuccess()){
      log.error("URL: {}", driver.getCurrentUrl());
      takeScreenshot();
    }
    driver.quit();
  }

  private void takeScreenshot(){
    try {
      byte[] screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
      FileUtils.writeByteArrayToFile(new File("screenshot.png"), screen);
    } catch (IOException e) {
      log.error("Screenshot failed",e);
    }
  }
}
