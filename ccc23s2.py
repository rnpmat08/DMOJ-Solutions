N = int(input())
h = []
h = input().split()
s = [2000000000] * (N + 1)

def check(l, r):
    sym = 0
    while l >= 0 and r < N:
        diff = r - l + 1
        sym += abs(h[l] - h[r])
        s[diff] = min(s[diff], sym)
        l -= 1
        r += 1

for i in range(n):
    check(i, i)
    check(i, i + 1)

print(*s[1:])