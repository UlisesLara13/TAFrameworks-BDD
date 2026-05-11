package com.epam.training.student_ulises_lara.driver.factory;

import org.openqa.selenium.WebDriver;

/**
 * Factory interface for creating WebDriver instances.
 */
public interface WebDriverFactory {
    WebDriver createDriver();
}