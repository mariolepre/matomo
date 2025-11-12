
import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChangeUserPassword {
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
    @DisplayName("Login with valid credentials")
    public void testChangeUserPassword() {
        driver.findElement(By.id("login_form_login")).sendKeys("admin");
        driver.findElement(By.id("login_form_password")).sendKeys("e2eW3Bt3s71nGB3nchM4rK");
        driver.findElement(By.id("login_form_submit")).click();
        driver.findElement(By.id("topmenu-coreadminhome")).click();
        driver.findElement(By.linkText("System")).click();
        driver.findElement(By.linkText("Users")).click();
        List<WebElement> usersList = driver.findElements(By.id("manageUsersTable"));
        for (WebElement cell : usersList) {
            if(cell.getText().contains("admin")){
                driver.findElement(By.cssSelector("button[title='Edit']")).click();
                WebElement newPassword = driver.findElement(By.id("user_password"));
                newPassword.clear();
                newPassword.sendKeys("e2eW3Bt3s71nGB3nchM4rK!");
                driver.findElement(By.cssSelector("input[value='Save Basic Info']")).click();
                WebElement passwordInput = driver.findElements(By.id("currentUserPassword"))
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Nessun campo password visibile trovato"));
                passwordInput.sendKeys("e2eW3Bt3s71nGB3nchM4rK");
                WebElement submit = driver.findElements(By.cssSelector("#content > div:nth-child(2) > div > div:nth-child(5) > div > div > div > div.confirm-password-modal.modal.open > div.modal-footer > a.modal-action.modal-close.btn"))
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Nessun campo visibile trovato"));
                submit.click();
            }
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}