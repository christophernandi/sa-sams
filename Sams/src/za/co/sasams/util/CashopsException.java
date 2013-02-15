package za.co.sasams.util;

/**
 * Base class for app exceptions.
 */
public class CashopsException extends RuntimeException {

    private String msg;

    public CashopsException() {
        msg = "";
    }

    public CashopsException(String message) {
        super(message);
        this.msg = message;
    }

    public CashopsException(String message, Throwable cause) {
        super(message, cause);
        this.msg = message;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }

}