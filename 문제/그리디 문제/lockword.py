
k = int(input())
letter = input()
num = 0
for i in letter:
    num += 1
    answer = ord(i) - 64
    answer = answer - ((3 * num) + k)
    if answer <= 0:
        answer = answer + 26 + 64
    else:
        answer = answer + 64

    print(chr(answer),end='')
