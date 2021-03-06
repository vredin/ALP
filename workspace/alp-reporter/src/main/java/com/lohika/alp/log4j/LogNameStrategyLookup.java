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
package com.lohika.alp.log4j;



/**
 * The Class LogNameStrategyLookup.
 */
public class LogNameStrategyLookup {

	/**
	 * Gets the log name strategy.
	 *
	 * @param className the class name
	 * @return the log name strategy
	 * @throws ClassNotFoundException the class not found exception
	 * @throws InstantiationException the instantiation exception
	 * @throws IllegalAccessException the illegal access exception
	 */
	public static LogNameStrategy getLogNameStrategy(String className)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {

		return (LogNameStrategy) Class.forName(className).newInstance();
	}

}
