import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DeleteUserTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // Implicit wait di 10 secondi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://localhost:8082/");
    }

    @Test
    @DisplayName("Delete an user")
    public void testDeleteUser(){
        driver.findElement(By.id("login_form_login")).sendKeys("admin");
        driver.findElement(By.id("login_form_password")).sendKeys("e2eW3Bt3s71nGB3nchM4rK");
        driver.findElement(By.id("login_form_submit")).click();
        driver.findElement(By.id("topmenu-coreadminhome")).click();
        driver.findElement(By.linkText("System")).click();
        driver.findElement(By.linkText("Users")).click();
        WebElement usersTable = driver.findElement(By.id("manageUsersTable"));
        List<WebElement> users = usersTable.findElements(By.cssSelector("tbody tr"));
        boolean found = false;
        for (WebElement user : users) {
            WebElement userId = user.findElement(By.id("userLogin"));
            if(userId.getText().equals("user")){
                found = true;
                user.findElement(By.cssSelector("button[title='Delete']")).click();
                WebElement modal = driver.findElement(By.cssSelector(".confirm-password-modal.modal.open"));
                WebElement passwordInput = modal.findElement(By.cssSelector("input[type='password']"));
                passwordInput.sendKeys("e2eW3Bt3s71nGB3nchM4rK");
                driver.findElement(By.xpath("//a[contains(@class, 'modal-action') and contains(text(), 'Confirm') and not(@disabled)]")).click();
                WebElement message = driver.findElement(By.className("notification-body"));
                assertEquals("The selected users have been removed.", message.getText().trim());
            }
        }
        assertTrue(found);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}