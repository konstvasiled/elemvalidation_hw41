package core;

import org.openqa.selenium.*;
import org.openqa.selenium.safari.*;
import org.openqa.selenium.support.ui.*;
import java.util.logging.*;

public class Safari {
    static WebDriver driver;
    By by;

    public static boolean presence(final By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        if (!wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by)).isEmpty()) return true;
        else return false;}

    public static void main(String[] args) {
        Logger.getLogger("").setLevel(Level.OFF);

        String url = "https://www.amazon.com/Apple-42mm-Smart-Watch-Aluminum/dp/B00WUKULAC/ref=sr_1_1?ie=UTF8&qid=1507347974&sr=8-1&keywords=Apple+watch+series+2";
        if (!System.getProperty("os.name").toUpperCase().contains("MAC")) {System.err.println("Safari available exclusively on Mac"); throw new IllegalArgumentException("OS is not supported");}

        driver = new SafariDriver();
        driver.manage().window().maximize();
        final long start = (System.currentTimeMillis());
        driver.get(url);

        By productTitle = By.xpath("//*[@id='productTitle']"),
                tagPrice = By.xpath("//*[@id='priceblock_ourprice']"),
                itemFeatures = By.xpath("//*[@id='feature-bullets']"),
                offerField = By.xpath("//*[@id='sims-fbt']"),
                itemDescription = By.xpath("//div[@class='apm-centerthirdcol apm-wrap']"),
                cartItem = By.xpath("//input[@id='add-to-cart-button']"),
                shipTo = By.xpath("//*[@id='unifiedLocation_feature_div']"),
                reviewFiled = By.xpath("//*[@id='dp-customer-review-header']//parent::div");
        System.out.println("Browser is: Firefox" + "\nPage URL: " + driver.getCurrentUrl());
        System.out.println("\n01. Element [Product Title]: " + (presence(productTitle) ? "Exists":"Not exist"));
        System.out.println("02. Element [Price Tag]: " + (presence(tagPrice) ? "Exists":"Not exist"));
        System.out.println("03. Element [Item Features Files]: " + (presence(itemFeatures) ? "Exists":"Not exist"));
        System.out.println("04. Element [Offer Page]: " + (presence(offerField) ? "Exists":"Not exist"));
        System.out.println("05. Element [Item Description]: " + (presence(itemDescription) ? "Exists":"Not exist"));
        System.out.println("06. Element [Cart Button]: " + (presence(cartItem) ? "Exists":"Not exist"));
        System.out.println("07. Element [Shipment Information Field]: " + (presence(shipTo) ? "Exists":"Not exist"));
        System.out.println("08. Element [Review Field]: " + (presence(reviewFiled) ? "Exists":"Not exist"));
        driver.quit();
        final long runtime = (((System.currentTimeMillis()) - start) / 1000);
        if (runtime != 1) System.out.println("\n\tTotal Driver Runtime: " + runtime + " seconds");
        else System.out.println("\n\tTotal Driver Runtime: " + runtime + " second");
    }
}
