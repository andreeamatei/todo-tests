import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToDoTests {
    @Test(description="Check title")
    public void testTitle() {
    WebDriver driver = new ChromeDriver();
    driver.get("https://melaniam.github.io/my-workshops/front-end-basics/code/index.html");
    Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "My TO DO List", "Title is incorrect");
    }
}
