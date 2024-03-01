package com.cydeo.step_definitions;

import com.cydeo.utilities.BrowserUtils;
import io.cucumber.java.en.Given;


public class ShutdownRestart_SD {

    @Given("Shutdown")
    public void shutdown() {
        BrowserUtils.shutdownMac();
    }


    @Given("Restart")
    public void restart() {
        BrowserUtils.restartMac();
    }


    @Given("ShutdownTimer {int} seconds")
    public void shutdownTimer(int delaySeconds) {
        BrowserUtils.shutdownMacTimer(delaySeconds);
    }

    @Given("RestartTimer {int} seconds")
    public void restartTimer(int delaySeconds) {
        BrowserUtils.restartMacTimer(delaySeconds);
    }

    @Given("ShutdownTimer {int} Minutes")
    public void shutdowntimerMinutes(int delayMinutes) {
        BrowserUtils.shutdownMacTimerMinutes(delayMinutes);
    }

    @Given("RestartTimer {int} Minutes")
    public void restarttimerMinutes(int delayMinutes) {
        BrowserUtils.restartMacTimerMinutes(delayMinutes);
    }

}
