/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaotomasyonu;

/**
 *
 * @author murat
 */
interface LoginMethods {
    boolean check(String userName);
    boolean check(String userName,String passWord);
    void addUser(String userName,String passWord,float money);
    void reformation(String userName,String passWord,String newPassWord);
}
