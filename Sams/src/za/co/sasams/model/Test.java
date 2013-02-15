package za.co.sasams.model;

/**
 * Created by IntelliJ IDEA.
 * User: magwa
 * Date: 2012/09/09
 * Time: 3:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    private int id;
    private String name;
    private String lastName;

    public Test(int id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
