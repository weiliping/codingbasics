#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'swapNodes' function below.
#
# The function is expected to return a 2D_INTEGER_ARRAY.
# The function accepts following parameters:
#  1. 2D_INTEGER_ARRAY indexes
#  2. INTEGER_ARRAY queries
#


def swapNodes(indexes, queries):
    sys.setrecursionlimit(1500)

    class Node:
        def __init__(self, v, level):
            self.val = v
            self.l = level
            self.left = None
            self.right = None

    def create_tree(indexes):
        from queue import Queue
        q = Queue()
        root = Node(1, 1)
        maxLevel = 1
        q.put(root)
        for l, r in indexes:
            cur = q.get()
            if l != -1:
                leftNode = Node(l, cur.l + 1)
                cur.left = leftNode
                q.put(leftNode)
            if r != -1:
                rightNode = Node(r, cur.l + 1)
                cur.right = rightNode
                q.put(rightNode)
            maxLevel = cur.l
        return (root, maxLevel)

    def swap_tree(tree, ks):
        if tree.left:
            swap_tree(tree.left, ks)
        if tree.right:
            swap_tree(tree.right, ks)
        if tree.l in ks:
            tree.left, tree.right = tree.right, tree.left
        return tree

    def traverse_tree(tree, item):
        if tree.left:
            traverse_tree(tree.left, item)
        item.append(tree.val)
        if tree.right:
            traverse_tree(tree.right, item)
    root, maxLevel = create_tree(indexes)
    res = []
    for k in queries:
        item = []
        ks = [x for x in range(1, maxLevel + 1) if x % k == 0]
        r = swap_tree(root, ks)
        traverse_tree(r, item)
        res.append(item)

    return res


    # Write your code here
swapNodes([[2, 3], [4, -1], [5, -1], [6, -1], [7, 8], [-1, 9],
          [-1, -1], [10, 11], [-1, -1], [-1, -1], [-1, -1]], [])

# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     n = int(input().strip())

#     indexes = []

#     for _ in range(n):
#         indexes.append(list(map(int, input().rstrip().split())))

#     queries_count = int(input().strip())

#     queries = []

#     for _ in range(queries_count):
#         queries_item = int(input().strip())
#         queries.append(queries_item)

#     result = swapNodes(indexes, queries)

#     fptr.write('\n'.join([' '.join(map(str, x)) for x in result]))
#     fptr.write('\n')

#     fptr.close()
