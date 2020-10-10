
num = 3
num = num * num
x,y = 2,2
count = 0

for i in range(1,x+1):
    for j in range(1,y+1):
        count += 1

count = int(count-1)
result = ((count/num)*100)

print(int(round(result,0)))