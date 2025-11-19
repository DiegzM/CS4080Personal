def modify(a, b):
    a[0] = a[0] + 1
    b[0] = b[0] + 1

x = [5]
modify(x, x)
print(x[0])  # Output will be 7