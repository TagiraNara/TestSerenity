Feature: Open the page

  @environment=dev
  Scenario: user gets the platform page 1
    Given user gets a page named "platform.pay.url"

  @environment=dev
  Scenario: user gets the platform page 2
    Given user gets a page named "platform.pay.url"

  @environment=dev @environment=test
  Scenario: user opens a platform page
    Given user opens browser on page named "platform.pay.url"

  @environment=dev @environment=test
  Scenario: user opens main page
    Given user opens browser on page named "test.base.url"

  @environment=dev @environment=test
  Scenario: user opens a platform page 1
    Given user opens browser on page object platformPage

  @environment=dev @environment=test
  Scenario: user opens a main page
    Given user opens browser on page object mainPage





