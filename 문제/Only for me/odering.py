from collections import Counter
menus = {"짜장면":6000, "볶음밥":7000, "짬뽕":5000}
mearr = []
arr = []
name,menu = '',''
members = {}
ex_members = {}
n = 0
now = 0

people = int(input())

for i in range(people):
    name,menu = input().split(' ')
    arr.append(name)
    mearr.append(menu)
    if mearr[i] == "짜장면":
        members[name] = menus["짜장면"]
    elif mearr[i] == "볶음밥":
        members[name] = menus["볶음밥"]
    else:
        members[name] = menus["짬뽕"]
    now += int(members[name])
print(members)

print("현재까지 총 금액은 {0}원 입니다.".format(now))

print("얼마가 나오셨어요?")
total = int(input())

print("n빵 할금액은 {0}입니다.".format(total-now))
print()
n = total-now

print("제외될 대상이 있나요? 있으면 1 없으면 0 입력")
if input() == '1':
    print("몇명이 제외되나요?")
    k = int(input())
    for i in range(k):
        print("제외할사람의 이름을 입력해주세요")
        name = input()
        ex_members[name] = members[name]
        arr.remove(name)
        del members[name]
    n = int(n / len(members))

    for i in range(len(arr)):
        members[arr[i]] += n
    print(members)
    print(ex_members)


else:
    n = int(n / len(members))

    for i in range(len(arr)):
        members[arr[i]] += n
    print(members)