package com.wiley.webtest;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Instant;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class BaseTest {
    WebDriver driver ;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.wiley.com/WileyCDA/");
        System.out.println(driver.getTitle());
    }

    public void checkLinksDisplayedInTopNavigationMenu(){
        //driver.findElement(By.linkText("Home"));
        driver.findElement(By.cssSelector("div#links-site li:nth-child(1)")).isDisplayed();
        //driver.findElement(By.linkText("Subjects"))
        driver.findElement(By.cssSelector("div#links-site li:nth-child(2)")).isDisplayed();
        //driver.findElement(By.linkText("About Wiley"));
        driver.findElement(By.cssSelector("div#links-site li:nth-child(3)")).isDisplayed();
        //driver.findElement(By.linkText("Contact Us"));
        driver.findElement(By.cssSelector("div#links-site li:nth-child(4)")).isDisplayed();
        //driver.findElement(By.linkText("Help"));
        driver.findElement(By.cssSelector("div#links-site li:nth-child(5)")).isDisplayed();
    }

    public void checkResourcesSubHeaderIsDisplayed(){
        driver.findElement(By.cssSelector("h2.homepage-heading--resources")).isDisplayed();
    }

    public void check9ItemsUnderResourcesSubHeader(){
        Assert.assertTrue(driver.findElement(By.id("homepage-links")).findElement(By.tagName("ul"))
                .findElements(By.tagName("li")).size() == 9); ;
    }

    public void checkTitlesOfItemsUnderResourcesSubHeader(){
        WebElement students = driver.findElement(By.cssSelector(".resource-students"));
        assertEquals("Students", students.getText());
        WebElement authors = driver.findElement(By.cssSelector(".resource-authors"));
        assertEquals("Authors", authors.getText());
        WebElement instructors = driver.findElement(By.cssSelector(".resource-instructors"));
        assertEquals("Instructors", instructors.getText());
        WebElement librarians = driver.findElement(By.cssSelector(".resource-librarians"));
        assertEquals("Librarians", librarians.getText());
        WebElement societies = driver.findElement(By.cssSelector(".resource-societies"));
        assertEquals("Societies", societies.getText());
        WebElement conferences = driver.findElement(By.cssSelector(".resource-conferences"));
        assertEquals("Conferences", conferences.getText());
        WebElement booksellers = driver.findElement(By.cssSelector(".resource-booksellers"));
        assertEquals("Booksellers", booksellers.getText());
        WebElement corporations = driver.findElement(By.cssSelector(".resource-corporate"));
        assertEquals("Corporations", corporations.getText());
        WebElement institutions = driver.findElement(By.cssSelector(".resource-institutions"));
        assertEquals("Institutions", institutions.getText());
    }

    public void openStudentsPage(){
        driver.findElement(By.cssSelector(".resource-students")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("http://eu.wiley.com/WileyCDA/Section/id-404702.html"));
        WebElement students = driver.findElement(By.cssSelector("div#page-title"));
        assertEquals("Students", students.getText());
    }

    public void checkResourcesForOnLeftMenu(){
        WebElement resourcesForMenu = driver.findElement(By.cssSelector(".activeParent > a:nth-child(1)"));
        resourcesForMenu.isDisplayed();
        assertEquals("Resources For", resourcesForMenu.getText());
    }

    public void check8ItemsDisplayedOnResourcesFor(){
        //”Government Employees” item is absent on left menu
       List<WebElement> itemsOfResourcerFor = driver.findElements(By.xpath("/html/body/div[2]/div[3]/div[3]/div/ul/li/ul/li"));
       assertTrue(itemsOfResourcerFor.size() == 7, "There are 7 items on the left menu");
    }

    public void checkItemsOnResourcesForLeftMenuWhenStudentsLinkActive(){
        WebElement authors = driver.findElement(By.cssSelector(".autonavLevel1 > li:nth-child(1)"));
        assertEquals("Authors", authors.getText());
        WebElement librarians = driver.findElement(By.cssSelector(".autonavLevel1 > li:nth-child(2)"));
        assertEquals("Librarians", librarians.getText());
        WebElement booksellers = driver.findElement(By.cssSelector("li.autonavItem:nth-child(3)"));
        assertEquals("Booksellers", booksellers.getText());
        WebElement instructors = driver.findElement(By.cssSelector("li.autonavItem:nth-child(4)"));
        assertEquals("Instructors", instructors.getText());
        WebElement students = driver.findElement(By.cssSelector("li.active>span"));
        assertEquals("Students", students.getText());
        WebElement societies = driver.findElement(By.cssSelector("li.autonavItem:nth-child(6)"));
        assertEquals("Societies", societies.getText());
        WebElement corporatePartners = driver.findElement(By.cssSelector("li.autonavItem:nth-child(7)"));
        assertEquals("Corporate Partners", corporatePartners.getText());
    }

    public void itemStudentsHasDifferentStyle(){
        WebElement students = driver.findElement(By.cssSelector("li.active>span"));
        System.out.println(students.getAttribute("innerHTML"));
        System.out.println("getCssValue(\"color\"): " +
                students.getCssValue("color"));
    }

    public void itemStudentsIsNotClickable(){

//        WebElement students = driver.findElement(By.cssSelector("li.active>span"));
//        (new WebDriverWait(driver, 10))
//                .until(ExpectedConditions.elementToBeClickable(students));


//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver students) {
//                try {
//                    return students.findElement(By.cssSelector("li.active>span")).isEnabled();
//                }
//                catch (NoSuchElementException e) {
//                    return false;
//                }
//            }
//        });

//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.active>span"))).click();
   }


//    @AfterMethod
//    public void tearDown(){
//        if (driver !=null) {
//            driver.quit();
//        }
//    }
}
