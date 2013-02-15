package za.co.sasams.util;

/**
 * Created by IntelliJ IDEA.
 * User: root
 * Date: 2012/08/18
 * Time: 6:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class SamsException extends RuntimeException {
    private String name;

    public SamsException(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
