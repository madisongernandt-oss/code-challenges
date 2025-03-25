# Part 3

The adventurers picked up map pieces while they were on their journey. They put together the map pieces which revealed some type of message.
They figured out that a hyphen (-) meant to remove the previous non-hyphen (-) character.
They also figured out that a plus (+) meant to repeat the previous non-plus (+) character removed.
Given a string of the message m, return a string of what the message is.

## Contraints

- 1 <= *m.length* <= 1000
- m[i] is a letter, symbol, number, space, underscore (_), plus (+), or a hyphen (-)

## Case 1

Input:

- m = “h-H-+e-e-+lll-l-o-o”

Output:

- “Hello”

## Case 2

Input:

- m = "Goodbye-------+oodmorning!"

Output:

- “Goodmorning!”

## Submission

Write your answer in the Solution class, and run the main file / class to test.

Judge file contains the solution. Try challenging yourself before looking if you cannot get it.
