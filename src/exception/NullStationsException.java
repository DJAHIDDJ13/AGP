package exception;

@SuppressWarnings("serial")
public class NullStationsException extends RuntimeException {
	private static final long serialVersionUID = 737017952456045259L;

	public NullStationsException() {
        super("Stations List is null or empty, please provide routes before searching for path");
    }
    
	
}
