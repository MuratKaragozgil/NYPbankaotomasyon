package bankaotomasyonu;

import java.util.Scanner;


public class Main {

    
    public static void main(String[] args) {
        
        Scanner scan=new Scanner(System.in);
        User getUser=new User();
        
        start:
       while(true){
       System.out.println("Login ekranı için 1'e basiniz :");
       System.out.println("Kayıt olmak icin 2'ye basiniz :");
       switch(scan.nextInt()){
            
            case 1:
                 System.out.print("Kullanıcı Adınızı Giriniz:");
                        getUser.setUserName(scan.next()); 
                        
                        
                    System.out.print("Sifrenizi giriniz :");
                        getUser.setPassWord(scan.next());
                        
                        
                      if(getUser.check(getUser.getUserName(),getUser.getPassWord())){ 
                          System.out.println("Giriş Başarılı!!");
                          
                          while(true){    
                          //Menu oluşturma bölümü
                      System.out.println("\nHesabınızdaki parayı görmek icin 1'e :");
                      System.out.println("Para eklemek için 2'ye :");
                      System.out.println("Para cekmek için 3'e");
                      System.out.println("Cikis yapmak icin 4'e");
                      System.out.println("Sifre degistirmek icin 5'e");
                      System.out.println("Para transferi icin ise 6'ya");
                      System.out.println("Basınız ...");
                      
                          switch(scan.nextInt()){
                          case 1:
                             getUser.showMoney(getUser.getUserName(),getUser.getPassWord());
                              break;
                          case 2:
                              System.out.print("Suanki bakiyeniz :"); 
                              getUser.showMoney(getUser.getUserName(),getUser.getPassWord());
                              System.out.print("Eklemek istediğiniz para miktarini giriniz(Sadece Sayı) :");
                              float newMoney=scan.nextFloat();
                              getUser.addMoney(getUser.getUserName(),getUser.userMoney,getUser.userMoney+newMoney);
                              
                      
                              break;
                          case 3:
                              System.out.print("Suanki bakiyeniz :");
                              getUser.showMoney(getUser.getUserName(),getUser.getPassWord());
                              System.out.print("Çekmek istediğiniz para miktarini giriniz :");
                              float getMoney=scan.nextFloat();
                              if(getMoney>getUser.userMoney){
                                  System.err.println("Yeterli bakiyeniz bulunmamaktadir!");
                                  break;
                              }
                              else{
                                  getUser.getMoney(getUser.getUserName(), getUser.userMoney,getUser.userMoney-getMoney);
                                  
                              }
                              
                              break;
                          case 4:
                              System.out.println("Cikis yaptiniz!!");
                              break start;
                          case 5:
                              System.out.print("Suanki sifrenizi giriniz:");
                              if(scan.next().equals(getUser.getPassWord())){
                                
                              System.out.print("Yeni sifrenizi giriniz :");
                              String newPassWord=scan.next();
                              System.out.print("Yeni Sifreyi tekrar giriniz :");
                             if(newPassWord.equals(scan.next())){
                                 getUser.reformation(getUser.getUserName(),getUser.getPassWord(), newPassWord);
                             }
                             else {
                                System.err.println("Sifreler uyuşmuyor!!");
                                
                             }
                              }
                              else 
                                  System.err.println("Girilen sifre yanlis !!");
                              break;
                          case 6:
                              System.out.print("Para gondermek istediğiniz kullanici adini giriniz :");
                              String transUserName=scan.next();
                              if(transUserName!=null && !transUserName.equals(getUser.getUserName())){
                                  if(getUser.check(transUserName)){
                                      getUser.showMoney(getUser.getUserName(),getUser.getPassWord());
                                      System.out.print("Gondermek istediğiniz para miktarini giriniz(Sadece Sayı):");
                                      float transMoney=scan.nextFloat();
                                      if(transMoney<=getUser.userMoney){
                                          getUser.transMoney(getUser.getUserName(), transUserName, getUser.userMoney,getUser.myMoney(transUserName) , transMoney);
                                      }
                                      else
                                          System.err.println("Bakiyeniz yetersiz !!");
                                  }
                                  else
                                      System.err.println("Boyle bir kullanici adi bulunmamaktadir!!");
                              }
                              else 
                                  System.err.println("Girilen kullanici adı kendiniz yada boş olamaz!!");
                              
                              break;
                              
                          default:
                              System.err.println("Geçersiz seçim yaptiniz :");
                              break;
                      }
                      
                   }
                       
                      
                      }
                          break;
            case 2: // yeni kullanici olusturma 
                String userName;
                System.out.print("Bir kullanici adi giriniz:"); 
                userName=scan.next(); 
                while(getUser.check(userName)){
                     System.err.println("Böyle bir kullanici adi zaten var !!"); 
                     System.out.print("Baska bir kullanici adi giriniz :");
                       userName=scan.next();
                      
                }
                
                System.out.print("Bir şifre giriniz:");
                String passWord=scan.next();
                System.out.print("Eklenecek para miktarini giriniz:");
                float money=scan.nextFloat();
                getUser.addUser(userName, passWord,money);
                 System.out.println("Basariyla oluşturuldu..");
                break;
            default: 
                System.err.println("Lütfen geçerli değerler giriniz !!");
            
        }
       
                   
       }
        
            
                
                   
                      
                     
                      
                      
                      
                      
                      
                      
                      
                      
                      
                      
           
            
            
                 
            
            
            
            
        }
        
       
    }
    

