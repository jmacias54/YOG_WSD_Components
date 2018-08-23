/**
 * 
 */
package mx.com.amx.yog.components.wsd.dao.exception;

/**
 * @author Jesus A. Macias Benitez
 *
 */
public class DAOException extends Exception{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new n nota DAO exception.
	 */
	public DAOException() {
		super();
	}

	/**
	 * Instantiates a new n nota DAO exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new n nota DAO exception.
	 *
	 * @param message the message
	 */
	public DAOException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new n nota DAO exception.
	 *
	 * @param cause the cause
	 */
	public DAOException(Throwable cause) {
		super(cause);
	}

}
