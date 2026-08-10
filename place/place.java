/*class hello{
public static void main (String[] args){
System.out.println("hello");
}
}
*/


/*
class Student{

int rollNumber;
String name;
String branch;

void display(){
System.out.println("rollNumber:"+ rollNumber + "name:"+  name+ "branch:"+  branch);
}
void sleep(){
System.out.println("the student is sleaping");
}

}

class hello{

public static void main(String[] args){
Student s1= new Student();
s1.rollNumber = 100;
s1.name = "sekhar";
s1.branch = "cse";
s1.display();

Student s2= new Student();
s2.rollNumber = 1100;
s2.name = "Arjun";
s2.branch = "cse-ai";
s2.display();
s1.sleep();

} 
}*/










/*class calculations{
int add(int a,int b){
return a+b;
}
int sub(int a,int b){
return a-b;
}
int mul(int a,int b){
return a*b;
}

}
class hello {
 public static void main(Stringa[] args){
  int x=10;
  int cc

}
}
*/
// QUESTION 1

/*
public class hello{
public static int add(int a, int b ){
return a+b;
}
  public static void main(String[] args){
 int num1 = 5;
int num2 = 6;
int  result = add(num1, num2); 
System.out.println("The sum is :" + result);
}
}
*/
//QUESTION 2

/*class hello{
public static void main (String[] args){
System.out.println("is even 4?" + isEven(4));
System.out.println("is even 7?" + isEven(7));
}
public static boolean isEven(int a){
return a % 2 == 0;

}
}
*/

//QUESTION 3

/*
class hello{
public static double SI(double p, double r, double t){
return (p*r*t)/100;
}
public static void main(String[] args){
 double num1 = 5;
 double num2 = 6;
 double num3 = 7;
 double result = SI(num1, num2, num3);
System.out.println("the simple interest is:" + result);
}
}
*/

//ase question
/*
class hello{

public static void main(String[] args){
 int arr[]={10,23,17,6,4};
int sum=0,avg=0; 
for(int i=0; i < arr.length; i++){
sum+=arr[i];
 avg = sum/arr.length;
}
System.out.println(sum);
System.out.println(avg);
}
}
*/

/*class hello{
public static void main(String[] args){
int arr[] = {10,23,17,6,4};
int key=6;
int low =0;
int high=arr.length-1;
while(low<=high)
{
int mid = low+(high-low)/2;
if(arr[mid]<key){
low=mid+1;
}
else if(arr[mid]>key){
high=mid-1;
}
else{
System.out.println(mid+ " index of "+key);
break;
}

}
}
}
*/
/*
class hello{
public static void main(String[] args){
 String name = "Dhanush sshdguhs iuhgijlbs uhgijehg uhgijehgiuh";
 String[] words  = name.trim().split("\\s+");
int wordCount = name.trim().isEmpty() ? 0 : words.length;
System.out.println(" word count: " + words); 
}
}
*/
/*
class WordCount {
    public static void main(String[] args) {
        String name = "Dhanush sshdguhs iuhgijlbs uhgijehg uhgijehgiuh";
        
        
        int totalWords = name.split(" ").length;
        
        System.out.println("Word count: " + totalWords);
    }
}


*/

/*class hello {
public static void main(String[] args){
String name ="dhanush";
String rev ="";
for (int i= name.length()-1; i>=0;i--){
rev = rev + name.charAt(i);
}
System.out.println(rev);
}
}*/



/*
class hello{

	public static void main(String[] args){
	String name="123@#pilenaudno&#dshiwe457";
         int alpha=0;
         int digit=0;
	}
}
*/
//QUESTION 1

/*
import java .util.Scanner;

public class void main (String[] args){

Scanner sc = ne

}

listen silent
*/

/*
import java.util.Arrays;
import java.util.Scanner;

public class hello{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();
        
        if (isAnagram(str1, str2)) {
            System.out.println("They are anagrams!");
        } else {
            System.out.println("They are NOT anagrams.");
        }
        
        scanner.close();
    }

    public static boolean isAnagram(String s1, String s2) {
      
        String cleanS1 = s1.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String cleanS2 = s2.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
      
        if (cleanS1.length() != cleanS2.length()) {
            return false;
        }
        
        
        char[] array1 = cleanS1.toCharArray();
        char[] array2 = cleanS2.toCharArray();
        
        Arrays.sort(array1);
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);
    }
}

*/
/*

public class hello {
    public static boolean isAnagram(String str1, String str2) {
      
        if (str1.length() != str2.length()) {
            return false;
        }

        // Frequency array for 256 ASCII characters
        int[] charCounts = new int[256];

       
        for (int i = 0; i < str1.length(); i++) {
            charCounts[str1.charAt(i)]++;
            charCounts[str2.charAt(i)]--;
        }

        // If all counts are zero, they are anagrams
        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";

        if (isAnagram(s1, s2)) {
            System.out.println(s1 + " and " + s2 + " are anagrams.");
        } else {
            System.out.println(s1 + " and " + s2 + " are NOT anagrams.");
        }
    }
}
*/
/*
public class hello {
    public static boolean isPalindrome(String str) {
      
        int start = 0;
        int end = str.length() - 1;

      
        while (start < end) {
            // Compare characters at both pointers
            if (str.charAt(start) != str.charAt(end)) {
                return false; // Characters don't match, not a palindrome
            }
            
            start++;
            end--;
        }

        return true; // All characters matched
    }

    public static void main(String[] args) {
        String input = "radar";

        if (isPalindrome(input)) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is NOT a palindrome.");
        }
    }
}
*/
 

/*
public class hello {
    public static void main(String[] args) {
        String input = "Hello World";
        
        int vowels = 0;
        int consonants = 0;

        // Convert the string to lowercase to handle both upper and lower case letters easily
        String str = input.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Check if the character is a valid English alphabet letter (a-z)
            if (ch >= 'a' && ch <= 'z') {
                // Check if it is a vowel
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    // If it's a letter but not a vowel, it must be a consonant
                    consonants++;
                }
            }
        }

        System.out.println("Original String: " + input);
        System.out.println("Number of vowels: " + vowels);
        System.out.println("Number of consonants: " + consonants);
    }
}
*/
/*
 class hello{
static int fact(int n){
if (n == 0 || n==1) return 1;
return n * fact(n - 1);
}
public static void main(String[] args){
System.out.println(fact(5));
}
}
*/


class place{
static int fib(int n){
if (n == 0) return 0;
if (n == 1)return 1;
return fib(n -1) + fib(n - 2);
}
public static void main(String[] args){
for(int i = 0; i < 8; i++){
System.out.println(fib(i) + " ");
}
}
}
