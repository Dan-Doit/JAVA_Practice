
from sys import stdin
input = stdin.readline

n = int(input())
count = 0
arr = []

while True:
    result = 1
    arr = []
    if count == n:
        break
    count += 1

    k = int(input())
    for i in range(k):
        arr.append(list(map(int,input().split(' '))))
    arr.sort(key= lambda x:x[0])
    print(arr)

    x = 0
    for i in range(1,k):
        if arr[x][1] > arr[i][1]:
            result += 1
            x = i

    print(result)

