package co.sasams.test;

import za.co.sasams.service.Food;

/**
 * Created by IntelliJ IDEA.
 * User: magwa
 * Date: 2012/09/09
 * Time: 9:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class Apple extends Food{
    private String appleName;

    protected String getAppleName() {
        return appleName;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }
}
