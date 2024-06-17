from collections import deque

n, m = map(int, input().split())
g = [[] for _ in range(n + 1)]


def taller(a, b):
    vis = [False] * (n + 1)
    qu = deque([a])
    vis[a] = True
    
    while qu:
        c = qu[0]
        qu.popleft()
        for i in g[c]:
            if not vis[i]:
                vis[i] = True
                qu.append(i)

    return vis[b]


for i in range(m):
    u, v = map(int, input().split())
    g[u].append(v)

p, q = map(int, input().split())

if taller(p, q):
    print("yes")
elif taller(q, p):
    print("no")
else:
    print("unknown")