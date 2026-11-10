def win(b, p):
    w = [
        [0, 1, 2],
        [3, 4, 5],
        [6, 7, 8],
        [0, 3, 6],
        [1, 4, 7],
        [2, 5, 8],
        [0, 4, 8],
        [2, 4, 6]
    ]

    return any(b[i] == b[j] == b[k] == p for i, j, k in w)


def show(b):
    print(f"{b[0]}|{b[1]}|{b[2]}")
    print("-+-+-")
    print(f"{b[3]}|{b[4]}|{b[5]}")
    print("-+-+-")
    print(f"{b[6]}|{b[7]}|{b[8]}")


b = [" "] * 9

while True:

    show([str(i) if x == " " else x for i, x in enumerate(b)])

    print("Sha Turn")

    u = int(input("Move: "))

    if b[u] != " ":
        continue

    b[u] = "X"

    if win(b, "X"):
        show(b)
        print("Sha Wins")
        break

    if " " not in b:
        print("Draw")
        break

    print("AI Turn")

    for i in range(9):
        if b[i] == " ":
            b[i] = "O"
            print("AI played:", i)
            break

    show(b)

    if win(b, "O"):
        print("AI Wins")
        break

    if " " not in b:
        print("Draw")
        break