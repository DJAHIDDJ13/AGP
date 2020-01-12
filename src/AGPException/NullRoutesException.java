package AGPException;

public class NullRoutesException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NullRoutesException() {
        super("routes List is null or empty, please provide routes before searching for path");
    }
    
}
