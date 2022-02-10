Feature: Signup to Gmail
  Scenario Outline: Signup with invalid password
    Given User visits to the signup page
    When User inputs invalid "<short_password>"
    Then User cannot signup
    Examples:
      | short_password |
      | wxyz |
      | dfgh |
      | 6789 |
  Scenario Outline: Signup with invalid password
    Given User visits to the signup page
    When User gives invalid "<weak_password>"
    Then User cannot signup again
    Examples:
      | weak_password |
      | aaaaaaaaa |
      | 12345678 |
      | abababab |