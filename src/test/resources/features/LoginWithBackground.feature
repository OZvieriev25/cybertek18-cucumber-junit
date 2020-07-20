@loginWithBackground
Feature: Login feature
  CBT-25: As a user, I should be able to login with correct credentials to different
  accounts.And dashboard should be displayed.
  #for comments in feature file

  Background: User is on the login page
    Given User is on the login page

  Scenario: Librarian login scenario
    When User logs in as librarian
    Then User should see the dashboard

  Scenario: Student login scenario
    When User logs in as student
    Then User should see the dashboard

  @db
  Scenario: Admin login scenario
    When User logs in as admin
    Then User should see the dashboard
