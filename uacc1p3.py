b = [[] for _ in range(8)]
dir = [[-1, -1], [-1, 1], [1, -1], [1, 1]]
ans = 0


def dfs(r, c, cap):
    global ans
    for i in range (4):
        nr = r + dir[i][0]
        nc = c + dir[i][1]
        er = nr + dir[i][0]
        ec = nc + dir[i][1]
        if 0 <= nr < 8 and 0 <= nc < 8 and 0 <= er < 8 and 0 <= ec < 8 and b[nr][nc] == 'B' and b[er][ec] == '.':
            b[nr][nc] = '.'
            ans = max(ans, cap + 1)
            dfs(er, ec, cap + 1)
            b[nr][nc] = 'B'


for i in range(8):
    l = input()
    for j in l:
        b[i].append(j)

for i in range(8):
    for j in range(8):
        if b[i][j] == 'A':
            dfs(i, j, 0)

print(ans)
