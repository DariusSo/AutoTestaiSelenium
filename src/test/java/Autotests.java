import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Autotests {
    WebDriver _globalDriver;

    @BeforeTest
    public void SetupWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        _globalDriver = new ChromeDriver();
        _globalDriver.get("https://elenta.lt/");
        _globalDriver.manage().window().maximize();
        _globalDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement sutikimas = _globalDriver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[2]/div[2]/button[1]"));
        sutikimas.click();
    }
    @AfterTest
    public void ResetToTitle() throws InterruptedException {
        _globalDriver.get("https://elenta.lt/");
    }

    @Test
    public void testTC0101() throws InterruptedException {
        Thread.sleep(3000);
        _globalDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/table/tbody/tr/td[1]/input")).sendKeys("intel");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/table/tbody/tr/td[2]/input")).click();
        int count = Integer.parseInt(_globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div/span")).getText());
        Assert.assertNotEquals(count,0);
    }

    @Test
    public void testCategoryItemClick() throws InterruptedException {
        Thread.sleep(3000);
        WebElement automobiliuKategorijas = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[3]/a[2]"));
        automobiliuKategorijas.click();
        WebElement kiekioLaikiklis = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/div[1]/div[1]/span"));
        int count = Integer.parseInt(kiekioLaikiklis.getText());
        Assert.assertNotEquals(count, 0);
    }

    @Test
    public void test1(){
        _globalDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        _globalDriver.findElement((By.id("search-page-box"))).sendKeys("Peugeot");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/table/tbody/tr/td[2]/input")).click();
        WebElement foundNr = _globalDriver.findElement(By.xpath("//*[@id=\"summary-count\"]/span"));
        int count = Integer.parseInt(foundNr.getText());
        Assert.assertNotEquals(count, 0);
    }

    @Test
    public void testGreen() throws InterruptedException {
        _globalDriver.get("https://elenta.lt/");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[4]/a[2]")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/ul/li[1]/div[1]/h3/a")).click();
        Thread.sleep(300);
        _globalDriver.findElement(By.id("ad-bookmark-button-symbol-1250657")).click();

        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div/span[3]/a/span")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[5]/ul/li[2]/div[1]/h3/a")).click();
        Thread.sleep(300);
        _globalDriver.findElement(By.id("ad-bookmark-button-symbol-1236124")).click();

        _globalDriver.findElement(By.id("bookmarks-nav-button")).click();
        _globalDriver.findElement(By.id("ad-bookmark-button-symbol-1250657"));
        _globalDriver.findElement(By.id("ad-bookmark-button-symbol-1236124"));
    }

    @Test
    public void testYellow() throws InterruptedException {
        _globalDriver.get("https://elenta.lt/");
        _globalDriver.findElement(By.id("submit-new-ad-nav-button")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/ul/li[1]/a")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/ul/li[2]/a")).click();
        _globalDriver.findElement(By.id("title")).sendKeys("Superku dauztas auto");
        _globalDriver.findElement(By.id("text")).sendKeys("Sumokesiu kazkiek uz jusu lauza");
        _globalDriver.findElement(By.id("price")).sendKeys("1");
        _globalDriver.findElement(By.id("location-search-box")).sendKeys("Lietuva");
        _globalDriver.findElement(By.id("phone")).sendKeys("+37064525647");
        _globalDriver.findElement(By.id("email")).sendKeys("dddbbb@gmmail.com");
        _globalDriver.findElement(By.id("submit-button")).click();
        _globalDriver.findElement(By.id("forward-button")).click();
        _globalDriver.findElement(By.id("forward-button")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[3]/form/table/tbody/tr[12]/td[2]/a")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/a[2]/img")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/table/tbody/tr/td[1]/input")).sendKeys("Superku dauztas auto");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/table/tbody/tr/td[2]/input")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/ul/li[1]/div[1]/h3/a")).click();
        String adTitle = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/h1/a")).getText();
        Assert.assertEquals("Superku dauztas auto", adTitle);
    }

    @Test
    public void testBlue() throws InterruptedException {
        _globalDriver.get("https://elenta.lt/");
        _globalDriver.findElement(By.id("submit-new-ad-nav-button")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/ul/li[6]/a")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/ul/li[1]/a")).click();
        _globalDriver.findElement(By.id("title")).sendKeys("Smarkiai dauzti monitoriai");
        _globalDriver.findElement(By.id("text")).sendKeys("Siaip is tikro nezinau ar parduosiu");
        _globalDriver.findElement(By.id("price")).sendKeys("999");
        _globalDriver.findElement(By.id("location-search-box")).sendKeys("Lietuva");
        _globalDriver.findElement(By.id("phone")).sendKeys("+37064525647");
        _globalDriver.findElement(By.id("email")).sendKeys("dddbbb@gmmail.com");
        _globalDriver.findElement(By.id("submit-button")).click();

        _globalDriver.findElement(By.id("inputfile")).sendKeys("C:\\Users\\Darius\\monitor.jpg");
        Thread.sleep(3000);
        _globalDriver.findElement(By.id("remove-photo-1")).click();
        _globalDriver.findElement(By.id("forward-button")).click();
        _globalDriver.findElement(By.id("forward-button")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[3]/form/table/tbody/tr[12]/td[2]/a")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/a[2]/img")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/table/tbody/tr/td[1]/input")).sendKeys("Smarkiai dauzti monitoriai");
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/form/table/tbody/tr/td[2]/input")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/ul/li[1]/div[1]/h3/a")).click();
        String adTitle = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/h1/a")).getText();
        Assert.assertEquals("Smarkiai dauzti monitoriai", adTitle);
    }

    @Test
    public void testFun() throws InterruptedException {
        _globalDriver.get("https://google.com/");

        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/span/div/div/div/div[3]/div[1]/button[2]/div")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div[1]/div[2]/textarea")).sendKeys("How to use selenium?");
        Thread.sleep(1000);
        _globalDriver.findElement(By.name("btnI")).click();

    }





}