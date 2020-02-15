import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HelperMethods {

    public static final String H1_TAGNAME = "h1";

    @FindBy(tagName = H1_TAGNAME)
    WebElement title;

    public HelperMethods(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public String getTitleText()
    {
        return title.getText();
    }
}
