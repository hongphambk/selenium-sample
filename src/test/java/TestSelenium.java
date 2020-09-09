import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.ws.WebEndpoint;

public class TestSelenium {
    ChromeDriver driver;
    String  loginUrl = "https://accounts.dev.shopbase.net/sign-in";

    private ChromeDriver getDriver(){
        return driver;
    }
    public void assertPageTitle(String pageTitleExpect){
        String pageTitle= getDriver().getTitle();
        Assert.assertEquals(pageTitle, pageTitleExpect);
    }
    @Before
    public void before() {
        System.out.println("start");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/window/chromedriver85.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void after() {
        getDriver().quit();
        System.out.println("Finish");
    }

    @Test
    public void login() throws Exception {
        driver.get(loginUrl);
        WebElement email =getDriver().findElement(By.id("email"));
        email.clear();
        email.sendKeys("hongpham@beeketing.net");
        WebElement  password =getDriver().findElement(By.id("password"));
        password.clear();
        password.sendKeys("bichhong96");
        WebElement login = getDriver().findElement(By.xpath("//button[@type='submit']"));
        login.click();
        Thread.sleep(9000);
        String  addProductUrl = "https://bichpham-store.myshopbase.net/admin/products/add";
        driver.get(addProductUrl);
        Thread.sleep(9000);
        WebElement nameProduct= getDriver().findElement(By.xpath("//input[ contains(@placeholder,'Short Sleeve T-Shirt')]"));
        nameProduct.sendKeys("Sen");
        WebElement tag= getDriver().findElement(By.xpath("//input[ contains(@placeholder,'Vintage, cotton, summer')]"));
        tag.sendKeys("hoa");
        WebElement price = getDriver().findElement(By.id("price"));
        price.sendKeys("20");
        WebElement comparePrice = getDriver().findElement(By.id("compare_price"));
        comparePrice.sendKeys("28");
        WebElement addVariant = getDriver().findElement(By.xpath("//a[ contains(text(),'Add variant')]"));
        addVariant.click();
        WebElement optionName = getDriver().findElement(By.id("option-name"));
        optionName.sendKeys("colors");
        WebElement optionValues= getDriver().findElement(By.xpath("//input[ contains(@placeholder,'Separate options with comma')]"));
        optionValues.sendKeys("pink");
        optionValues.sendKeys(",");
        optionValues.sendKeys("green");
        WebElement saveChanges = getDriver().findElement(By.xpath("//button[ contains(text(),'Save changes')]"));
        saveChanges.click();
        Thread.sleep(5000);

    }

}

