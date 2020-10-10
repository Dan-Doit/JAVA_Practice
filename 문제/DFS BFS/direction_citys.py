

from _collections import deque
# 도시개수, 도로개수, 거리정보, 출발 도시 번호
n,m,k,x = map(int,input().split())

graph = [[] for _ in range(n+1)]

for _ in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)
print(graph)

visit = [-1] * (n+1)
visit[x] = 0
ans = []


queue = deque([x])

while queue:
    pick = queue.popleft()

    for i in graph[pick]:
        if visit[i]==-1:
            queue.append(i)
            visit[i] = visit[pick] + 1

re = False
for i in range(len(visit)):
    if k == visit[i]:
        print(i)
        re = True
if re == False:
    print(-1)