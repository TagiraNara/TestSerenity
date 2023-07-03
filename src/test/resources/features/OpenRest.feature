Feature: Open the page via get request

  @environment=dev
  Scenario: user gets the platform page 1
    Given user gets a page named "platform.pay.url"

  @environment=dev
  Scenario: user gets the platform page 2
    Given user gets a page named "platform.pay.url"