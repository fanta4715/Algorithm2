room = input()

arr = [0] * 9

for c in room:
    if c != "9":
        arr[ord(c) - ord("0")] += 1
    else:
        arr[6] += 1

if arr[6] % 2 == 0:
    arr[6] //= 2
else:
    arr[6] = arr[6] // 2 + 1


print(max(arr))
