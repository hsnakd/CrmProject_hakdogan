@Shutdown_Restart
Feature: Mac Control with Timer
  @Shutdown
  Scenario: Shutdown
    Given Shutdown

  @Restart
  Scenario: Restart
    Given  Restart

  @ShutdownTimerSecond
  Scenario: ShutdownTimerSecond
    Given ShutdownTimer 10 seconds

  @RestartTimerSecond
  Scenario: RestartTimerSecond
    Given  RestartTimer 10 seconds

  @ShutdownTimerMinute
  Scenario: ShutdownTimerMinute
    Given ShutdownTimer 1 Minutes

  @RestartTimerMinute
  Scenario: RestartTimerMinute
    Given  RestartTimer 1 Minutes





