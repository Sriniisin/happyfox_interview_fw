package utils;

import org.openqa.selenium.WebElement;

public interface Elements {

	/**
	 * This method will click the element and take snap
	 * 
	 * @param ele - The Webelement (button/link/element) to be clicked
	 * @see locateElement method in Browser Class
	 * @throws StaleElementReferenceException
	 */
	public void click(WebElement ele);

	/**
	 * This method will clear and type the value in the given text field
	 * 
	 * @param ele  - The Webelement (text field) in which the data to be entered
	 * @param data - The data to be sent to the webelement
	 * @see locateElement method in Browser Class
	 * @throws ElementNotInteractable,IllegalArgumentException(throws if keysToSend
	 *                                                                is null)
	 */
	public void clearAndType(WebElement ele, String data);

	/**
	 * This method will launch the Chrome browser and maximise the browser and set
	 * the wait for 30 seconds and load the url
	 * 
	 * @param browser - This will load the specified browser
	 * @param url     - This will load the specified url
	 * @throws MalformedURLException
	 */
	public void startApp(String url);
	
	/**
	 * This method will navigate to the desired url
	 * 
	 * @param url     - This will load the specified url
	 * @throws MalformedURLException
	 */
	public void navigate(String url);
	
	/**
	 * This method will quit the driver instance
	 * 
	 */
	public void quit();
	
	/**
	 * This method will close the browser instance
	 * 
	 */
	public void close();
	
	public void mouseHover(WebElement ele);
	
	public void perform();
	
	public void mouseClick(WebElement ele);
	
}
