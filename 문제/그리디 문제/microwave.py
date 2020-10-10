
t = int(input())

arr = [300,60,10]
answer = []
left = t

for i in range(3):
    answer.append(left // arr[i])
    left = left % arr[i]

if left == 0:
    print(" ".join(str(answer[i]) for i in range(3)))
else:
    print(-1)


