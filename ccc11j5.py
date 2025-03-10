n = int(input())
w = [1 for _ in range(n + 1)]

for i in range(1, n):
    w[int(input())] *= w[i] + 1

print(w[n])