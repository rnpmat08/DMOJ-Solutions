c = int(input())
row1 = []
row2 = []
s = input()
row1 = s.split()
s = input()
row2 = s.split()
ans = 0

for i in range(c):

    if row1[i] == '1':
        ans += 3
        if i < c - 1 and row1[i+1] == '1':
            ans -= 2
        if i % 2 == 0 and row2[i] == '1':
            ans -= 2
    if row2[i] == '1':
        ans += 3
        if i < c - 1 and row2[i+1] == '1':
            ans -= 2

print(total)