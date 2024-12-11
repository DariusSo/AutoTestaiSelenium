import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Way2Automation {
    WebDriver _globalDriver;

    @Test
    public void draggableDefault(){
        WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[1]/div/iframe")));
        _globalDriver.switchTo().frame(element);

        init("https://www.way2automation.com/way2auto_jquery/draggable.php#load_box");
        Actions action = new Actions(_globalDriver);
        WebElement draggable = _globalDriver.findElement(By.id("draggable"));
        action.dragAndDropBy(draggable, 200, 100).perform();

    }
    public void init(String link){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        _globalDriver = new ChromeDriver();
        _globalDriver.get(link);
        _globalDriver.manage().window().maximize();
        _globalDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void draggableEvents(){
        init("https://www.way2automation.com/way2auto_jquery/draggable.php#load_box");
        _globalDriver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[1]/div[1]/div[1]/ul/li[4]")).click();

        WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"example-1-tab-4\"]/div/iframe")));
        _globalDriver.switchTo().frame(element);

        Actions action = new Actions(_globalDriver);
        WebElement draggable = _globalDriver.findElement(By.id("draggable"));

        action.clickAndHold(draggable).perform();
        for(int i = 1; i < 20; i++){
            action.moveToLocation(700 + i, 500 + i).perform();
        }
        action.release().perform();
        int locationX = draggable.getLocation().getX();
        int locationY = draggable.getLocation().getY();
        Assert.assertEquals(locationX, 98);
        Assert.assertEquals(locationY, 59);
    }

    @Test
    public void droppableDefault(){
        init("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        WebElement draggable = _globalDriver.findElement(By.id("draggable"));
        WebElement droppable = _globalDriver.findElement(By.id("droppable"));
        Actions action = new Actions(_globalDriver);
        //action.dragAndDrop()
    }
}
