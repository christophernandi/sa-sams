package za.co.sasams.test;

/**
 * Created by IntelliJ IDEA.
 * User: magwa
 * Date: 2012/09/09
 * Time: 6:50 PM
 * To change this template use File | Settings | File Templates.
 */

public class SuperClass{
    private String name1;
    private String name2;
    private String name3;

    protected String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }
}
