# Expensive Expeditions Part 3 Explanation

## Topics

- Stack
- String

## Question

The adventurers picked up map pieces while they were on their journey. They put together the map pieces which revealed some type of message.
They figured out that a hyphen (-) meant to remove the previous non-hyphen (-) character.
They also figured out that a plus (+) meant to repeat the previous non-plus (+) character removed.
Given a string of the message m, return a string of what the message is.

## Approach

Like Part 2, we have to iterate through the string and use a stack to keep track of the characters to solve this problem.

Stacks are a data structure that stores elements in a last-in-first-out (LIFO) manner.
Think of a stack of books, the last book you put on the stack is the first book you take off.

Instantiate a stack for the characters and a variable to keep track of the previously removed character.
As you iterate through the string, append the characters to the stack.
If you encounter a hyphen (-), remove the previous non-hyphen character from the stack.
If you encounter a plus (+), repeat the previous non-plus character removed from the stack.

Learn more about stacks [here](https://www.w3schools.com/dsa/dsa_data_stacks.php).

## Complexity

- Time Complexity: O(n)  
Where n is the length of the places array.

- Space Complexity: O(1)
We are using an integer array of size 101, which is a constant space.

## Code

```java
Stack<Character> stack = new Stack<>();
Character prev = null;
for (char c : m.toCharArray()) {
    switch (c) {
        case '-':
            if (!stack.isEmpty()) {
                prev = stack.pop();
            }   
            break;
        case '+':
            if (prev != null) {
                stack.push(prev);
            }   
            break;
        default:
            stack.push(c);
            break;
    }
}
StringBuilder result = new StringBuilder();
for (char c : stack) {
    result.append(c);
}
return result.toString();
```

Input:

```java
m = "h-H-+e-e-+lll-l-o-o"
```

Output:

```bash
Hello
```
