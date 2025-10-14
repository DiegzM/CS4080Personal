x = 10
def outer():
    x = 20
    inner()
    return f"outer x: {x}"

def inner():

    print(f"inner x: {x}")

print(outer())
