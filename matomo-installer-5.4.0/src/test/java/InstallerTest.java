import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InstallerTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @Test
    public void install() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=en-US");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://localhost:8082");
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#installation > div.container > div.row > div.col.s9.content > p.next-step > a"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#installation > div.container > div.row > div.col.s9.content > p > a"))).click();
        driver.findElement(By.id("submit-0")).click();
        List<WebElement> warnings = driver.findElements(By.className("alert-warning"));
        if (!warnings.isEmpty() && warnings.get(0).isDisplayed()) {
            driver.findElement(By.id("eraseAllTables")).click();
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#installation > div.container > div.row > div.col.s9.content > p > a"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-0"))).sendKeys("admin");
        driver.findElement(By.id("password-0")).sendKeys("e2eW3Bt3s71nGB3nchM4rK");
        driver.findElement(By.id("password_bis-0")).sendKeys("e2eW3Bt3s71nGB3nchM4rK");
        driver.findElement(By.id("email-0")).sendKeys("admin@matomo.example");
        driver.findElement(By.id("submit-0")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("siteName-0"))).sendKeys("WebSite Test");
        driver.findElement(By.id("url-0")).sendKeys("website.test");
        driver.findElement(By.className("select-wrapper")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'UTC+2')]"))).click();
        driver.findElement(By.id("submit-0")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#installation > div.container > div.row > div.col.s9.content > p.next-step > a"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit-0"))).click();
        List<WebElement> upgradeButtons = driver.findElements(By.xpath("//input[@value='Upgrade Matomo']"));
        if (!upgradeButtons.isEmpty() && upgradeButtons.get(0).isDisplayed()) {
            driver.findElement(By.xpath("//input[value='Upgrade Matomo']")).click();
            driver.findElement(By.linkText("Continue to Matomo")).click();
        }
        System.out.println("Setup complete. Now you can use Matomo.");
    }
}
