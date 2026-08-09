//Compile polimorfism
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

class Student{
    String name;
    int age;

   public void printInfo(String name) {
   System.out.println(name);
  }

  public void printInfo(String age){
  printInfo(age);
  }
  public void printInfo(String name, int age){
    System.out.println(name + " " + age);
  }

}


public class polimorfism {
 public static void main(String args[]){
    Student s1 = new Student();
s1.name = "amman";
s1.age = 19;

s1.printInfo(s1.age);
}   
}
