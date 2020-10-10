
n, money = map(int,input().split(' '))
changes = []

for i in range(n):
    changes.append(int(input()))

count = 0
for i in range(1,n+1):
    count += (money//changes[-i])
    money = money%changes[-i]

print(count)