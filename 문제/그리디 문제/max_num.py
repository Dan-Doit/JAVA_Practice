
# 한자리 숫자가 입력이됩니다
# 사용자로부터 입력이 되는데 0 ~ 9 값이 5자리가 입력이됩니다.

# 사용자는 연산을 할수있는데 단 두가지만 할수있습니다. + *
# 한자릿수 마다 연산을 하는데 가장 큰 수를 구하는 프로그램을 작성하시오.

num = input()

result = 0

for i in range(len(num)):
    i = int(num[i])
    if result <= 1 or i <= 1:
        result += i
    else:
        result *= i

print(result)