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
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author murat
 */
public class User extends Money implements LoginMethods {
    private String userName;
    private String passWord;
    
File f=new File("/home/murat/NetBeansProjects/BankaOtomasyonu/src/bankaotomasyonu/database.txt"); 
   
    
    @Override
    public boolean check(String userName , String passWord) {
        if(userName == null ? passWord == null : userName.equals(passWord)){
            System.out.println("Kullanıcı adı ile şifre aynı olamaz!!");
            return false; 
        }
        else{    
           try{
               Scanner fileScan=new Scanner(f);
            while(fileScan.hasNext()){
                if(fileScan.next().equals(userName)){
                    if(fileScan.next().equals(passWord)){
                        
                        return true;
                    }
                     
                       
                  }
                else
                {   
                    
                    fileScan.hasNextLine();
                }
                
            }
           }catch(FileNotFoundException e){
               System.out.println("Dosya bulunamadı");
           }
                    this.userName=null;         //tekrar aynı degerlerin olmasini onlemek icin null yapıyoruz.
                    this.passWord=null;
                    
                    System.err.println("Yanlış Giriş Yaptiniz !!");
                    return false;
                
       } 
        
        
    }
    //Doğum günü tarihi hesap türü gibi şeyler buraya eklenebilir.
    @Override
    public void addUser(String userName , String passWord,float money) {        
        if(userName!=null&&passWord!=null){
          try{
            OutputStream os=new FileOutputStream(f,true);
            PrintStream ps=new PrintStream(os);
            ps.println(userName+" "+passWord+" "+money);
            
        } catch (FileNotFoundException ex) {
            System.err.println("Hata User.addUser metodunda"+ex);
        }  
  
        }
        else {
            System.err.println("Geçersiz bilgi girdiniz...Kullanici adı veya şifre boş olamaz!!");
        }
        
        
    }

    @Override
    public void reformation(String userName,String passWord,String newPassWord) {
        if(newPassWord!=null && !newPassWord.equals(passWord))
        {
            
            try{
                   int numberoflines=0;
                   String satir=null;
                    Scanner scanner = new Scanner(f);
                    while(scanner.hasNextLine()){
                        numberoflines++;
                        satir=scanner.nextLine();
                          
                    }
                    String [] database = new String[numberoflines]; 
                    scanner.close();
                    
                    scanner=new Scanner(f);
                    for(int i=0;i<numberoflines;i++){
                        database[i]=scanner.nextLine();
                    }
                  
                    scanner.close();
                    
                   FileOutputStream os=new FileOutputStream(f,false);
                   PrintStream ps=new PrintStream(os);
                   
                   for(int i=0;i<numberoflines;i++){
                       if(database[i].contains(userName)){
                        
                          database[i]=database[i].replace(String.valueOf(passWord),String.valueOf(newPassWord));
                       }
                       ps.println(database[i]);
                   }
                   System.out.println(userName+" yeni sifreniz:"+newPassWord+"'dir.");
                   os.close();
                   ps.close();
                   
            
                   
                }catch(FileNotFoundException e){
                    System.out.println("Hata reformation metodunda"+e);
                }catch(NullPointerException | IOException a){
                    System.out.println("Hata reformation metodunda "+a);
                }
        
    }
        else 
            System.out.println("Sifre boş yada eskisiyle aynı olamaz !!");
        
        }
    
    @Override
    public boolean check(String userName){
        try{
           Scanner scan=new Scanner(f); 
           while(scan.hasNext()){
               if(scan.next().equals(userName)){
                   return true ;
               }else{
                   scan.nextLine();
               }
           }
        }catch(FileNotFoundException e){
            System.out.println("Hata user chech tek parametreli metotda "+e);
        }
        return false;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
   
}
