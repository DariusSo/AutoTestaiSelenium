import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
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

        WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"example-1-tab-1\"]/div/iframe")));
        _globalDriver.switchTo().frame(element);

        WebElement draggable = _globalDriver.findElement(By.id("draggable"));
        WebElement droppable = _globalDriver.findElement(By.id("droppable"));
        Actions action = new Actions(_globalDriver);
        action.dragAndDrop(draggable, droppable).perform();
        droppable.getAttribute("class");
        String changedClass = "ui-widget-header ui-droppable ui-state-highlight";
        Assert.assertEquals(droppable.getAttribute("class"), changedClass);
    }
    @Test
    public void droppableAccept(){
        init("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");

        _globalDriver.findElement(By.xpath("//html/body/section/div[1]/div[1]/div[1]/ul/li[2]")).click();

        WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"example-1-tab-2\"]/div/iframe")));
        _globalDriver.switchTo().frame(element);

        WebElement draggable = _globalDriver.findElement(By.id("draggable"));
        WebElement draggableBad = _globalDriver.findElement(By.id("draggable-nonvalid"));

        WebElement droppable = _globalDriver.findElement(By.id("droppable"));
        Actions action = new Actions(_globalDriver);
        action.dragAndDrop(draggableBad, droppable).perform();
        Assert.assertEquals(droppable.getAttribute("class"), "ui-widget-header ui-droppable");
        action.dragAndDrop(draggable, droppable).perform();
        String changedClass = "ui-widget-header ui-droppable ui-state-highlight";
        Assert.assertEquals(droppable.getAttribute("class"), changedClass);
    }

    @Test
    public void resizableDefault(){
        init("https://www.way2automation.com/way2auto_jquery/resizable.php#load_box");

        WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"example-1-tab-1\"]/div/iframe")));
        _globalDriver.switchTo().frame(element);

        WebElement resizeHandle = _globalDriver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));

        System.out.println(resizeHandle.getSize());

        Actions action = new Actions(_globalDriver);
        action.dragAndDropBy(resizeHandle, 200, 200).perform();

        Assert.assertEquals("width: 350px; height: 350px;", _globalDriver.findElement(By.id("resizable")).getAttribute("style"));
    }

    @Test
    public void resizableConstraintArea(){
        init("https://www.way2automation.com/way2auto_jquery/resizable.php#load_box");

        _globalDriver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[1]/div[1]/div[1]/ul/li[3]")).click();

        WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"example-1-tab-3\"]/div/iframe")));
        _globalDriver.switchTo().frame(element);

        WebElement resizeHandle = _globalDriver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));

        Actions action = new Actions(_globalDriver);
        boolean equals = false;
        try{
            action.dragAndDropBy(resizeHandle, 400, 400).perform();
        }catch (MoveTargetOutOfBoundsException e){
            equals = true;
        }

        Assert.assertTrue(equals);
    }

    @Test
    public void accordionDefault(){
        init("https://www.way2automation.com/way2auto_jquery/accordion.php#load_box");

        //_globalDriver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[1]/div[1]/div[1]/ul/li[3]")).click();

        WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"example-1-tab-1\"]/div/iframe")));
        _globalDriver.switchTo().frame(element);

        WebElement section1 = _globalDriver.findElement(By.id("ui-id-1"));
        WebElement section2 = _globalDriver.findElement(By.id("ui-id-3"));

        section2.click();
        boolean sec1 = Boolean.parseBoolean(section1.getAttribute("aria-expanded"));
        Assert.assertFalse(sec1);
        boolean sec2 = Boolean.parseBoolean(section2.getAttribute("aria-expanded"));
        Assert.assertTrue(sec2);
    }
    @Test
    public void accordionIcons(){
        init("https://www.way2automation.com/way2auto_jquery/accordion.php#load_box");

        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[2]")).click();

        WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"example-1-tab-2\"]/div/iframe")));
        _globalDriver.switchTo().frame(element);

        WebElement section1 = _globalDriver.findElement(By.id("ui-id-1"));
        WebElement section2 = _globalDriver.findElement(By.id("ui-id-3"));

        section2.click();
        Assert.assertEquals("ui-accordion-header-icon ui-icon ui-icon-circle-arrow-s", _globalDriver.findElement(By.xpath("//*[@id=\"ui-id-3\"]/span")).getAttribute("class"));
        Assert.assertEquals("ui-accordion-header-icon ui-icon ui-icon-circle-arrow-e", _globalDriver.findElement(By.xpath("//*[@id=\"ui-id-1\"]/span")).getAttribute("class"));

    }

    @Test
    public void autocomplete(){
        init("https://www.way2automation.com/way2auto_jquery/autocomplete.php#load_box");

        //_globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[2]")).click();

        WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"example-1-tab-1\"]/div/iframe")));
        _globalDriver.switchTo().frame(element);

        WebElement input = _globalDriver.findElement(By.id("tags"));
        input.sendKeys("BAS");
        Assert.assertEquals("BASIC", _globalDriver.findElement(By.xpath("/html/body/ul/li")).getText());

    }

    @Test
    public void datepicker(){
        init("https://www.way2automation.com/way2auto_jquery/datepicker.php#load_box");

        //_globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[2]")).click();

        WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"example-1-tab-1\"]/div/iframe")));
        _globalDriver.switchTo().frame(element);

        WebElement input = _globalDriver.findElement(By.id("datepicker"));
        input.click();
        _globalDriver.findElement(By.xpath("/html/body/div/table/tbody/tr[5]/td[3]/a")).click();
        input.getAttribute("value");
        Assert.assertEquals(input.getAttribute("value"), "12/31/2024");
    }

    @Test
    public void tooltip(){
        init("https://www.way2automation.com/way2auto_jquery/tooltip.php#load_box");

        //_globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[2]")).click();

        WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"example-1-tab-1\"]/div/iframe")));
        _globalDriver.switchTo().frame(element);

        String a = _globalDriver.findElement(By.id("age")).getAttribute("title");
        String b = "We ask for your age only for statistical purposes.";

        Assert.assertEquals(a, b);

    }

    @Test
    public void tabs(){
        init("https://www.way2automation.com/way2auto_jquery/tabs.php#load_box");

        //_globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[2]")).click();

        WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"example-1-tab-1\"]/div/iframe")));
        _globalDriver.switchTo().frame(element);

        _globalDriver.findElement(By.xpath("/html/body/div/ul/li[1]/a")).click();

        String b = "We ask for your age only for statistical purposes.";
        JavascriptExecutor executor = (JavascriptExecutor) _globalDriver;
        Long value = (Long) executor.executeScript("return window.pageYOffset;");

        Assert.assertEquals(value, 14);

    }

    @Test
    public void registration(){
        init("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");

        //_globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[2]")).click();

        _globalDriver.findElement(By.xpath("//*[@id=\"register_form\"]/fieldset[1]/p[1]/input")).sendKeys("Ddddd");
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div/div/form/fieldset[1]/p[2]/input")).sendKeys("sssss");
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div/div/form/fieldset[2]/div/label[1]/input")).click();
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div/div/form/fieldset[3]/div/label[1]/input")).click();

        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div/div/form/fieldset[5]/div[1]/select")).click();
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div/div/form/fieldset[5]/div[1]/select/option[2]")).click();

        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div/div/form/fieldset[5]/div[2]/select")).click();
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div/div/form/fieldset[5]/div[2]/select/option[2]")).click();

        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div/div/form/fieldset[5]/div[3]/select")).click();
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div/div/form/fieldset[5]/div[3]/select/option[2]")).click();


        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div/div/form/fieldset[6]/input")).sendKeys("+37063076806");
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div/div/form/fieldset[7]/input")).sendKeys("drs");
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div/div/form/fieldset[8]/input")).sendKeys("a@gmail.com");

        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div/div/form/fieldset[9]/input")).sendKeys("C:\\Users\\Darius\\monitor.jpg");

        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div/div/form/fieldset[10]/textarea")).sendKeys("sssss");
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div/div/form/fieldset[11]/input")).sendKeys("sssss1");
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div/div/form/fieldset[12]/input")).sendKeys("sssss1");

        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div/div/form/fieldset[13]/input")).click();
    }

    @Test
    public void alertSimple(){
        init("https://www.way2automation.com/way2auto_jquery/alert.php#load_box");

        //_globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[2]")).click();

        WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"example-1-tab-1\"]/div/iframe")));
        _globalDriver.switchTo().frame(element);

        _globalDriver.findElement(By.xpath("/html/body/button")).click();

        boolean flag = false;
        try{
            _globalDriver.switchTo().alert();
            flag = true;
        }catch (NoAlertPresentException e){

        }

        Assert.assertTrue(flag);
    }

    @Test
    public void alertInput(){
        init("https://www.way2automation.com/way2auto_jquery/alert.php#load_box");

        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[2]")).click();

        WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"example-1-tab-2\"]/div/iframe")));
        _globalDriver.switchTo().frame(element);

        _globalDriver.findElement(By.xpath("/html/body/button")).click();

        Alert alert = _globalDriver.switchTo().alert();
        alert.sendKeys("Harry");
        alert.accept();

        String s = _globalDriver.findElement(By.xpath("/html/body/p")).getText();

        Assert.assertEquals(s, "Hello Harry! How are you today?");
    }
}
