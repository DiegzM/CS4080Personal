first = int(input("Input value for first: "))
second = int(input("Input value for second: "))
third = int(input("Input value for third: "))

max = first
mid = second
min = third

temp = 0

if mid > max:
    temp = max
    max = mid
    mid = temp

if min > max:
    temp = max
    max = min
    min = temp

if min > mid:
    temp = mid
    mid = min
    min = temp

print(f"Max: {max}")
print(f"Mid: {mid}")
print(f"Min: {min}")