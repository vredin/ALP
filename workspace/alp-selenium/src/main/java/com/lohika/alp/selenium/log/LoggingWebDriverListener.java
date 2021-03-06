//Copyright 2011-2012 Lohika .  This file is part of ALP.
//
//    ALP is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    ALP is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with ALP.  If not, see <http://www.gnu.org/licenses/>.
package com.lohika.alp.selenium.log;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.lohika.alp.selenium.jscatcher.JsErrorCatcherConfiguration;
import com.lohika.alp.selenium.jscatcher.FirefoxJsErrorCathcer;
import com.lohika.alp.selenium.jscatcher.JSErrorCatcher;
import com.lohika.alp.selenium.jscatcher.JsErrorCatcherException;

/**
 * The listener interface for receiving loggingWebDriver events.
 * The class that is interested in processing a loggingWebDriver
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addLoggingWebDriverListener<code> method. When
 * the loggingWebDriver event occurs, that object's appropriate
 * method is invoked.
 *
 * @see LoggingWebDriverEvent
 */
public class LoggingWebDriverListener implements WebDriverEventListener {

	/** The log4j logger. */
	private final Logger logger = Logger.getLogger(getClass());
	
	/** The elements factory. */
	private final LogElementsSeleniumFactory elementsFactory;

	/**
	 * Instantiates a new logging web driver listener.
	 *
	 * @param logElements the log elements
	 */
	public LoggingWebDriverListener(LogElementsSeleniumFactory logElements) {
		this.elementsFactory = logElements;
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#afterChangeValueOf(org.openqa.selenium.WebElement, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#afterClickOn(org.openqa.selenium.WebElement, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void afterClickOn(WebElement arg0, WebDriver driver) {
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#afterFindBy(org.openqa.selenium.By, org.openqa.selenium.WebElement, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#afterNavigateBack(org.openqa.selenium.WebDriver)
	 */
	@Override
	public void afterNavigateBack(WebDriver arg0) {
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#afterNavigateForward(org.openqa.selenium.WebDriver)
	 */
	@Override
	public void afterNavigateForward(WebDriver arg0) {
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#afterNavigateTo(java.lang.String, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void afterNavigateTo(String arg0, WebDriver driver) {
		if (!JsErrorCatcherConfiguration.getInstance().getJsErrorAutolog())
			return;
		JSErrorCatcher catcher = new FirefoxJsErrorCathcer(driver);
		ArrayList<String> errors;
		try {
			errors = catcher.getJsErrors();
			if (errors!=null && errors.size()>0)
				logger.warn(errors.toString());
		} catch (JsErrorCatcherException e) {
			logger.warn(e.getMessage(), e.getCause());
		}

	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#afterScript(java.lang.String, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void afterScript(String arg0, WebDriver arg1) {
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#beforeChangeValueOf(org.openqa.selenium.WebElement, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#beforeClickOn(org.openqa.selenium.WebElement, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeClickOn(WebElement arg0, WebDriver driver) {
		if (!JsErrorCatcherConfiguration.getInstance().getJsErrorAutolog())
			return;
		JSErrorCatcher catcher = new FirefoxJsErrorCathcer(driver);
		ArrayList<String> errors;
		try {
			errors = catcher.getJsErrors();
			if (errors!=null && errors.size()>0)
				logger.warn(errors.toString());
		} catch (JsErrorCatcherException e) {
			logger.warn(e.getMessage(), e.getCause());
		}
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#beforeFindBy(org.openqa.selenium.By, org.openqa.selenium.WebElement, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#beforeNavigateBack(org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeNavigateBack(WebDriver arg0) {
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#beforeNavigateForward(org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeNavigateForward(WebDriver arg0) {
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#beforeNavigateTo(java.lang.String, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeNavigateTo(String arg0, WebDriver driver) {
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#beforeScript(java.lang.String, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#onException(java.lang.Throwable, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void onException(Throwable tr, WebDriver driver) {
		logger.error(tr);

		try {
			Object screenshot = elementsFactory.screenshot(driver, tr
					.getClass().getName());
			if (screenshot != null)
				logger.error(screenshot);

			// EventFiringWebDriver uses Proxy mechanism to listen WebDriver
			// exceptions. If WebDriverEventListener.onException implementation
			// throws exception, Proxy will throw UndeclaredThrowableException
			// into test
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
