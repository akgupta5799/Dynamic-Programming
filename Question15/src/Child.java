class Parent {
    static void check(){
        System.out.println("Parent");
    }
 }
 
 public class Child extends Parent{
     static void test(){
      System.out.println("Child");
     }
 
 
 public static void main(String[] args){
     Parent p = new Child();
     ((Child)p).test();
 }
 }