package cc.robotdreams;

public class Man extends Person
{
    public Man(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void registerPartnership(Woman partner)
    {
        this.partner = partner;
        partner.partner = this;
        partner.lastName = lastName;
    }

    public void deregisterPartnership() {
        if (partner != null) {
            partner.partner = null;
            this.partner = null;
        }
    }

}
