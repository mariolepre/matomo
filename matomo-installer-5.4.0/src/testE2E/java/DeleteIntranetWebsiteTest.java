import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DeleteIntranetWebsiteTest {
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
    @DisplayName("Delete Intranet Website")
    public void testDeleteIntranetWebsite() {
        driver.findElement(By.id("login_form_login")).sendKeys("admin");
        driver.findElement(By.id("login_form_password")).sendKeys("e2eW3Bt3s71nGB3nchM4rK");
        driver.findElement(By.id("login_form_submit")).click();
        driver.findElement(By.id("topmenu-coreadminhome")).click();
        driver.findElement(By.linkText("Measurables")).click();
        driver.findElement(By.linkText("Manage")).click();
        WebElement table = driver.findElement(By.className("sitesManagerList"));
        List<WebElement> rows = table.findElements(By.cssSelector(".site.card.hoverable"));
        boolean found = false;
        for (WebElement row : rows) {
            WebElement websiteCard = row.findElement(By.cssSelector("h4"));
            String rowText = websiteCard.getText();
            if (rowText.equals("Intranet Web Test")) {
                row.findElement(By.cssSelector("button[title='Delete']")).click();
                WebElement modal = driver.findElement(By.cssSelector(".confirm-password-modal.modal.open"));
                WebElement passwordInput = modal.findElement(By.cssSelector("input[type='password']"));
                passwordInput.sendKeys("e2eW3Bt3s71nGB3nchM4rK");
                driver.findElement(By.xpath("//a[contains(@class, 'modal-action') and contains(text(), 'Confirm') and not(@disabled)]")).click();
                found = true;
                break;
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
