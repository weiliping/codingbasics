""" Node is defined as
class node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
"""


def checkBST(root):
    def helper(root, l, r):
        if not root:
            return True
        if root.data <= l or root.data >= r:
            return False
        if root.left and root.left.data >= root.data:
            return False
        if root.right and root.right.data <= root.data:
            return False
        return helper(root.left, l, root.data) and helper(root.right, root.data, r)
    return helper(root, 0, 10**4+1)
