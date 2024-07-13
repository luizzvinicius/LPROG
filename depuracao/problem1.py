def calculate_average(numbers):
    total = sum(numbers)
    if len(numbers) == 0:
        return 0
    return total / len(numbers) # avoid ZeroDivisionError


def find_max(numbers):
    if len(numbers) == 0:
        return
    max_number = numbers[0] # avoid IndexError
    for number in numbers:
        if number > max_number:
            max_number = number
    return max_number


def get_numbers():
    numbers = input("Enter numbers separated by spaces: ").split()
    numbers = [float(num) for num in numbers] # change to float to accept all kinds of value
    return numbers


def main():
    numbers = get_numbers()
    print("Average: ", calculate_average(numbers))
    print("Maximum: ", find_max(numbers))


if __name__ == "__main__":
    main()
