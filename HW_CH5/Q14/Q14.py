"""
Static Scoping Demo
Demonstrates how Python uses static scoping rules to resolve variable names.
Python doesn't support dynamic scoping, so dynamic scoping is simulated.
"""


def demo_static_scoping():
    """
    Variables are resolved based on where they are defined in the code,
    not on the calling sequence.
    """
    x = 100  # Global variable

    def func_a():
        print(f" In func_a, x = {x}")

    def func_b():
        x = 200  # This is func_b's local x
        print(f" In func_b, x = {x}")
        print(f" func_b is calling func_a...")
        func_a()  # Calls func_a, which uses the global x

    print("STATIC SCOPING DEMO")
    print("=" * 50)
    print(f"Global scope: x = {x}")
    print()

    print("Calling func_b...")
    func_b()  # Calls func_b, which in turn calls func_a
    print()

    print("  - func_a uses the global x (100) even when called from func_b.")
    print("  - func_b has its own local x (200) which does not affect func_a.")
    print("  - This is because func_a looks for x where it's defined.")
    print()


def demo_dynamic_scoping():
    """
    Simulates how dynamic scoping would work.
    Variables are resolved based on the calling sequence.
    """

    # Call stack to simulate dynamic scoping
    call_stack = []
    x = 100  # Global variable

    def func_a():
        """
        Simulates dynamic scope lookup by checking the call stack.
        """
        print(f" In func_a, searching for x in call stack...")

        # Search through call stack from most recent to oldest
        for scope in reversed(call_stack):
            if "x" in scope:
                print(f" Found x = {scope['x']} in call stack.")
                return
        print(f" x not found in call stack, using global x = {x}")

    def func_b():
        """
        Simulates a function with its own local variable.
        """
        local_vars = {"x": 200}  # func_b's local x
        call_stack.append(local_vars)  # Push local scope onto call stack
        print(f" In func_b, x = {local_vars['x']}")
        print(f" func_b is calling func_a...")
        func_a()  # Calls func_a, which looks up x in call stack
        call_stack.pop()  # Pop local scope off call stack

    print("\n")
    print("=" * 50)
    print("DYNAMIC SCOPING DEMO (Simulated)")
    print("=" * 50)
    print(f"Global scope: x = {x}")
    print()
    print("Calling func_b...")
    func_b()  # Calls func_b, which in turn calls func_a
    print()
    print("  - func_a finds x = 200 from func_b's scope when called.")
    print("  - If func_a were called directly, it would use global x = 100.")
    print("=" * 50)


def main():
    print("\n" + "=" * 50)
    print("Static vs Dynamic Scoping")
    print("=" * 50 + "\n")

    # Show static scoping
    demo_static_scoping()

    # Show dynamic scoping
    demo_dynamic_scoping()


if __name__ == "__main__":
    main()
