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

public class EditIntranetWebsiteTest {
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
    @DisplayName("Edit Intranet Website")
    public void testEditIntranetWebsite() {
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
                row.findElement(By.cssSelector("button[title='Edit']")).click();
                driver.findElement(By.id("urls")).clear();
                driver.findElement(By.id("urls")).sendKeys("https://intranetwebtest.matomo.it");
                driver.findElement(By.id("excluded_ips")).clear();
                driver.findElement(By.id("excluded_ips")).sendKeys("172.0.0.1");
                driver.findElement(By.id("excluded_parameters")).clear();
                driver.findElement(By.id("excluded_parameters")).sendKeys("/^sess");
                driver.findElement(By.id("excluded_user_agents")).clear();
                driver.findElement(By.id("excluded_user_agents")).sendKeys("/bot");
                driver.findElement(By.id("excluded_referrers")).clear();
                driver.findElement(By.id("excluded_referrers")).sendKeys("https://intranetwebtest.matomo.it/info");
                driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div[2]/div[2]/div/div[5]/div[3]/div/div[1]/div/div[3]/div[12]/div/div/div[1]/div/div/input")).click();
                driver.findElement(By.xpath("//span[contains(text(), 'Ecommerce enabled')]")).click();
                driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div[2]/div[2]/div/div[5]/div[3]/div/div[1]/div/div[6]/div[1]/div/div/input")).click();
                driver.findElement(By.xpath("//span[contains(text(), 'UTC+1')]")).click();
                driver.findElement(By.cssSelector("input[type='submit']")).click();
                found = true;
                break;
            }
        }
        assertTrue(found);
        WebElement message = driver.findElement(By.className("notification-body"));
        assertEquals("Website updated", message.getText());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
