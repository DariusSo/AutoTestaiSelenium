import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.ReCaptcha;
import okhttp3.FormBody;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Vynoteka {
    WebDriver _globalDriver;

    @BeforeTest
    public void SetupWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        _globalDriver = new ChromeDriver();
        _globalDriver.get("https://vynoteka.lt/");
        _globalDriver.manage().window().maximize();
        _globalDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement confirmAge = _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div[3]/div/div[1]/button"));
        WebElement confirmCookies = _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/a[1]"));
        confirmAge.click();
        confirmCookies.click();
        newsletterPopUpHandle();

    }
    @Test
    public void registration() throws InterruptedException {
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[2]/div/div/div[4]/nav/div[1]/button/span[2]")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div[1]/div/button")).click();
        _globalDriver.findElement(By.id("firstname")).sendKeys("A");
        _globalDriver.findElement(By.id("lastname")).sendKeys("A");

        _globalDriver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[1]/div/div/span[1]/button")).click();
        _globalDriver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[1]/div/div/span[2]/div/div/button[18]")).click();

        _globalDriver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[2]/div/div/span[1]/button")).click();
        _globalDriver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[2]/div/div/span[2]/div/div/button[1]")).click();


        _globalDriver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[3]/div/div/span[1]/button")).click();
        _globalDriver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[2]/div/div/form/div[1]/div/div[3]/div/div/div[3]/div/div/span[2]/div/div/button[1]")).click();


        _globalDriver.findElement(By.id("email")).sendKeys("abcdefghi@gmail.com");
        _globalDriver.findElement(By.id("phone")).sendKeys("65555555");
        _globalDriver.findElement(By.id("password")).sendKeys("Slaptazodis123");
        _globalDriver.findElement(By.id("password_repeat")).sendKeys("Slaptazodis123");
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/div/form/div[1]/div/div[8]/div[1]/div/label/span")).click();
        _globalDriver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[2]/div/div/form/div[2]/div/div[2]/button")).click();
        Thread.sleep(35000);
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/div/form/div[3]/div[2]/button")).click();


        _globalDriver.findElement(By.xpath("//*[@id=\"app__header\"]/div[2]/div/div/div[4]/nav/div[1]/a")).click();
        String fullName = _globalDriver.findElement(By.xpath("//*[@id=\"app__main\"]/section/div/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div/div[1]/span")).getText();
        Assert.assertEquals("A A", fullName);
    }
    @Test
    public void login(){
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[2]/div/div/div[4]/nav/div[1]/button/span[2]")).click();
        _globalDriver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[2]/div/div[2]/div/form/div[1]/div/input")).sendKeys("abcd@gmail.com");
        _globalDriver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[2]/div/div[2]/div/form/div[2]/div/input")).sendKeys("Slaptazodis123");
        _globalDriver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[2]/div/div[2]/div/form/div[4]/button")).click();

        _globalDriver.findElement(By.xpath("//*[@id=\"app__header\"]/div[2]/div/div/div[4]/nav/div[1]/a")).click();
        String fullName = _globalDriver.findElement(By.xpath("//*[@id=\"app__main\"]/section/div/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div/div[1]/span")).getText();
        Assert.assertEquals("A A", fullName);
    }

    @Test
    public void cart(){
        _globalDriver.findElement(By.xpath("//*[@id=\"app__header\"]/div[3]/div/div/div[1]/div/div[1]/div/nav/div[1]/div/button")).click();
        _globalDriver.findElement(By.xpath("//*[@id=\"app__header\"]/div[3]/div/div/div[1]/div/div[1]/div/nav/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div/nav/div[1]/a")).click();
        _globalDriver.findElement(By.xpath("//*[@id=\"app__main\"]/section/div/div[2]/div/div[1]/div[4]/div[1]/div/div/div[3]/div[2]/div[2]/button")).click();
        String wineName = _globalDriver.findElement(By.xpath("//*[@id=\"app__main\"]/section/div/div[2]/div/div[1]/div[4]/div[1]/div/div/div[2]/a/span")).getText();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[2]/div/div/div[4]/nav/div[2]/button")).click();
        String cartWineName = _globalDriver.findElement(By.xpath("//*[@id=\"app__header\"]/div[2]/div/div/div[4]/nav/div[2]/div/div/div[2]/div/div/div[1]/a")).getText();
        Assert.assertEquals(wineName, cartWineName);
    }

    @Test
    public void search(){
        _globalDriver.findElement(By.xpath("//*[@id=\"app__header\"]/div[2]/div/div/div[3]/div/div/div/form/div[1]/div/input")).sendKeys("Masso Antico Primitivo 0,75 L");
        _globalDriver.findElement(By.xpath("//*[@id=\"app__header\"]/div[2]/div/div/div[3]/div/div/div/form/div[1]")).click();
         String foundName = _globalDriver.findElement(By.xpath("//*[@id=\"app__header\"]/div[2]/div/div/div[3]/div/div/div/form/div[2]/div/div[2]/div/div/div/div/div[1]/div/div/a/span")).getText();
        Assert.assertEquals(foundName, "Masso Antico Primitivo 0,75 L");
    }

    @Test
    public void messageWithCaptcha() throws InterruptedException, IOException {
        // Fill out the form
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/main/section[2]/div/div/div[4]/div/div/div/button")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/input")).sendKeys("A");
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/form/div[2]/div/input")).sendKeys("a@gmail.com");
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/form/div[3]/div[1]/input")).sendKeys("+37065555555");
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/form/div[4]/div/textarea")).sendKeys("a");
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/form/div[5]/div/label/span")).click();

