# Troubling Traversals Part 2 Explanation

## Topics

- Array

## Question

The party of adventurers are trying to navigate through land. The land has different elevations, and the adventurers are wondering if it’s possible to cross. This time, they’ve come prepared with materials to build bridges to cross land they couldn’t before. The adventurers are able to cross 1 length pits by jumping over them. Everything else needs a bridge. Given an integer array of 0s and 1s *t*, 0’s representing pits and 1’s representing land, and the amount of spaces they can replace with bridges *b*, return the array with the bridges set, return an empty array if it isn't possible. Bridges are represented as 2.

## Approach

Unlike the previous part, this is just array iteration. We can iterate through the array, and if we see a 0, we know it's a pit.

Once we find a pit, we need to keep track of the index of the start of the pit. We then need to keep iterating through the array until we find the end of the pit.

If the pit is length 1, we can just jump over it, so we don't need to build a bridge. If the pit is longer than 1, we need to build a bridge.

## Complexity

- Time Complexity: O(n)  
Where n is the length of the terrain array.

- Space Complexity: O(1)  

## Code

```java
int n = t.length;
int bridgesUsed = 0; // Keep track of the number of bridges used
for (int i = 0; i < n; i++) {
    if (t[i] == 0) {
        int start = i; // Keep track of the start of the pit
        while (i < n && t[i] == 0) { // Keep iterating until we find the end of the pit
            i++;
        }
        int length = i - start; // Calculate the length of the pit
        if (length > 1) {
            if (bridgesUsed + (length - 1) > b) {
                return new int[0]; // If we can't build the bridge, return an empty array
            }
            for (int j = start; j < i - 1; j++) {
                t[j] = 2; // Build the bridge
                bridgesUsed++; // Increment the number of bridges used
            }
        }
    }
}
return t; // Return the terrain array with the bridges set
```

Input:

```java
t = [1,0,1,1,1,0,0,1,1,1,0,1,0,1,0,0,0,1]
b = 5
```

Output:

```java
[1,0,1,1,1,2,2,1,1,1,0,1,0,1,2,2,2,1]
```
