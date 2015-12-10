/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humber.exam.library;

/**
 *
 * @author Hau
 */
public class UserException extends Exception{
    String msg;
    public UserException(String msg){
        super(msg);
        this.msg = msg;
    }
    
    public String getMsg(){
        return msg;
    }
}

