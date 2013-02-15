package za.co.sasams.test;

/**
 * Created by IntelliJ IDEA.
 * User: magwa
 * Date: 2012/09/09
 * Time: 6:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class SubClass extends SuperClass{
    private String subName;
    private SuperClass superClass;

    public SuperClass getSuperClass() {
        return superClass;
    }

    public void setSuperClass(SuperClass superClass) {
        this.superClass = superClass;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }


}
