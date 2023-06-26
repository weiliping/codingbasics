import os


class Graph:
    def __init__(self, n):
        self.n = n
        self.graph = [[] for _ in range(self.n)]

    def connect(self, i, j):
        if j not in self.graph[i]:
            self.graph[i].append(j)
        if i not in self.graph[j]:
            self.graph[j].append(i)

    def find_all_distances(self, i):
        visited = [False for _ in range(self.n)]
        res = [-1 for _ in range(self.n)]
        q = []
        q.append([i, 0])
        while len(q) > 0:
            curr = q.pop(0)
            visited[curr[0]] = True
            arr = self.graph[curr[0]]
            for k in self.graph[curr[0]]:
                if visited[k]:
                    continue
                res[k] = curr[1] + 6
                q.append([k, curr[1] + 6])
                visited[k] = True
        for j in range(len(res)):
            if i != j:
                print(res[j], end=" ")


f = open(os.path.dirname(os.path.abspath(__file__)) + '/graph_params.txt', 'r')
g = Graph(70)
for a in f:
    u, v = a.strip().split(" ")
    g.connect(int(u) - 1, int(v) - 1)
# r = g.graph[15]
# r.sort()
# print(r)
g.find_all_distances(15)
# t = int(input())
# for i in range(t):
#     n, m = [int(value) for value in input().split()]
#     graph = Graph(n)
#     for i in range(m):
#         x, y = [int(x) for x in input().split()]
#         graph.connect(x-1, y-1)
#     s = int(input())
#     graph.find_all_distances(s-1)
