Feature: Pet API

  Scenario: Add new pet and validate
    Given a new pet is created having id:88 name:'Alfie'
    When add new pet API is called
    Then request status code is 200
    When get pet by id api is called
    Then correct pet is retrieved

  Scenario: Add new pet and delete it
    Given a new pet is created having id:99 name:'Luna'
    When add new pet API is called
    Then request status code is 200
    When delete pet by id api is called
    Then request status code is 200