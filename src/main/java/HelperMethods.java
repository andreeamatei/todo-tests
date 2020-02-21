import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HelperMethods {

    public static final String H1_TAGNAME        = "h1";
    public static final String ADD_BUTTON_ID     = "add";
    public static final String DELETE_BUTTON_ID  = "delete_btn";
    public static final String ADD_FORM_ID       = "add-todo-form";
    public static final String TEXTFIELD_XPATH   = "//*[@id='add-todo-form']/input";
    public static final String SAVE_BUTTON_CLASS = "save_btn";
    public static final String CHECKBOX_CLASS    = "checkbox";
    public static final String TASK_XPATH        = "//*[@id='todo-list']/li/span";

    @FindBy(tagName = H1_TAGNAME)
    WebElement title;

    @FindBy(id = ADD_BUTTON_ID)
    WebElement addButton;

    @FindBy(id = DELETE_BUTTON_ID)
    List<WebElement> deleteButton;

    @FindBy(id = ADD_FORM_ID)
    WebElement addForm;

    @FindBy(className = SAVE_BUTTON_CLASS)
    WebElement saveButton;

    @FindBy(className = CHECKBOX_CLASS)
    List<WebElement> checkBox;

    @FindBy(xpath = TEXTFIELD_XPATH)
    WebElement textField;

    @FindBy(xpath = TASK_XPATH)
    List<WebElement> task;

    public HelperMethods(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public String getTitleText()
    {
        return title.getText();
    }

    public String getTaskText(int i)
    {
        return task.get(i).getText();
    }

    public int getTaskSize()
    {
        return task.size();
    }

    public void clickAddButton()
    {
        addButton.click();
    }

    public void clickDeleteButton(int i)
    {
        deleteButton.get(i).click();
    }

    public void clickSaveButton()
    {
        saveButton.click();
    }

    public void clickCheckbox(int i)
    {
        checkBox.get(i).click();
    }

    public void typeInField(String string)
    {
        textField.sendKeys(string);
    }

    public boolean isTaskStriked(int i)
    {
        return task.get(i).getCssValue("text-decoration").contains("line-through");
    }

    public boolean isTaskDisplayed(int i)
    {
        return task.get(i).isDisplayed();
    }
}
