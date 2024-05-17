import java.util.Scanner;


/*ashling cruz + evan eggerud, did the extra credit
05/16/2024
lab 6: recursion
*/
public class Recursion {

//    !!extra credit!!

public int calculateGCD(int a, int b) {
    if (b == 0) {
        return a;
    } else {
        return calculateGCD(b, a % b);
    }
}

public int calculateLCD(int num1, int den1, int num2, int den2) {
    int gcd = calculateGCD(den1, den2);
    int lcm = (den1 * den2) / gcd;
    return lcm;
}
/*Excercise_ 1: What does the following code do?
//it adds the integer a, b times
*/
public int mystery(int a, int b) {
    if (b == 1) {
         return a;
    } else {
         return a + mystery(a, b - 1);
        }
    }
/* what is wrong with this code?
it needs a n + 1 or n -1 or another way to incriment so it doesnt loop forever

 public int sum(int n) { 
     if (n == 0) {            
        return 0;          
     } 
    else {    
    return n + sum(n);   
       }   
    }
*/
// calculates the power of the given base to the given exponent
public void power(int base, int exponent) {
    if (exponent == 1) {
        System.out.print(base);
        } else {
     System.out.print(base + "x");
     power(base, exponent - 1);
        }
    }
    //pascals triangle
    public void triangle(int n) {
    for (int line = 1; line <= n; line++) {
        printSpaces(n - line);
         printRow(line);
        System.out.println();
        }
    } 
     private void printRow(int num) {
            int value = 1;
            for (int i = 1; i <= num; i++) {
                System.out.print(value + " ");
                value = value * (num - i) / i;
            }
        }
    
    private void printSpaces(int spaces) {
            for (int i = 0; i < spaces; i++) {
                System.out.print(" ");
            }
        }
    public static void main(String[] args) {
        System.out.println("testing methods: mystery and power");
        Recursion recursion = new Recursion();
        System.out.println(recursion.mystery(5, 4));
        recursion.power(2, 2);
        System.out.println();
        recursion.power(3, 5);
        System.out.println();
        // take in user input for method power
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter base: ");
        int base = scanner.nextInt();
        System.out.print("Enter exponent: ");
        int exponent = scanner.nextInt();
        recursion.power(base, exponent);
        //calculate value
        int value = base;
        for (int i = 1; i < exponent; i++) {
            value *= base;
        }
        System.out.println(" Value is " + value);
        // get user input for triangle rows
        System.out.print("Enter rows for triangle: ");
        int rows = scanner.nextInt();
        recursion.triangle(rows);
        //calculate LCD
        System.out.println("testing LCD... ");
        recursion.calculateLCD(4, 8, 5, 8);
        System.out.print("Enter numerator 1: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter numerator 2: ");
        int num2 = scanner.nextInt();
        System.out.print("Enter denominator 1 : ");
        int num3 = scanner.nextInt();
        System.out.print("Enter denominator 2: ");
        int num4 = scanner.nextInt();
        int result = recursion.calculateLCD(num1, num1, num2, num2);
        System.out.println(result);
        // close scanner
        scanner.close();
    }
}

