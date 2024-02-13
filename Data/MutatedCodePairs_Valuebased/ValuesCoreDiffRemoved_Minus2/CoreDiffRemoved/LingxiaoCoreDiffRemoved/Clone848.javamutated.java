public class Clone848 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:11871520
*  Stack Overflow answer #:18333059
*  And Stack Overflow answer#:29325825
*/
public static void main (String [] arguments) {
Scanner input = new Scanner (System.in);
String username;
double age;
String gender;
String marital_status;
int telephone_number;
Scanner one = new Scanner (System.in);
System.out.println ("Enter Name:");
username = one.next ();
System.out.println ("Name accepted " + username);
Scanner two = new Scanner (System.in);
System.out.println ("Enter Age:");
age = two.nextDouble ();
System.out.println ("Age accepted " + age);
Scanner three = new Scanner (System.in);
System.out.println ("Enter Gender:");
gender = three.next ();
System.out.println ("Gender accepted " + gender);
}

public static void main (String [] args) {
Scanner input = new Scanner (System.in);
final int valid = 6;
Scanner one = new Scanner (System.in);
System.out.println ("Enter your username: ");
String s = one.nextLine ();
{
}
System.out.println ("Username accepted: " + s);
Scanner two = new Scanner (System.in);
System.out.println ("Enter your age: ");
int a = two.nextInt ();
System.out.println ("Age accepted: " + a);
Scanner three = new Scanner (System.in);
System.out.println ("Enter your sex: ");
String sex = three.nextLine ();
System.out.println ("Sex accepted: " + sex);
}

}