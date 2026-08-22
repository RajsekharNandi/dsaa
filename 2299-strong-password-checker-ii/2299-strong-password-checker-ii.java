import java.util.*;
class Solution {
    public boolean strongPasswordCheckerII(String password) 
    {
       if(password.length()< 8)
        return false;
         boolean up = false;
         boolean lw = false;
         boolean nu = false;
         boolean sp = false;
         String spacial = "!@#$%^&*()-+";
         
        for (int i = 0; i < password.length(); i++)
         { 
            if (i > 0 && password.charAt(i) == password.charAt(i - 1))
                return false;       
            if (Character.isUpperCase(password.charAt(i)))
                up = true;
            else if (Character.isLowerCase(password.charAt(i)))
                lw = true;
            else if (Character.isDigit(password.charAt(i)))
                nu = true; 
            
            else if (spacial.indexOf(password.charAt(i)) != -1)
                sp = true;
        }


    
          if (up == true && lw == true && nu == true && sp == true){
            return true;
        }
        else{
        return false;
        }
    }
}