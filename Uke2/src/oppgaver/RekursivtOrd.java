package oppgaver;


public class RekursivtOrd {
public static void main(String[] args) {
System.out.println(kall(4));
}
public static String kall(int i) {
if (i == 1) {
System.out.println(1);
return "se";
}
else {
if (i != 2) {
System.out.println(2);
return "erv" + kall(i - 1);
}
}
System.out.println(3);
return "el" + kall(i - 1);
}
}
