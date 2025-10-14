def outer_function():
    x = 10
    def middle_function():
        y = 20
        def inner_function():
            z = 30
            result = x + y + z
            return result
        inner_result = inner_function()
        print(inner_result)
        return inner_result * y

    middle_result = middle_function()
    print(middle_result)
    return middle_result + x

print(outer_function)