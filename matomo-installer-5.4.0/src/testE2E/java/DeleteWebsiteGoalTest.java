
import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertFalse;
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

public class DeleteWebsiteGoalTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:8082/");
    }

    @Test
    @DisplayName("Delete Website Goal")
    public void testDeleteWebsiteGoal() {
        driver.findElement(By.id("login_form_login")).sendKeys("admin");
        driver.findElement(By.id("login_form_password")).sendKeys("e2eW3Bt3s71nGB3nchM4rK");
        driver.findElement(By.id("login_form_submit")).click();
        driver.findElement(By.id("topmenu-coreadminhome")).click();
        driver.findElement(By.linkText("Measurables")).click();
        driver.findElement(By.linkText("Goals")).click();
        driver.findElement(By.cssSelector("#root > div.top_controls > div.top_bar_sites_selector.piwikTopControl > div > div > a")).click();
        driver.findElement(By.xpath("//a[@title='Web Test']")).click();
        WebElement table = driver.findElement(By.className("entityTable"));
        List<WebElement> rows = table.findElements(By.cssSelector("tbody tr"));
        boolean found = false;
        for (WebElement row : rows) {
            List<WebElement> websiteCards = row.findElements(By.cssSelector("td"));
            for (WebElement names : websiteCards) {
                String rowText = names.getText().trim();
                if (rowText.equals("Make more profit")) {
                    row.findElement(By.cssSelector("button[title='Delete']")).click();
                    WebElement checkbox = driver.findElement(By.className("btn-flat"));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
                    found = true;
                    break;
                }
                if(found==true){
                    break;
                }
            }
        }
        assertTrue(found);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        WebElement table_updated = driver.findElement(By.className("entityTable"));
        List<WebElement> rows_updated = table_updated.findElements(By.cssSelector("tbody tr"));
        boolean foundDeleted = false;
        for (WebElement row : rows_updated) {
            String rowText = row.getText();
            if (rowText.contains("Make more profit")) {
                foundDeleted = true;
                break;
            }
        }
        assertFalse(foundDeleted);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
