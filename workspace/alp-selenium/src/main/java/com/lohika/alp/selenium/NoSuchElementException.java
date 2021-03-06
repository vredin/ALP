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
package com.lohika.alp.selenium;

import com.lohika.alp.selenium.log.LogDescription;
import com.lohika.alp.selenium.log.LogDescriptionBean;

/**
 * Extends Selenium {@link org.openqa.selenium.NoSuchElementException} message
 * with {@link LogDescription} info
 */
public class NoSuchElementException extends
		org.openqa.selenium.NoSuchElementException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4410688378679905439L;

	/** The description. */
	private final LogDescriptionBean description;
	
	/** The element locator. */
	private final String locator;

	/**
	 * Instantiates a new no such element exception.
	 *
	 * @param description the description
	 * @param cause the cause
	 */
	public NoSuchElementException(LogDescriptionBean description,
			org.openqa.selenium.NoSuchElementException cause) {
		super(null, cause);

		this.description = description;
		this.locator = parseLocator(cause.getMessage());
	}

	/**
	 * Parses the locator.
	 *
	 * @param originalMessage the original message
	 * @return the string
	 */
	private String parseLocator(String originalMessage) {
		// TODO add handling of 'link test' and other locators or get locator
		// info from element directly
		int begin = originalMessage.indexOf("{");
		int end = originalMessage.indexOf("}", begin);

		if (begin == -1 || end == -1) {
			return "";
		}
		return originalMessage.substring(begin + 1, end);
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.WebDriverException#getMessage()
	 */
	@Override
	public String getMessage() {
		String reason = "Unable to locate element: {" + "\"type\":\""
				+ description.getType() + "\"," + "\"name\":\""
				+ description.getName() + "\"," + locator + "}";

		return reason;
	}

}