//        // Switch to the reCAPTCHA iframe
//        WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='reCAPTCHA']")));
//
//        // Locate and interact with the checkbox
//        WebElement captchaCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-checkmark")));
//
//        // Perform actions before interacting with the checkbox
//        Actions actions = new Actions(_globalDriver);
//        actions.moveToElement(captchaCheckbox).pause(Duration.ofSeconds(2)).perform(); // Hover over checkbox
//        ((JavascriptExecutor) _globalDriver).executeScript("arguments[0].scrollIntoView(true);", captchaCheckbox);
//
//        try {
//            Thread.sleep(15000); // Simulate user hesitation
//            captchaCheckbox.click(); // Click the checkbox
//        } catch (ElementClickInterceptedException e) {
//            System.out.println("Click intercepted. Attempting JavaScript click...");
//            ((JavascriptExecutor) _globalDriver).executeScript("arguments[0].click();", captchaCheckbox);
//        }
//
//        _globalDriver.switchTo().defaultContent();
        // Get the site key from the reCAPTCHA iframe
        String siteKey = _globalDriver.findElement(By.className("g-recaptcha")).getAttribute("data-sitekey");
        System.out.println("Site Key: " + siteKey);

        // Solve reCAPTCHA using 2Captcha
        String solution = solveCaptchaWith2Captcha(siteKey, _globalDriver.getCurrentUrl());

        // Inject the solution into the reCAPTCHA response field

        JavascriptExecutor js1 = (JavascriptExecutor) _globalDriver;
        js1.executeScript("document.getElementById('g-recaptcha-response').style.display = 'block';");
        WebElement responseField = _globalDriver.findElement(By.id("g-recaptcha-response"));
        responseField.clear();
        responseField.sendKeys(solution);
        String injectedValue = responseField.getAttribute("value");
        WebElement captchaIframe = _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/form/div[6]/div/div/iframe"));

// Use JavascriptExecutor to make it visible
        JavascriptExecutor js = (JavascriptExecutor) _globalDriver;
        js.executeScript("arguments[0].style.display = 'block';", captchaIframe);

// Optional: Confirm the change
        String displayValue = captchaIframe.getAttribute("style");
        System.out.println("New display style: " + displayValue);
        System.out.println("Injected CAPTCHA Response: " + injectedValue);

        WebElement parentElement = _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/form/div[6]/div/div"));

// Make the parent container visible
        js.executeScript("arguments[0].style.display = 'block';", parentElement);
        js.executeScript("arguments[0].style.visibility = 'visible';", parentElement);
        js.executeScript("arguments[0].style.opacity = '1';", parentElement);

// Make the iframe interactable
        js.executeScript("arguments[0].style.display = 'block';", captchaIframe);
        js.executeScript("arguments[0].style.visibility = 'visible';", captchaIframe);
        js.executeScript("arguments[0].style.opacity = '1';", captchaIframe);
        js.executeScript("arguments[0].style.pointerEvents = 'auto';", captchaIframe);

        WebElement overlappingElement = (WebElement) js.executeScript(
                "return document.elementFromPoint(arguments[0], arguments[1]);",
                captchaIframe.getLocation().getX(),
                captchaIframe.getLocation().getY()
        );
        System.out.println("Overlapping Element: " + overlappingElement.getTagName());

        js.executeScript("arguments[0].style.pointerEvents = 'none';", overlappingElement);


