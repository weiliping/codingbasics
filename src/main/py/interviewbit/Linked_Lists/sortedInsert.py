#!/bin/python3

import math
import os
import random
import re
import sys


class DoublyLinkedListNode:
    def __init__(self, node_data):
        self.data = node_data
        self.next = None
        self.prev = None


class DoublyLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None

    def insert_node(self, node_data):
        node = DoublyLinkedListNode(node_data)

        if not self.head:
            self.head = node
        else:
            self.tail.next = node
            node.prev = self.tail

        self.tail = node


def print_doubly_linked_list(node, sep, fptr):
    while node:
        fptr.write(str(node.data))

        node = node.next

        if node:
            fptr.write(sep)

#
# Complete the 'sortedInsert' function below.
#
# The function is expected to return an INTEGER_DOUBLY_LINKED_LIST.
# The function accepts following parameters:
#  1. INTEGER_DOUBLY_LINKED_LIST llist
#  2. INTEGER data
#

#
# For your reference:
#
# DoublyLinkedListNode:
#     int data
#     DoublyLinkedListNode next
#     DoublyLinkedListNode prev
#
#


def sortedInsert(llist, data):
    # Write your code here
    if not llist:
        llist = DoublyLinkedListNode(data)
        return llist
    p = llist
    pre = DoublyLinkedListNode(-1)
    pre.next = p
    p.prev = pre
    while p:
        if p.data <= data:
            if not p.next or p.next.data > data:
                cur = DoublyLinkedListNode(data)
                nexNode = p.next
                p.next = cur
                cur.next = nexNode
                preNode = p.prev
                p.prev = cur
                cur.prev = preNode
                break
        else:
            cur = DoublyLinkedListNode(data)
            cur.next = p
            p.prev.next = cur
            cur.prev = p.prev
            p.prev = cur
            break
        p = p.next
    return pre.next


ll = DoublyLinkedList()
ll.insert_node(2)
ll.insert_node(3)
ll.insert_node(4)
print(sortedInsert(ll.head, 1))

# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     t = int(input())

#     for t_itr in range(t):
#         llist_count = int(input())

#         llist = DoublyLinkedList()

#         for _ in range(llist_count):
#             llist_item = int(input())
#             llist.insert_node(llist_item)

#         data = int(input())

#         llist1 = sortedInsert(llist.head, data)

#         print_doubly_linked_list(llist1, ' ', fptr)
#         fptr.write('\n')

#     fptr.close()
