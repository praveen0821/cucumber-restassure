Feature: the version can be retrieved

  @Test3
  Scenario: client makes call to GET /version
    When the client calls /version
    Then the client receives status code of 200
    And the client receives server version of 1.0
   