// Check if the injected value matches the solution
        if (solution.equals(injectedValue)) {
            System.out.println("CAPTCHA response successfully injected.");
        } else {
            System.err.println("CAPTCHA response injection failed.");
        }
        // Create a cookie with the `_GRECAPTCHA` token
        Cookie grecaptchaCookie = new Cookie("_GRECAPTCHA", "09ANOXeZwNPROY6GJ9_y8KmXNJQpteGTx2jVA6kcswI8pZXclYQpsUyTMib0y58oLCwo5S3sHWHDpE86fMlrbLgLk");

// Add the cookie to the browser session
        _globalDriver.manage().addCookie(grecaptchaCookie);

// Refresh the page to ensure the cookie is applied
        //_globalDriver.navigate().refresh();
        System.out.println("Injected _GRECAPTCHA cookie successfully.");
        //js.executeScript("document.querySelector('form').submit();");
        // Submit the form
        WebElement recaptchaElement = _globalDriver.findElement(By.className("g-recaptcha"));

        // Get the data-callback value
        String callback = recaptchaElement.getAttribute("data-callback");

        // Execute the callback method using JavaScript
        String tokenMaybe = "03AFcWeA6aho7IGVC7knVvqer2pD7-XDMjP9myKWAV7g67PPkuQaOHqUAbT1QuCVDg_A7lGpUgt9su-9YNSIc_V6ZLg3hj1e-psvV-7kIpRIbeapyC5umYbEdJRLd9yJkXYvJ_MhdZMklilaAh6nVZcwdFAcWf19PjH5T-VUk2cyuozE06zjMoi9wEGK8MnRprXV0mIGW01QAH-Z3-b44eizOMj8XhXmJYaKveZEMFUTQiIkF6l5rUzevflxH_PRlSgj3YJ7kgl0HAqxydqXDXciZ-6NKkXjCxGd3xC0g_mnwcijqbFgfd9N6hdc1PmL9fzToU4VY63T4q7tKazl5_nW6mf1IzZWJGKMMbIFqbWsdxoi__aBzOIv2BG4ME-cG-TuxV6dO1YyQbf_gCQKEjUBEb-H5NCcEXiZsnas5W9u5N7bxePzbBLuzEvGs-h3p8nFQMLwLRbDIXPXobObfMmHYzfSt4-jgTYltT5PwmqkiOosHaCIVAuD2O_1XMmEw3ebd59FOepX3jKhdCNczeSSuuvrN0gEOfRdMxFAXL6KUu3tbemUr-J6p0mI91i0s1j1QbSupK9K5inReV1wC7JaNHat_UTlhn1JOyitL1mPgGr88TxYZOvNOmzWVH1fGvivYiguoiX-dagdd0O0lTbo01r6-Dn_O1piHnUtF9nYqokWVJsKrpH09B9nrvdjqw9F5vRsigspPl1oKTIW6_WUfSleOzbGFDPUfUdMbba2vg-frIjaAlgy-aAo1XovBt6nwbrghmJoQBBZF4IwXIhIueAmDkE95abtugSybO8K1x37vUsg8ETZavP5V8B0fyqbz0tpzKZfG2YnSPeLQAriispEEddNNAYLPjkXhR5pZDaVljcMevK7o7GeyoZJ88TJvid6FoZsnrtpvXGIIZpkWKgVlMuZf-B1v1ExBG8Rf8e4G5cDlXD3sFz5A_imH0Q7j2tznHxDsdya_Gz3OFnXUvp95Podel7IiVH_kwrF-oS4iZfCYzh3cvXzVxye757gfPCNiLKkvcdNPIWyQB5TFJGyr7Uz9ZEkhMCWaQtMqyXfMB2oXQUiB1JAhxzTVi43D_wMo3-B1zupJ8-FN6uv2j8zzEEfyAmJYQevLwcAlMdNejpGxHyofrULTDjN8LEGwedQ6jdcn3sz2ZoPSSJiBhLZ4Rebdnyly1j11EKMy8hNa6apd0WDt33h49cqQ4MVKlltBEm7BaihskPnl69VL9Hj2FQyRHsMjGEEiVpczXrYd9kEiHZICSVpgzAzDgN7x9B0IMBufHpaFT4n6ZTjxB-3P8Bo6wqbtKN6EpHUPDnf60vs2SBofAA9DCdHfDsKbZckhvbWDYkuGXqAUWg0pP42KeYl7OXR5cXhugK0arti1WTpGnXyTBeyQxCsuxPlRKdsBt78hAvJhEboIFnush3En2sz8MWFMAyPfdaO94JiZU9Xo4SvQ";
        js.executeScript(callback + "();");
        WebElement button = _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/form/div[7]/div/div/button"));
        js.executeScript("arguments[0].click();", button);
        System.out.println("Form submitted successfully!");
    }

    /**
     * Solve reCAPTCHA using 2Captcha API.
     */
    private String solveCaptchaWith2Captcha(String siteKey, String pageUrl) throws IOException, InterruptedException {
        final String API_KEY = "70d0e2553bfc81e0b60e88d2cca8bb3f"; // Replace with your 2Captcha API key
        OkHttpClient client = new OkHttpClient();

        // Step 1: Send the CAPTCHA solving request
        RequestBody formBody = new FormBody.Builder()
                .add("key", API_KEY)
                .add("method", "userrecaptcha")
                .add("googlekey", siteKey)
                .add("pageurl", pageUrl)
                .build();

        Request request = new Request.Builder()
                .url("http://2captcha.com/in.php")
                .post(formBody)
                .build();

        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();

        if (!responseBody.startsWith("OK|")) {
            throw new RuntimeException("Failed to send captcha to 2Captcha. Response: " + responseBody);
        }

        String captchaId = responseBody.split("\\|")[1];
        System.out.println("Captcha ID: " + captchaId);

        // Step 2: Poll for the solution
        String solution = null;
        for (int i = 0; i < 30; i++) { // Maximum 30 retries
            Thread.sleep(5000); // Wait 5 seconds before each retry
            Request solutionRequest = new Request.Builder()
                    .url("http://2captcha.com/res.php?key=" + API_KEY + "&action=get&id=" + captchaId)
                    .build();

            Response solutionResponse = client.newCall(solutionRequest).execute();
            String solutionResponseBody = solutionResponse.body().string();

            if (solutionResponseBody.startsWith("OK|")) {
                solution = solutionResponseBody.split("\\|")[1];
                break;
            } else if (!solutionResponseBody.equals("CAPCHA_NOT_READY")) {
                throw new RuntimeException("Error getting captcha solution: " + solutionResponseBody);
            }
        }

        if (solution == null) {
            throw new RuntimeException("Failed to solve captcha within time limit.");
        }

        System.out.println("Captcha Solved! Token: " + solution);
        return solution;
    }

    @Test
    public void messageWithCaptcha2() throws Exception {
        // Fill out the form
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/main/section[2]/div/div/div[4]/div/div/div/button")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/form/div[1]/div/input")).sendKeys("A");
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/form/div[2]/div/input")).sendKeys("a@gmail.com");
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/form/div[3]/div[1]/input")).sendKeys("+37065555555");
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/form/div[4]/div/textarea")).sendKeys("a");
        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/form/div[5]/div/label/span")).click();

        String solution = anotherCaptchaSolver();

        ((JavascriptExecutor) _globalDriver).executeScript(
                "if (typeof window[arguments[0]] === 'function') { window[arguments[0]](arguments[1]); }",
                "myRecaptchaMethod", solution);

        _globalDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/div[2]/button")).click();


    }

    public String anotherCaptchaSolver() throws Exception {

        TwoCaptcha solver = new TwoCaptcha("70d0e2553bfc81e0b60e88d2cca8bb3f");
        ReCaptcha captcha = new ReCaptcha();

        captcha.setSiteKey("6LeFAMYbAAAAAMz7KYQcMPm0s_Z8ucB3icbLxXS4");
        captcha.setUrl("https://vynoteka.lt");
        try {
            solver.solve(captcha);
            System.out.println("Captcha solved: " + captcha.getCode());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
        return captcha.getCode();
    }






    public void newsletterPopUpHandle(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                WebDriverWait wait = new WebDriverWait(_globalDriver, Duration.ofSeconds(100));
                WebElement newsletter = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(By.id("omnisend-form-63ff1f31b40d6530aba59a6d-action-627932485028ebd8c6660c51"))
                );
                _globalDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[2]/div[2]/div[2]/button/div")).click();
            }
        });
        thread.start();
    }

}
