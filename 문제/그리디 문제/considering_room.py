
n = int(input())
arr = []
for _ in range(n):
    a,b = map(int,input().split(' '))
    arr.append((a,b))

arr = sorted(arr,key=lambda x:x[0])
arr.sort(key=lambda x:x[1])

count = 0
temp = 0

for i in range(n):
    if temp <= arr[i][0]:
        count += 1
        temp = arr[i][1]

print(count)



