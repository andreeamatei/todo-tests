import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AllTodoTests {

    WebDriver driver;
    String baseUrl = "https://melaniam.github.io/my-workshops/front-end-basics/code/index.html";

    @BeforeClass
    public void beforeClass() {
       driver = new ChromeDriver();
       driver.manage().window().maximize();
    }

    @Test(description="Check title")
    public void testTitle() {
        driver.get(baseUrl);
        HelperMethods helperMethods = new HelperMethods(driver);

        Assert.assertEquals(helperMethods.getTitleText(), "My TODO List", "Title is incorrect");
    }

    @Test(description="Add a task")
    public void addTask() {
        driver.get(baseUrl);
        HelperMethods helperMethods = new HelperMethods(driver);

        helperMethods.clickAddButton();
        helperMethods.typeInField("Buy milk");
        helperMethods.clickSaveButton();

        Assert.assertEquals(helperMethods.getTaskSize(), 1, "Task was not added");
        Assert.assertEquals(helperMethods.getTaskText(0), "Buy milk", "Task text is incorrect");
    }

    @Test(description="Delete a task", dependsOnMethods = {"addTask"})
    public void deleteTask() {
        driver.get(baseUrl);
        HelperMethods helperMethods = new HelperMethods(driver);

        helperMethods.clickDeleteButton(0);

        Assert.assertEquals(helperMethods.getTaskSize(), 0, "Task was not deleted");
    }

    @Test(description="Select a task then delete", dependsOnMethods = {"addTask"})
    public void selectAndDeleteTask() {
        driver.get(baseUrl);
        HelperMethods helperMethods = new HelperMethods(driver);

        helperMethods.clickCheckbox(0);
        Assert.assertTrue(helperMethods.isTaskStriked(0), "Task was not deleted");

        helperMethods.clickDeleteButton(0);
        Assert.assertEquals(helperMethods.getTaskSize(), 0, "Task was not deleted");
    }

    @Test(description="Add 5 tasks")
    public void addMoreTasks() {
        driver.get(baseUrl);
        HelperMethods helperMethods = new HelperMethods(driver);
        for(int i = 0; i < 5; i++) {
            String random = RandomStringUtils.randomAlphabetic(10);

            helperMethods.clickAddButton();
            helperMethods.typeInField(random);
            helperMethods.clickSaveButton();
            Assert.assertTrue(helperMethods.isTaskDisplayed(i), "Task is not displayed");
            Assert.assertEquals(helperMethods.getTaskText(i), random, "Task text is incorrect");
        }

        Assert.assertEquals(helperMethods.getTaskSize(), 5, "Tasks were not added");

    }

    @AfterClass
    public void afterClass() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
