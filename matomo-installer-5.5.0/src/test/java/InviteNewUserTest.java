import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InviteNewUserTest {
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
    @DisplayName("Invite new user")
    public void testInviteNewUser(){
        driver.findElement(By.id("login_form_login")).sendKeys("admin");
        driver.findElement(By.id("login_form_password")).sendKeys("e2eW3Bt3s71nGB3nchM4rK");
        driver.findElement(By.id("login_form_submit")).click();
        driver.findElement(By.id("topmenu-coreadminhome")).click();
        driver.findElement(By.linkText("System")).click();
        driver.findElement(By.linkText("Users")).click();
        driver.findElement(By.className("add-new-user")).click();
        driver.findElement(By.id("user_login")).sendKeys("user");
        driver.findElement(By.id("user_email")).sendKeys("user@matomo.com");
        driver.findElement(By.cssSelector("input.btn[value='Invite user']")).click();
        WebElement modal = driver.findElement(By.cssSelector(".confirm-password-modal.modal.open"));
        WebElement passwordInput = modal.findElement(By.cssSelector("input[type='password']"));
        passwordInput.sendKeys("e2eW3Bt3s71nGB3nchM4rK");
        driver.findElement(By.xpath("//a[contains(@class, 'modal-action') and contains(text(), 'Confirm') and not(@disabled)]")).click();
        WebElement message = driver.findElement(By.className("notification-body"));
        assertEquals("Invitation sent.", message.getText().trim());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}