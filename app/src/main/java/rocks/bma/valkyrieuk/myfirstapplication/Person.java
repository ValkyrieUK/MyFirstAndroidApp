package rocks.bma.valkyrieuk.myfirstapplication;

import java.io.Serializable;

/**
 * Created by valkyrieuk on 15/09/2015.
 */
public class Person implements Serializable {
    private String name = "";
    private String address = "";


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
