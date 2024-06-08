h = int(input())

for i in range(1, h - 1, 2):
    for j in range(i):
        print("*", end="")
    for j in range(2 * (h - i)):
        print(" ", end="")
    for j in range(i):
        print("*", end="")
    print("")

for i in range(2 * h):
    print("*", end="")

print("")

for i in range(1, h - 1, 2):
    for j in range(h - i - 1):
        print("*", end="")
    for j in range((i + 1) * 2):
        print(" ", end="")
    for j in range(h - i - 1):
        print("*", end="")
    print("")