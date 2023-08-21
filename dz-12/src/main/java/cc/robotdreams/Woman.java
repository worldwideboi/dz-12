package cc.robotdreams;

import cc.robotdreams.Man;
import cc.robotdreams.Person;

public class Woman extends Person
{
    protected  String originalLastName;

    public Woman(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        this.originalLastName = lastName;

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void registerPartnership(Man partner) {
        this.partner = partner;
        partner.partner = this;
        this.lastName = partner.lastName;
    }

    public void deregisterPartnership(boolean returnToPreviousLastName) {
        if (partner != null) {
            partner.partner = null;
            this.partner = null;
        }
        if (returnToPreviousLastName) {
            this.lastName = this.originalLastName;
        }
    }

}
