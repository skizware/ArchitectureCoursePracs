
Scenario: Inputting to string calculator

Given a string calculator
When I have an empty string input
Then I shall return 0

Given a string calculator
When I have single string input
Then I shall return the same value

Given a string calculator
When input is 4
Then I shall return 4

Given a string calculator
When input is 4,5
Then I shall return 9

Given a string calculator
When input is 4,5,6,5,4
Then I shall return 24

Given a string calculator
When input is 4\n5,6,5,4
Then I shall return 24

Given a string calculator
When input is //;\n6;5;4
Then I shall return 15

Given a string calculator
When input is //.\n6.9.4
Then I shall return 19

Given a string calculator
When input is //|\n6|-6|9|-9
Then a StringCalculatorException should be thrown
And the message should contain the negatives not allowed message