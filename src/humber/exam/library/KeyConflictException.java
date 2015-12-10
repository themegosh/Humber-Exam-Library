package humber.exam.library;

public class KeyConflictException extends Exception {
	private final String msg;
	
	public KeyConflictException(){
		msg = "There was a key conflict with your insert statement.";
	}
}