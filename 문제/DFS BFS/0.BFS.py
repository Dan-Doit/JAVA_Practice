
from collections import deque

def BFS(graph,root):
    visited = []
    queue = deque([root])

    while queue:
        n = queue.popleft()
        if n not in visited:
            visited.append(n)
            queue += graph[n] - set(visited)
    return visited


graph_list = {1:set([3,4]),
              2:set([3,4,5]),
              3:set([1,5]),
              4:set([1]),
              5:set([2,6]),
              6:set([3,5])
              }
root_node = 1
k = BFS(graph_list,root_node)
print(" ".join(str(i) for i in k))


def BFS_N(graph,root,visited):
    queue = deque([root])
    visited[root] = True

    while queue:
        n = queue.popleft()
        print(n, end=' ')

        for i in graph[n]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

visited = [False] * 9
graph_list = [[],
              [2,3,8],
              [1,7],
              [1,4,5],
              [3,5],
              [3,4],
              [7],
              [2,6,8],
              [1,7]
              ]

BFS_N(graph_list,1,visited)



