import sys

def print_poster(P):
    for i in P:
        print(''.join(i))


n, m, r, c = map(int, input().split())

if (n == r and m % 2 == 0 and c % 2 == 1) or (m == c and n % 2 == 0 and r % 2 == 1):
    print("IMPOSSIBLE")
    sys.exit()

P = [['a' for _ in range(m)] for _ in range(n)]
if r == n and c != m:
    for i in range(m):
        P[0][i] = 'b'
    if c % 2 == 1:
        P[0][m // 2] = 'a'
    for i in range(c // 2):
        P[0][i] = 'a'
        P[0][m - i - 1] = 'a'
    print_poster(P)
    sys.exit()
elif c == m and r != n:
    for i in range(n):
        P[i][0] = 'b'
    if r % 2 == 1:
        P[n // 2][0] = 'a'
    for i in range(r // 2):
        P[i][0] = 'a'
        P[n - i - 1][0] = 'a'
    print_poster(P)
    sys.exit()

if n != r:
    for i in range(n - r):
        P[i][0] = 'b'

if m != c:
    for i in range(m - c):
        P[0][i] = 'b'

if n - r != 0 and m - c != 0:
    P[0][0] = 'c'

print_poster(P)