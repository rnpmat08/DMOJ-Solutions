from collections import deque
import sys

n, m, k = map(int, input().split())
ans = n
s = [1] * n
inc = 1
q = deque()

if m * (n - m) + (m * (m + 1)) / 2 < k or n > k:
    print("-1")
    sys.exit()

k -= n

while k > 0:
    if inc < k:
        k -= inc
        q.append(inc)
    else:
        q.append(k)
        k = 0
    if inc + 1 <= k and inc + 1 < m:
        inc += 1

size = len(q)

for i in range(1, n + 1):
    if len(q) == 0:
        break
    c = q[0]
    q.popleft()
    if i - c - 1 >= 0:
        s[i] = s[i - c - 1]
    else:
        s[i] = s[i - 1] % m + 1

for i in range(size + 1, n):
    s[i] = s[i - 1]

for i in range(0, n - 1):
    print(s[i], end=" ")

print(s[n - 1])