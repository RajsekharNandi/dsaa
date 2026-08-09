class Pen {
    String colour;
    String type;
    public void write(){
    System.out.println("writing something");
    }
    public void printColour(){
        System.out.println(this.colour);  //this keword is used to refer to the current object 
    }
}
     class Student {
     String name;
     int age;
public void printInfo(){
    System.out.println(this.name);
    System.out.println(this.age);
}
Student(Student s2) {
    this.name = s2.name;
    this.age = s2.age;
}
Student(){
    
}
     }
public class OOP{
    public static void main(String args[]){
       Student s1 = new Student();//constructor
       //property 1.constructor name and class name same,2.it cannot return anything. 3.we can call 1 time.
       s1.name = "aman";
       s1.age = 19;
       Student s2 = new Student(s1);
       s2.printInfo();
    }
}
