import java.util.Scanner;
public class MainClass {
public static void main(String args[]) {
Scanner _key = new Scanner(System.in);
double a;
double b;
String c;
a = _key.nextDouble();
_key.nextLine();
b = _key.nextDouble();
_key.nextLine();
c = _key.nextLine();
do {
System.out.println(a);
System.out.println(b);
System.out.println(c);
} while (a<1);
}
}
