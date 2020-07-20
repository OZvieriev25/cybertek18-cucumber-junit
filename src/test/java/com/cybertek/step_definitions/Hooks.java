package com.cybertek.step_definitions;

import com.cybertek.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before(order = 2)
    public void setUpScenario() {
        System.out.println("-----> Before annotation (Hook)");
    }

    @Before(value = "@db", order = 1)
    public void setUpDatabaseConnection() {
        System.out.println("--------> Database connection (DB) <----------");
    }

    @After
    public void tearDownScenario(Scenario scenario) {
        //System.out.println("-----> After annotation (Hook)");
        //System.out.println("scenario.getName() = " + scenario.getName());
        //System.out.println("scenario.getSourceTagNames() = " + scenario.getSourceTagNames());
        //System.out.println("scenario.isFailed() = " + scenario.isFailed());

        // We need to take a screen shot using SELENIUM

        // We are going to attach it to our REPORT using ATTACH method
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

    }


    @After("@db")
    public void tearDownDatabaseConnection() {
        System.out.println("--------> Database connection (DB) <----------");
    }


    @BeforeStep
    public void setUpStep() {
        System.out.println("====> BeforeStep : Taking Screenshots <====");
    }

    @AfterStep
    public void tearDownStep() {
        System.out.println("====> AfterStep : Taking Screenshots <====");
    }
}
