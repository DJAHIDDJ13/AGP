package exception;

public class NullStationsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NullStationsException() {
        super("stations List is null or empty, please provide routes before searching for path");
    }
    
	
}
