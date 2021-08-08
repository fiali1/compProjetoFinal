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
if (c>0) {
System.out.println(a);
} else {
System.out.println(b);
}
if (a>2) {
System.out.println(b);
}
}
}
