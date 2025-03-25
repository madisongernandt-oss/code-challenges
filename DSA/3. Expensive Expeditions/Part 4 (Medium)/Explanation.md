# Expensive Expeditions Part 4 Explanation

## Topics

- Array
- Matrix
- Prefix Sum

## Question

The adventurers come across a valley of valuable land they can excavate to dig treasure. The adventurers want to dig up the most valuable pieces of land, but they can only choose land n x n area.
Given the size of the allowed bounds n and a 2D integer array m, find the most valuable area such that:

- The area must be n x n.
- The square cannot go out of bounds (You have to claim n x n land).

Return a 2D array of the coordinates of the top-left corner and bottom-right corners of the area claimed.

## Naive Approach

To solve this problem, you can just iterate through the matrix and check the sum of every n x n area.

1. Iterate through the matrix.
2. Compute the sum of every n x n area.
3. Track the maximum sum and the coordinates of the area.
4. Return the coordinates of the area with the maximum sum.

## Optimized Approach

A more efficient approach is to use a prefix sum matrix, which allows us to compute the sum of any submatrix in constant time after the prefix sums are processed.

When you create the prefix sum matrix, the prefix sum for an element at position (i, j) is the sum of all the elements in the submatrix with the top-left corner at (0, 0) and the bottom-right corner at (i, j).

To do this, you can use the following formula:

```java
prefixSum[i][j] = m[i - 1][j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
```

To get the sum of a submatrix, you can use the following formula:

```java
int sum = prefixSum[i][j] - prefixSum[i - n][j] - prefixSum[i][j - n] + prefixSum[i - n][j - n];
```

and if this sum is greater than the current max sum, you can update the max sum and the coordinates of the area.

Given the text case example

```java
[
  [1, -1, 1, 1, 1, 1],
  [3, 0, -4, 4, 4, 2],
  [1, 0, 1, 1, 1, 1],
  [1, 0, 0, 0, 0, -2],
  [0, 1, 0, 1, -1, 1],
  [1, 2, -4, 1, 1, 1]
]
```

the prefix sum matrix will be:

```java
[
  [0, 0, 0, 0, 0, 0, 0],
  [0, 1, 0, 1, 2, 3, 4],
  [0, 4, 3, 0, 5, 10, 13],
  [0, 5, 4, 2, 8, 14, 18],
  [0, 6, 5, 3, 9, 15, 17],
  [0, 6, 6, 4, 11, 16, 19],
  [0, 7, 9, 3, 11, 17, 21]
]
```

## Complexity

- Time Complexity: O(n)  
Where n is the length of the places array.

- Space Complexity: O(1)
We are using an integer array of size 101, which is a constant space.

## Code

```java
int rows = m.length;

if (rows == 0 || n > rows || n > m[0].length) return new int[][] {{-1, -1}, {-1, -1}}; // Test cases should always be valid, so we return [-1, -1] if not
int cols = m[0].length;

int[][] prefixSum = new int[rows + 1][cols + 1];
for (int i = 1; i <= rows; i++) {
    for (int j = 1; j <= cols; j++) {
        prefixSum[i][j] = m[i - 1][j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
    }
}
        
int maxSum = Integer.MIN_VALUE;
int[] topLeft = new int[2];
int[] bottomRight = new int[2];

for (int i = n; i <= rows; i++) {
    for (int j = n; j <= cols; j++) {
        int currentSum = prefixSum[i][j] - prefixSum[i - n][j] - prefixSum[i][j - n] + prefixSum[i - n][j - n];
        if (currentSum > maxSum) {
            maxSum = currentSum;
            topLeft[0] = i - n;
            topLeft[1] = j - n;
            bottomRight[0] = i - 1;
            bottomRight[1] = j - 1;
        }
    }
}
        
return new int[][] {topLeft, bottomRight};
```

Input:

```java
- n = 5
- m = [
  [1, -1, 1, 1, 1, 1],
  [3, 0, -4, 4, 4, 2],
  [1, 0, 1, 1, 1, 1],
  [1, 0, 0, 0, 0, -2],
  [0, 1, 0, 1, -1, 1],
  [1, 2, -4, 1, 1, 1]
]

```

Output:

```java
[[0, 0], [4, 4]]
```
