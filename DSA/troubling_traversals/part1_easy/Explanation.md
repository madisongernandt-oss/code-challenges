# Troubling Traversals Part 1 Explanation

## Topics

- Array
- Math

## Question

The party of adventurers are trying to navigate through land. The land has different elevations, and the adventurers are wondering if it’s possible to cross. It is possible to cross if the absolute difference in elevations between the current elevation and the next elevation is smaller than or equal to the current elevation and the next elevation. Given a double array of heights *h*, return a boolean if it’s possible to cross.

## Approach

This question is just a simple math question. We can iterate through the array, and check if the difference between the current and next elevation is smaller or equal to both numbers.

Take h = [5, 3, 6, 4, 2, 3] for example.

For the first decision, the difference between the current and next elevation is 2 (|5 - 3|), which is smaller than 3 and 5, so it is possible to cross.

For the second decision, the difference between the current and next elevation is 3 (|3 - 6|), which is equal to 3 and smaller than 6, so it is possible to cross.

For the third decision, the difference between the current and next elevation is 2 (|6 - 4|), which is smaller than 6 and 4, so it is possible to cross.

Continue this process until the end of the array, and if we can reach the end of the array, return true, otherwise return false.

## Complexity

- Time Complexity: O(n)  
Where n is the length of the height array.

- Space Complexity: O(1)  

## Code

```java
for (int i = 1; i < h.length; i++) {
    double diff = Math.abs(h[i] - h[i - 1]);
    if (diff > h[i] || diff > h[i - 1]) {
        return false;
    }
}

return true;
```

Input:

```java
h = [5, 3, 6, 4, 2, 3]
```

Output:

```bash
true
```
