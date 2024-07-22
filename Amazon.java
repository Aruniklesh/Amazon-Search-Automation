package Marathon;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		// maximize the window
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		// implicitlyWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags for boys");
		Thread.sleep(2000);
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(2000);
		// Print the total number of results (like 50000)
		String s = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"))
				.getText();
		Thread.sleep(2000);
		System.out.println("Results: " + s);
		Thread.sleep(2000);

		// Select the first 2 brands in the left menu
		List<WebElement> brand = driver.findElements(
				By.cssSelector("#brandsRefinements span[data-csa-c-type=\"element\"] .a-spacing-micro input + i"));
		brand.get(0).click();
		Thread.sleep(2000);
		driver.findElements(
				By.cssSelector("#brandsRefinements span[data-csa-c-type=\"element\"] .a-spacing-micro input + i"))
				.get(1).click();

		// Choose New Arrivals (Sort)
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".a-button-text")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a#s-result-sort-select_4")).click();
		Thread.sleep(2000);

		// Print the first resulting bag info
		System.out
				.println("Bag name: " + driver.findElement(By.cssSelector(".a-size-base-plus.a-color-base")).getText());
		System.out.println("Price is "
				+ driver.findElements(By.cssSelector(".a-price .a-offscreen")).get(0).getAttribute("innerHTML"));

		// Get the page title and close the browser(driver.close())
		System.out.println("Title of the page is: " + driver.getTitle());
		Thread.sleep(1000);
		driver.close();
	}

}
