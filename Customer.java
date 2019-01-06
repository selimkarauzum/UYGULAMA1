/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gym;

import javax.swing.ButtonModel;
import javax.swing.JLabel;

public class Customer {

private int userıd;
private String name;
private String surname;
private String sex;
private String trip;
private String gym;
private String start;
private String end;
private String customer;
private String pay;

    
  



Customer(int userıd,String name,String surname,String sex,String trip,String gym,String start,String end,String cus,String pay){

this.userıd=userıd;    
this.name=name;
this.surname=surname;
this.sex=sex;
this.trip=trip;
this.gym=gym;
this.start=start;
this.end=end;
this.customer=cus;
this.pay=pay;

}

  
public void setSex(String s){
this.sex=s;
}
public String getSex(){
return this.sex;
}
public void setTrip(String trip){
this.trip=trip;
}
public String gettrip(){
return this.trip;
}


public void setGym(String k){
this.gym=k;
}
public String getGym(){
return this.gym;
}

public void setStart(String start){
this.start=start;
}
public String getStart(){
return this.start;
}
public void setEnd(String end){
this.end=end;
}
public String getEnd(){
return this.end;
}
public void setCustomer(String customer){
this.customer=customer;
}
public String getCustomer(){
return this.customer;
}
public void setPay(String pay){
this.pay=pay;
}
public String getPay(){
return this.pay;
}
public void setName(String n){
this.name=n;
}
public String getName(){

return this.name;
}
public void setSurname(String m){

this.surname=m;
        
}    
public String getSurname(){

return this.surname;
}

public int getUserId(){
return this.userıd;
}





}
