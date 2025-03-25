# Part 2

The party of adventurers are trying to navigate through land. The land has different elevations, and the adventurers are wondering if it’s possible to cross. This time, they’ve come prepared with materials to build bridges to cross land they couldn’t before. The adventurers are able to cross 1 length pits by jumping over them. Everything else needs a bridge. Given an integer array of 0s and 1s *t*, 0’s representing pits and 1’s representing land, and the amount of spaces they can replace with bridges *b*, return the array with the bridges set, return an empty array if it isn't possible. Bridges are represented as 2.

## Contraints

- 1 <= *t.length* <= 5000
- 0 <= *b* <= *t.length*

## Case 1

Input:

- t = [1,0,1,1,1,0,0,1,1,1,0,1,0,1,0,0,0,1]
- b = 5

Output:

- [1,0,1,1,1,2,2,1,1,1,0,1,0,1,2,2,2,1]

## Case 2

Input:

- t = [1,0,1,1,1,0,0,1,1,1,0,1,0,1,0,0,0,1]
- b = 3

Output:

- []

## Submission

Write your answer in the Solution class, and run the main file / class to test.

Judge file contains the solution. Try challenging yourself before looking if you cannot get it.
