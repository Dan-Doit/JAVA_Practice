from sys import stdin
input = stdin.readline
T = int(input())

for _ in range(T):
    N = int(input())
    A = [0] * (N + 1)

    for _ in range(1, N+1):
        a, b = map(int, input().split())
        A[a] = b
        print(A)
    key = A[1]
    ans = 1
    for i in range(2, N+1):
        if A[i] < key:
            key = A[i]
            ans += 1
    print(ans)

