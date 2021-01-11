public class Tester{
  public static void main(String[]args){
    System.out.println("---TESTING NTH---");
    System.out.println(Radix.nth(123,1));
    System.out.println(Radix.nth(-123,1));
    System.out.println(Radix.nth(123,2));
    System.out.println(Radix.nth(-123,2));
    System.out.println(Radix.nth(-123,0));
    System.out.println(Radix.nth(0,2));
    System.out.println(Radix.nth(0,0));

    System.out.println("---TESTING LENGTH---");
    System.out.println(Radix.length(0));
    System.out.println(Radix.length(15));
    System.out.println(Radix.length(-10));
    System.out.println(Radix.length(5112));

    System.out.println("---TESTING MERGE---");
    MyLinkedList y=new MyLinkedList();
    //y.add("4"); y.add("5");
    System.out.println(y);
    MyLinkedList z=new MyLinkedList();
    z.add("6"); z.add("7");
    System.out.println(z);
    MyLinkedList[]bucketsTest={y,z};
    MyLinkedList x=new MyLinkedList();
    x.add("1"); x.add("2"); x.add("3");
    System.out.println(x);
    Radix.merge(x,bucketsTest);
    System.out.println(x);
  }
}
