
from collections import deque

def DFS(graph,root):
    visited = []
    stack = [root]

    while stack:
        n = stack.pop()
        if n not in visited:
            visited.append(n)
            stack += graph[n] - set(visited)
    return visited

graph_list = {1:set([3,4]),
              2:set([3,4,5]),
              3:set([1,5]),
              4:set([1]),
              5:set([2,6]),
              6:set([3,5])
              }
root_node = 1
k = DFS(graph_list,root_node)
print(" ".join(str(i) for i in k))


def DFS_N(graph,root,visited):
    visited[root] = True
    print(root,end=' ')
    for i in graph[root]:
        if not visited[i]:
            DFS_N(graph,i,visited)

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

DFS_N(graph_list,1,visited)


