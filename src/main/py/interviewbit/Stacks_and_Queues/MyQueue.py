class MyQueue(object):
    def __init__(self):
      self.mq = []

    def peek(self):
        return self.mq[0]

    def pop(self):
        return self.mq.pop(0)

    def put(self, value):
        self.mq.append(value)


queue = MyQueue()
queue.put(15)
queue.put(17)
print(queue.peek())
queue.put(25)
queue.pop()
print(queue.peek())
queue.pop()
print(queue.peek())

# t = int(input())
# for line in range(t):
#     values = map(int, input().split())
#     values = list(values)
#     if values[0] == 1:
#         queue.put(values[1])
#     elif values[0] == 2:
#         queue.pop()
#     else:
#         print(queue.peek())
