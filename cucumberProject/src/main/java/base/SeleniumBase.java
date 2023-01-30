package base;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Elements;

public class SeleniumBase extends DriverInstance implements Elements {
	protected Actions act;

	public void click(WebElement ele) {
		try {

			ele.click();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void clearAndType(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void startApp(String url) {
		try {
			String browser = "chrome";
			boolean headless = true;

			if (browser.equalsIgnoreCase("chrome")) {
				// System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				WebDriverManager.chromedriver().setup();
				setDriver("chrome", false);
			} else if (browser.equalsIgnoreCase("firefox")) {
				setDriver("firefox", headless);
			} else if (browser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				setDriver("ie", false);
			}
			setWait();
			getDriver().manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		} catch (WebDriverException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void navigate(String url) {
		try {
			getDriver().navigate().to(url);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void quit() {
		getDriver().quit();
	}

	@Override
	public void close() {
		getDriver().close();
	}

	@Override
	public void mouseHover(WebElement ele) {
		try {
			act = new Actions(getDriver());
			act.moveToElement(ele);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void mouseHoverAndClick(WebElement ele) {
		try {
			act = new Actions(getDriver());
			act.moveToElement(getWait().until(ExpectedConditions.elementToBeClickable(ele))).pause(5000).click()
					.perform();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void perform() {
		try {
			act = new Actions(getDriver());
			act.build().perform();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void mouseClick(WebElement ele) {
		try {
			act = new Actions(getDriver());
			act.click();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public String getTitle() {
		String title = null;
		try {
			title = getDriver().getTitle();
		} catch (Exception e) {
			System.out.println(e);
		}
		return title;
	}

	public void waitForApperance(WebElement element) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void waitForElement(WebElement element) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Boolean verifyDisplayed(WebElement ele) {
		try {
			if (ele.isDisplayed()) {
				return true;
			} else {
				return false;
			}
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public Boolean verifyIsPresent(String xpath) {
		Boolean status = false;
		try {
			status = getDriver().findElements(By.xpath(xpath)).size() > 0;
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public String getInnerText(WebElement ele) {
		String text = null;
		try {
			text = ele.getText();

		} catch (Exception e) {
			System.out.println(e);
		}
		return text;
	}
}
