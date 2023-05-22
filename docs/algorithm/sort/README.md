## 排序 

- 常见的10种排序算法

  | ***稳定的排序***  | ***时间复杂度*** |  ***空间复杂度*** |  ***稳定性*** |
  | ------------- | ------------- | ------------- | ------------- |
  | 冒泡排序  | O(n^2)  | 1  | 稳定  |
  | 插入排序  | O(n^2)  | 1  | 稳定  |
  | 归并排序  | O(n*log n)  | n  | 稳定  |
  | 选择排序  | O(n^2)  | 1  | 不稳定  |
  | 希尔排序  | O(n*log n)  | 1  | 不稳定  |
  | 快速排序  | O(n*log n)  | 1  | 不稳定  |
  | 堆排序  | O(n*log n)  | 1  | 不稳定  |
  | 计数排序  | O(n)  | O(n)  | 稳定  |
  | 基数排序  | O(n)  | O(n)  | 稳定  |
  | 桶排序  | O(n)  | O(n)  | 稳定  |

1. 冒泡排序 [Bubble Sort](../../../src/main/java/com/algorithm/sort/BubbleSort.java)

   从第0个元素到第n-1个元素遍历，若前面一个元素大于后面一个元素，则交换两个元素，这样可将整个序列中最大的元素冒泡到最后，然后再从第0个到第n-2遍历，如此往复，直到只剩一个元素。
   ```java
   public class BubbleSort {
       void BubbleSort(int arr[], int length) {
           for (int i = 0; i < length; i++) {
               for (int j = 0; j < length - i - 1; j++) {
                   if (arr[j] > arr[j + 1]) {
                       int temp;
                       temp = arr[j + 1];
                       arr[j + 1] = arr[j];
                       arr[j] = temp;
                   }
               }
           }
       }
   }
   ```
2. 插入排序 [Insert Sort](../../../src/main/java/com/algorithm/sort/InsertSort.java)
   
   思路是类似扑克牌的排序，每次从未排序序列的第一个元素，插入到已排序序列中的合适位置。假设初始的有序序列为第0个元素（本文描述的序号都从0开始），只有一个元素的序列肯定是有序的，然后从原先序列的第1个元素开始到第n-1个元素遍历，每次将当前元素插入到它之前序列中的合适位置。
   例如要将数组arr=[4,2,8,0,5,1]排序，可以将4看做是一个有序序列，将[2,8,0,5,1]看做一个无序序列。无序序列中2比4小，于是将2插入到4的左边，此时有序序列变成了[2,4]，无序序列变成了[8,0,5,1]。无序序列中8比4大，于是将8插入到4的右边，有序序列变成了[2,4,8],无序序列变成了[0,5,1]。以此类推，最终数组按照从小到大排序。
   ```java
   public class InsertSort {
       void insertSort(int arr[], int length) {
           for (int i = 1; i < length; i++) {
               int j;
               if (arr[i] < arr[i - 1]) {
                   int temp = arr[i];
                   for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
                       arr[j + 1] = arr[j];
                   }
                   arr[j + 1] = temp;
               }
           }
       }
   }
   ```     
    
3. 归并排序 [Merge Sort](../../../src/main/java/com/algorithm/sort/MergeSort.java)
   
      利用二分的特性，将序列分成两个子序列进行排序，将排序后的两个子序列归并（合并），当序列的长度为2时，它的两个子序列长度为1，即视为有序，可直接合并，即达到归并排序的最小子状态。
      ```java
      public class MergeSort {
          void mergeSort(int arr[], int start, int end, int temp[]) {
              if (start >= end) {
                  return;
              }
              int mid = (start + end) / 2;
              mergeSort(arr, start, mid, temp);
              mergeSort(arr, mid + 1, end, temp);
              int length = 0;
              int i_start = start;
              int i_end = mid;
              int j_start = mid + 1;
              int j_end = end;
              while (i_start <= i_end && j_start <= j_end) {
      
                  if (arr[i_start] < arr[j_start]) {
                      temp[length] = arr[i_start];
                      length++;
                      i_start++;
                  } else {
                      temp[length] = arr[j_start];
                      length++;
                      j_start++;
                  }
              }
      
              while (i_start <= i_end) {
                  temp[length] = arr[i_start];
                  i_start++;
                  length++;
              }
      
              while (j_start <= j_end) {
                  temp[length] = arr[j_start];
                  length++;
                  j_start++;
              }
              for (int i = 0; i < length; i++) {
                  arr[start + i] = temp[i];
              }
          }    
      }
      ```
   
