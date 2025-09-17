# Typing annotations for variables:
# name: type
int_variable: int = 4
float_variable: float = 42.0  # OK
float_variable = int_variable  # OK


# Typing annotations for functions (-> means "returns")
def int_to_string(i: int) -> str:
    return str(i)


print(int_to_string(int_variable))
print(int_to_string(float_variable))
# print(int_to_string(42) / 5)  # Both static and runtime error
