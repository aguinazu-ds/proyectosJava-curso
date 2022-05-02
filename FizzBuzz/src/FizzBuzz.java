public class FizzBuzz {
    public String fizzBuzz(int number) {
        if (number%15 == 0) {
            return "FizzBuzz";
        }
        if (number%3 == 0) {
            return "Fizz";
        }
        if (number%5 == 0) {
            return "Buzz";
        }
        return Integer.toString(number);
    }
}
