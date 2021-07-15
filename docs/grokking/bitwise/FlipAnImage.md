# Problem Challenge 1 - Flip an image - Easy
Given a binary matrix representing an image, we want to flip the image horizontally, then invert it.
To flip an image horizontally means that each row of the image is reversed. For example, flipping [0, 1, 1] horizontally results in [1, 1, 0].
To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [1, 1, 0] results in [0, 0, 1].

##### Example 1:

```
Input: [
  [1,0,1],
  [1,1,1],
  [0,1,1]
]
Output: [
  [0,1,0],
  [0,0,0],
  [0,0,1]
]
Explanation: First reverse each row: [[1,0,1],[1,1,1],[1,1,0]]. Then, invert the image: [[0,1,0],[0,0,0],[0,0,1]]
```

##### Example 2:

```
Input: [
  [1,1,0,0],
  [1,0,0,1],
  [0,1,1,1], 
  [1,0,1,0]
]
Output: [
  [1,1,0,0],
  [0,1,1,0],
  [0,0,0,1],
  [1,0,1,0]
]
Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]. Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
```

#### Java Solution
```java
public class FlipAnImage {
    public static void flipAndInvertImage(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int j = 0, k = matrix[i].length - 1;
            while (j <= k) {
                int t = matrix[i][k]^1;
                matrix[i][k] = matrix[i][j]^1;
                matrix[i][j] = t;
                j++;
                k--;
            }
        }
    }
}

```

#### [Java Source Code](../../../src/main/java/com/algorithm/bitmanipulation/FlipAnImage.java)