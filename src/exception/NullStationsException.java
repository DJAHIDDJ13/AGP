package exception;

@SuppressWarnings("serial")
public class NullStationsException extends RuntimeException {

	public NullStationsException() {
        super("stations List is null or empty, please provide routes before searching for path");
    }
    
	
}
