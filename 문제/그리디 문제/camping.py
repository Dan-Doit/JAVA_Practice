

count = 0
result = 0
left = 0

while True:
    days = list(map(int,input().split(' ')))

    if days[0] == 0:
        break


    result = (days[2]//days[1]) * days[0]
    left = days[2] % days[1]

    if left <= days[0]:
        result += left
    else:
        result += days[0]
    count += 1

    print(f"Case {count}: {result}")