4. 选择排序 [Selection Sort](../../../src/main/java/com/algorithm/sort/SelectionSort.java)
       
      从全部序列中选取最小的，与第0个元素交换，然后从第1个元素往后找出最小的，与第一个元素交换，再从第2个元素往后选取最小的，与第2个元素交换，直到选取最后一个元素。
      ```java
      public class SelectionSort {
          void selectionSort(int arr[], int length) {
              for (int i = 0; i < length; i++) {
                  int index = i;
                  for (int j = i + 1; j < length; j++) {
                      if (arr[j] < arr[index]) {
                          index = j;
                      }
                  }
                  if (index == i) {
                      continue;
                  }
                  int temp;
                  temp = arr[index];
                  arr[index] = arr[i];
                  arr[i] = temp;
              }
          }    
      }
      ```
      
5. 希尔排序 [Shell Sort](../../../src/main/java/com/algorithm/sort/ShellSort.java)
   
      其算法的基本思想是：先将待排记录序列分割成为若干子序列分别进行插入排序，待整个序列中的记录"基本有序"时，再对全体记录进行一次直接插入排序。
      ```java
      public class ShellSort {
          void shellSort(int arr[], int length) {
              int increasement = length;
              int i, j, k;
              while (increasement > 1) {
                  increasement = increasement / 3 + 1;
                  for (i = 0; i < increasement; i++) {
                      for (j = i + increasement; j < length; j += increasement) {
                          if (arr[j] < arr[j - increasement]) {
                              int temp = arr[j];
                              for (k = j - increasement; k >= 0 && temp < arr[k]; k -= increasement) {
                                  arr[k + increasement] = arr[k];
                              }
                              arr[k + increasement] = temp;
                          }
                      }
                  }
              }
          }    
      }
      ```
6. 快速排序 [Quick Sort](../../../src/main/java/com/algorithm/sort/QuickSort.java)
    
      快排的思想是，选取第一个数为基准，通过一次遍历将小于它的元素放到它的左侧，将大于它的元素放到它的右侧，然后对它的左右两个子序列分别递归地执行同样的操作
      ```java
      public class QuickSort {
          void quickSort(int arr[], int start, int end) {
              if (start >= end) {
                  return;
              }
              int i = start;
              int j = end;
              int baseval = arr[start];
              while (i < j) {
                  while (i < j && arr[j] >= baseval) {
                      j--;
                  }
                  if (i < j) {
                      arr[i] = arr[j];
                      i++;
                  }
                  while (i < j && arr[i] < baseval) {
                      i++;
                  }
                  if (i < j) {
                      arr[j] = arr[i];
                      j--;
                  }
              }
              arr[i] = baseval;
              quickSort(arr, start, i - 1);
              quickSort(arr, i + 1, end);
          }    
      }
      ```
7. 堆排序 [Heap Sort](../../../src/main/java/com/algorithm/sort/HeapSort.java)
    
      堆排序利用的是二叉树的思想，所谓堆就是一个完全二叉树，完全二叉树的意思就是，除了叶子节点，其它所有节点都有两个子节点，这样子的话，完全二叉树就可以用一个一块连续的内存空间（数组）来存储，而不需要指针操作了。堆排序分两个流程，首先是构建大顶堆，然后是从大顶堆中获取按逆序提取元素。
      首先是大顶堆，大顶堆即一个完全二叉树，的每一个节点都大于它的所有子节点。大顶堆可以按照从上到下从左到右的顺序，用数组来存储，第i个节点的父节点序号为(i-1)/2，左子节点序号为2i+1，右子节点序号为2(i+1)。构建大顶堆的过程即从后向前遍历所有非叶子节点，若它小于左右子节点，则与左右子节点中最大的交换，然后递归地对原最大节点做同样的操作。
      
      ```java
      public class HeapSort {
          void heapSort(int arr[], int length) {
              for (int i = length / 2 - 1; i >= 0; i--) {
                  heapAdjust(arr, i, length);
              }
              for (int i = length - 1; i >= 0; i--) {
                  int temp;
                  temp = arr[i];
                  arr[i] = arr[0];
                  arr[0] = temp;
                  heapAdjust(arr, 0, i);
              }
          }
      
          void heapAdjust(int arr[], int i, int length) {
              int max = i, lchild = i * 2 + 1, rchild = i * 2 + 2;
              if (lchild < length && arr[lchild] > arr[max]) {
                  max = lchild;
              }
              if (rchild < length && arr[rchild] > arr[max]) {
                  max = rchild;
              }
              if (max != i) {
                  int temp;
                  temp = arr[i];
                  arr[i] = arr[max];
                  arr[max] = temp;
                  heapAdjust(arr, max, length);
              }
          }    
      }
      ```
