
package Gym;


public class Calculate {
   private final String gymC;
    private final String SwimmingC;
   private final String GoldC;
    

static  double child = 0.50;
static  double adult=0.1 ;
static double student= 0.3;
static double result = 0;
public Calculate(String m,String p,String f){
    this.gymC=m;
    this.SwimmingC=p;
    this.GoldC=f;
    
}

  
 
public double GymResult(){
    
result =35-(35*child);      
return result;
}
public double GymResultA(){
    
result = 35;      
return result;
}
public double GymResultS(){
    
result = 35-(35*student);      
return result;
}

public double SwimmingResult(){
   
result = 55-(55*child);      
return result;
}
public double SwimmingResultA(){
   
result = 55;      
return result;
}
public double SwimmingResultS(){
    
result =55-(55*student);      
return result;
}

public double GoldResult(){

result = 100-(100*child);      
return result;
}
public double GoldResultA(){
    
result = 100;      
return result;
}
public double GoldResultS(){
    
result = 100-(100*student);      
return result;
}


}