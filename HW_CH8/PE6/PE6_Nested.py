first = int(input("Input value for first: "))
second = int(input("Input value for second: "))
third = int(input("Input value for third: "))

max = first
mid = second
min = third

if (first >= second and first >= third):
    max = first
    if (second >= third):
        mid = second
        min = third
    else:
        mid = third
        min = second

elif (second >= first and second >= third):
    max = second
    if (first >= third):
        mid = first
        min = third
    else:
        mid = third
        min = first

else:
    max = third
    if (first >= second):
        mid = first
        min = second
    else:
        mid = second
        min = first

print(f"Max: {max}")
print(f"Mid: {mid}")
print(f"Min: {min}")