8. 桶排序 [Bucket Sort](../../../src/main/java/com/algorithm/sort/BucketSort.java)
    
    将数据分别放入到 n 个桶内，先对桶内数据进行排序，然后遍历桶依次取出桶中的元素即可完成排序。
    ```java
    public class BucketSort {
        void bucketSort(int[] nums) {
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, n = nums.length;
    
            for (int i = 0; i < n; i++) {
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i]);
            }
    
            int bucketNum = (max - min) / n + 1;
            ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
            for (int i = 0; i < bucketNum; i++) {
                bucketArr.add(new ArrayList<Integer>());
            }
    
            for (int i = 0; i < n; i++) {
                int num = (nums[i] - min) / (n);
                bucketArr.get(num).add(nums[i]);
            }
    
            for (int i = 0; i < bucketArr.size(); i++) {
                Collections.sort(bucketArr.get(i));
            }
    
            int index = 0;
            for (ArrayList<Integer> bucketNums : bucketArr) {
                for (Integer num : bucketNums) {
                    nums[index++] = num;
                }
            }
        }
    }
    ```
9. 计数排序 [Count Sort](../../../src/main/java/com/algorithm/sort/CountSort.java)
    
    计数排序是一种不基于比较的排序算法，主要思想是计算出待排序序列的最大值 maxValue 与 最小值 minValue，开辟一个长度为 maxValue - minValue + 1 的额外空间，统计待排序序列中每个元素的数量，记录在额外空间中，最后遍历一遍额外空间，按照顺序把每个元素赋值到原始序列中。计数排序可以理解是桶排序的一种特殊情况。当要排序的 n 个数据，所处的范围并不大的时候，比如最大值是 k可以把数据划分成 k 个桶。每个桶内的数据值都是相同的，省掉了桶内排序的时间。
    
    ```java
    public class CountSort {
        void sort(int[] a, int n) {
            int max = a[0];
    
            for (int i = 1; i < n; i++) {
                if (max < a[i]) {
                    max = a[i];
                }
            }
    
            int[] numSum = new int[max + 1];
    
            for (int i = 0; i < n; i++) {
                numSum[a[i]]++;
            }
    
            for (int j = 1; j <= max; j++) {
                numSum[j] += numSum[j - 1];
            }
    
            int[] tmp = new int[n];
    
            for (int i = 0; i < n; i++) {
                tmp[numSum[a[i]] - 1] = a[i];
                numSum[a[i]]--;
            }
            System.out.println(Arrays.toString(tmp));
        }
    }
    ```  
10. 基数排序 [Radix Sort](../../../src/main/java/com/algorithm/sort/RadixSort.java)        
    
    将所有待比较数值（自然数）统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。
    
    <b>基数排序的两种方式： 1. 高位优先，又称为最有效键(MSD)，它的比较方向是由右至左; 2. 低位优先，又称为最无效键(LSD)，它的比较方向是由左至右</b>

    ```java
    public class RadixSort {
        void radixSort(int[] arr) {
            int max = arr[0];
            int exp;
    
            for (int anArr : arr) {
                if (anArr > max) {
                    max = anArr;
                }
            }
    
            for (exp = 1; max / exp > 0; exp *= 10) {
                int[] temp = new int[arr.length];
                int[] buckets = new int[10];
                for (int value : arr) {
                    buckets[(value / exp) % 10]++;
                }
    
                for (int i = 1; i < 10; i++) {
                    buckets[i] += buckets[i - 1];
                }
    
                for (int i = arr.length - 1; i >= 0; i--) {
                    temp[buckets[(arr[i] / exp) % 10] - 1] = arr[i];
                    buckets[(arr[i] / exp) % 10]--;
                }
    
                System.arraycopy(temp, 0, arr, 0, arr.length);
            }
        }
    }
    ```   
## Reference
- [基数排序](https://www.cnblogs.com/luomeng/p/10639926.html)
- [十大经典排序算法最强总结](https://www.cnblogs.com/guoyaohua/p/8600214.html)