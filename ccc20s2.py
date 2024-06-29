import sys
from collections import deque

m = int(input())
n = int(input())
f = [[] for _ in range(1000001)]
v = [[False for _ in range(n + 1)] for _ in range(m + 1)]

for i in range(1, m + 1):
    row = input().split()
    for j in range(1, n + 1):
        num = int(row[j - 1])
        f[num].append([i, j])

q = deque([m * n])

while q:
    c = q[0]
    q.popleft()
    for i in f[c]:
        if not v[i[0]][i[1]]:
            v[i[0]][i[1]] = True
            q.append(i[0] * i[1])
        if v[1][1]:
            print("yes")
            sys.exit()

print("no")