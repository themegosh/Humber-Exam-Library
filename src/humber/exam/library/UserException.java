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
    	private final String msg;

        public UserException(){
		msg = "Incorrect user name.";
	}
        
}

