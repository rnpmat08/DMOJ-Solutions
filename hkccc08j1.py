c = int(input())
cBest = 0

for i in range(c):
    w, l = map(int, input().split())
    cBest = max(cBest, w * l)

n = int(input())
nBest = 0

for i in range(n):
    w, l = map(int, input().split())
    nBest = max(nBest, w * l)

if cBest > nBest:
    print("Casper")
elif nBest > cBest:
    print("Natalie")
else:
    print("Tie")