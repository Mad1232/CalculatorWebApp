package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculatorWebTest {

    private WebDriver driver;

    @Before
    public void setUp() {
    	System.setProperty("webdriver.chrome.driver", "/Users/prakarsha/Downloads/chromedriver-mac-x64/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8000/calculator.html"); // <-- path to your HTML file
    }

    /** TR 1 - Basic GUI Functional Tests **/

    @Test
    public void testAddition() {
        click("1"); click("+"); click("2"); click("=");
        assertDisplay("3");
    }

    @Test
    public void testMemoryAddAndRecall() {
        click("4"); click("+"); click("1"); click("=");
        click("M+"); click("Del"); click("MR");
        assertDisplay("5");
    }

    @Test
    public void testMemorySubtract() {
        click("6"); click("="); click("M+"); click("Del");
        click("2"); click("M-"); click("MR");
        assertDisplay("4");
    }

    @Test
    public void testSquare() {
        click("5"); click("x²");
        assertDisplay("25");
    }

    @Test
    public void testSquareRoot() {
        click("9"); click("√");
        assertDisplay("3");
    }

    @Test
    public void testDeleteButton() {
        click("1"); click("2"); click("3"); click("Del");
        assertDisplay("12");
    }

    @Test
    public void testDivisionByZero() {
        click("8"); click("/"); click("0"); click("=");
        assertDisplay("Error");
    }

    /** TR 2 - Display shows only operands and results **/

    @Test
    public void testOperandsOnlyAdditionFlow() {
        click("1"); click("2");  // "12"
        assertDisplay("12");
        click("+"); click("3"); click("4");  // "34"
        assertDisplay("34");
        click("=");
        assertDisplay("46");
    }

    @Test
    public void testOperandsOnlySquareRoot() {
        click("9"); click("√");
        assertDisplay("3");
    }

    @Test
    public void testOperandsOnlySquare() {
        click("8"); click("x²");
        assertDisplay("64");
    }

    /** TR 3 - Visual Operation Button Change (Manual Visual Check Suggested) **/

    @Test
    public void testOperatorHighlightAddition() {
        click("+");
        // You can add optional logic to check button class with JS, but this is normally visual/manual
        assertButtonStillWorks("1", "+", "2", "3");
    }

    @Test
    public void testOperatorHighlightSubtraction() {
        click("-");
        assertButtonStillWorks("5", "-", "3", "2");
    }

    @Test
    public void testOperatorHighlightMultiplication() {
        click("*");
        assertButtonStillWorks("3", "*", "4", "12");
    }

    /** Utilities **/

    private void click(String text) {
        driver.findElement(By.xpath("//button[text()='" + text + "']")).click();
    }

    private void assertDisplay(String expected) {
        WebElement display = driver.findElement(By.id("display"));
        assertEquals(expected, display.getAttribute("value"));
    }

    private void assertButtonStillWorks(String a, String op, String b, String expectedResult) {
        click("C");
        click(a); click(op); click(b); click("=");
        assertDisplay(expectedResult);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
