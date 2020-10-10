
def solution(n):
    answer = ''

    arr = ['1','2','4']
    while n//3 >= 1 and n != 3:
        n -= 3
        answer += arr[0]

    if n%3 == 1:
        answer += arr[0]
    elif n%3 == 2:
        answer += arr[1]
    elif n%3 == 0:
        answer += arr[2]
    print(answer)
    return answer

solution(7)