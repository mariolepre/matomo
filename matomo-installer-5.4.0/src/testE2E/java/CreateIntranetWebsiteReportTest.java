import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateIntranetWebsiteReportTest {
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
    @DisplayName("Create Intranet Website Report")
    public void testCreateIntranetWebsiteReport() {
        driver.findElement(By.id("login_form_login")).sendKeys("admin");
        driver.findElement(By.id("login_form_password")).sendKeys("e2eW3Bt3s71nGB3nchM4rK");
        driver.findElement(By.id("login_form_submit")).click();
        driver.findElement(By.id("topmenu-coreadminhome")).click();
        driver.findElement(By.linkText("Personal")).click();
        driver.findElement(By.linkText("Schedule Reports")).click();
        driver.findElement(By.cssSelector("#root > div.top_controls > div.top_bar_sites_selector.piwikTopControl > div > div > a")).click();
        driver.findElement(By.xpath("//a[@title='Intranet Web Test']")).click();
        driver.findElement(By.id("add-report")).click();
        driver.findElement(By.id("report_description")).sendKeys("Daily Report");
        WebElement checkbox = driver.findElement(By.id("emailMultiSites_getAll"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
        driver.findElement(By.cssSelector("input[value='Create Report']")).click();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        WebElement table = driver.findElement(By.cssSelector("table.entityTable"));
        List<WebElement> rows = table.findElements(By.cssSelector("tbody tr"));
        boolean found = false;
        for (WebElement row : rows) {
            String rowText = row.getText();
            if (rowText.contains("Daily Report")) {
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
