/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaotomasyonu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author murat
 */
public abstract class Money {
    
    File db=new File("/home/murat/NetBeansProjects/BankaOtomasyonu/src/bankaotomasyonu/database.txt");
    float userMoney=0;
    
    public float myMoney(String userName){
        try{
            Scanner scan=new Scanner(db);
        while(scan.hasNext()){
            if(scan.next().equals(userName)){
                if(scan.hasNext()){
                    scan.next();
                  float  myMoney=scan.nextFloat();
                  return myMoney;
                }
            }
        
    }
        }catch(FileNotFoundException e){
            System.out.println("Hata cons.'da "+e);
        }
        
        return -1;
    }
    public void showMoney(String userName,String passWord){
        
       try{
           Scanner newFileScan=new Scanner(db); 
           while(newFileScan.hasNext()){
            if(newFileScan.next().equals(userName)){
                if(newFileScan.hasNext()){
                   newFileScan.next();
                  userMoney=newFileScan.nextFloat();
                System.out.println(userName+" Paranız "+ userMoney+"TL'dir.");
            }
                
            }
            else 
                newFileScan.nextLine();
       }
       }catch(FileNotFoundException e){
            System.out.println("Dosya para bölümünde bulunamadı");
       }
        
        
       
    
    }
    public void addMoney(String userName,float value,float newvalue){
                
                try{
                   int numberoflines=0;
                   String line=null;
                    Scanner scan = new Scanner(db);
                    while(scan.hasNextLine()){
                        numberoflines++;
                        line=scan.nextLine();
                          
                    }
                    String [] database = new String[numberoflines]; // tekrar yazmak için gereken string nesnesi
                    scan.close();
                    
                    scan=new Scanner(db);
                    for(int i=0;i<numberoflines;i++){
                        database[i]=scan.nextLine();
                    }
                  
                    scan.close();
                    
                   FileOutputStream os=new FileOutputStream(db,false);
                   PrintStream ps=new PrintStream(os);
                   
                   for(int i=0;i<numberoflines;i++){
                       if(database[i].contains(userName)){
                           //System.out.println(database[i]);
                          database[i]=database[i].replace(String.valueOf(value),String.valueOf(newvalue));
                       }
                       ps.println(database[i]);
                   }
                   System.out.println(userName+" yeni bakiyeniz:"+newvalue+"TL'dir.");
                   os.close();
                   ps.close();
                   
            
                   
                }catch(FileNotFoundException e){
                    System.out.println("Hata addMoney metodunda");
                }catch(NullPointerException | IOException a){
                    System.out.println("Hata addMoney metodunda "+a);
                }
        
    }
    public void getMoney(String userName,float getvalue,float newvalue ){
            
                try{
                   int numberoflines=0;
                   String line=null;
                    Scanner scan = new Scanner(db);
                    while(scan.hasNextLine()){
                        numberoflines++;
                        line=scan.nextLine();
                          
                    }
                    String [] database = new String[numberoflines]; 
                    
                    scan.close();
                    
                    scan=new Scanner(db);
                    for(int i=0;i<numberoflines;i++){
                        database[i]=scan.nextLine();
                    }
                  
                    scan.close();
                    
                   FileOutputStream os=new FileOutputStream(db,false);
                   PrintStream ps=new PrintStream(os);
                   
                   for(int i=0;i<numberoflines;i++){
                       if(database[i].contains(userName)){
                        
                          database[i]=database[i].replace(String.valueOf(getvalue),String.valueOf(newvalue));
                       }
                       ps.println(database[i]);
                   }
                   System.out.println(userName+" yeni bakiyeniz:"+newvalue+"TL'dir.");
                   os.close();
                   ps.close();
                   
            
                   
                }catch(FileNotFoundException e){
                    System.out.println("Hata getMoney metodunda"+e);
                }catch(NullPointerException | IOException a){
                    System.out.println("Hata getMoney metodunda "+a);
                }
        
    } 
   
    public void transMoney(String userName,String transUserName,float senderMoney ,float getterMoney ,float transMoney){
        
                try{
                   int numberoflines=0;
                   String line=null;
                    Scanner scan = new Scanner(db);
                    while(scan.hasNextLine()){
                        numberoflines++;
                        line=scan.nextLine();
                          
                    }
                    String [] database = new String[numberoflines]; 
                    
                    scan.close();
                    
                    scan=new Scanner(db);
                    for(int i=0;i<numberoflines;i++){
                        database[i]=scan.nextLine();
                    }
                  
                    scan.close();
                    
                   FileOutputStream os=new FileOutputStream(db,false);
                   PrintStream ps=new PrintStream(os);
                   
                   for(int i=0;i<numberoflines;i++){
                       if(database[i].contains(userName)){
                        
                          database[i]=database[i].replace(String.valueOf(senderMoney),String.valueOf(senderMoney-transMoney));
                       }
                       else if(database[i].contains(transUserName)){
                           database[i]=database[i].replace(String.valueOf(getterMoney),String.valueOf(getterMoney+transMoney));    
                               }
                       ps.println(database[i]);
                   }
                   System.out.println(userName+" "+transMoney+"TL -> "+transUserName+" adli kullaniciya basariyla gonderilmiştir.");
                   
                   os.close();
                   ps.close();
                   
            
                   
                }catch(FileNotFoundException e){
                    System.out.println("Hata getMoney metodunda"+e);
                }catch(NullPointerException | IOException a){
                    System.out.println("Hata getMoney metodunda "+a);
                }
        
        
        
    }
}
