

p = []
d = []
p.append(int(input()))
p.append(int(input()))
p.append(int(input()))
d.append(int(input()))
d.append(int(input()))

tem = 0
sum = 0
for i in range(3):
    for j in range(2):
        sum = (p[i] + d[j]) + (p[i] + d[j])*(1/10)
        if tem == 0:
            tem = sum
        if tem > sum:
            tem = sum
print("%0.1f"%tem)