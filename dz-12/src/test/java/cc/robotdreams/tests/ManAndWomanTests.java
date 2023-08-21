package cc.robotdreams.tests;
import cc.robotdreams.Man;
import cc.robotdreams.Woman;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
      public class ManAndWomanTests {

        private enum ExpectedStatus
        {
         PASSED,
         FAILED
        }

        @DataProvider
        public Object[][] DataMan() {
            return new Object[][]{
                    {ExpectedStatus.PASSED,"Joe","Doe", 70},
                    {ExpectedStatus.PASSED,"Alex","Fun", 65}
            };
        }

        @Test(dataProvider = "DataMan")
    public void testIsRetiredMan(ExpectedStatus status, String firstName, String lastName,Integer age) {
            if(status == ExpectedStatus.PASSED){
                Man john = new Man(firstName, lastName, age);
                Assert.assertTrue(john.isRetired());
                john.setAge(50);
                Assert.assertFalse(john.isRetired());
            }

    }

    @DataProvider
    public Object[][] DataWoman() {
        return new Object[][]{
                {ExpectedStatus.PASSED,"Jane", "Smith", 65},
                {ExpectedStatus.PASSED,"Kim","Kardashian", 62}
        };
    }

    @Test(dataProvider = "DataWoman")
    public void testIsRetiredWoman(ExpectedStatus status, String firstName, String lastName,Integer age) {
        if(status == ExpectedStatus.PASSED) {
            Woman jane = new Woman(firstName, lastName, age);
            Assert.assertTrue(jane.isRetired());
            jane.setAge(55);
            Assert.assertFalse(jane.isRetired());
        }
    }

    @DataProvider
    public Object[][] DataTestRegisterPartnership() {
        return new Object[][]{
                {ExpectedStatus.PASSED,
                        "John", "Doe", 30,
                        "Jane", "Smith", 28},

                {ExpectedStatus.PASSED,
                        "Oleg", "Volkov", 30,
                        "Slava", "Ukraine", 28}
        };
    }

    @Test(dataProvider = "DataTestRegisterPartnership")
    public void testRegisterPartnership (ExpectedStatus status,
                                         String manFirstName, String manLastName, Integer manAge,
                                         String womanFirstName, String womanLastName, Integer womanAge) {
        if(status == ExpectedStatus.PASSED) {
            Man john = new Man(manFirstName,manLastName,manAge);
            Woman jane = new Woman(womanFirstName, womanLastName,womanAge);

            john.registerPartnership(jane);

            Assert.assertEquals(john.getPartner(), jane);
            Assert.assertEquals(jane.getPartner(), john);
            Assert.assertEquals(john.getLastName(), jane.getLastName());
        }
    }
    @DataProvider
    public Object[][] DataTestDeregisterPartnership() {
        return new Object[][]{
                {ExpectedStatus.PASSED,
                        "John", "Doe", 32,
                        "Jane", "Smith", 29},

                {ExpectedStatus.PASSED,
                        "Oleg", "Volkov", 31,
                        "Slava", "Ukraine", 28}
        };
    }

    @Test(dataProvider = "DataTestDeregisterPartnership")
    public void testDeregisterPartnership(ExpectedStatus status,
                                          String manFirstName, String manLastName, Integer manAge,
                                          String womanFirstName, String womanLastName, Integer womanAge) {
        if(status == ExpectedStatus.PASSED) {

            Man john = new Man(manFirstName, manLastName, manAge);
            Woman jane = new Woman(womanFirstName, womanLastName, womanAge);

            john.registerPartnership(jane);

            Assert.assertEquals(john.getPartner(), jane);
            Assert.assertEquals(jane.getPartner(), john);
            Assert.assertEquals(john.getLastName(), jane.getLastName());

            jane.deregisterPartnership(true);

            Assert.assertEquals(john.getPartner(), null);
            Assert.assertEquals(john.getLastName(), manLastName);
            Assert.assertEquals(jane.getPartner(), null);
            Assert.assertEquals(jane.getLastName(), womanLastName);
        }
    }
    @DataProvider
    public Object[][] DataTestSetAge() {
        return new Object[][]{
                {ExpectedStatus.PASSED,"John", "Doe", 13},

                {ExpectedStatus.PASSED,"Misha", "Mudrik", 16}
        };
    }
    @Test(dataProvider = "DataTestSetAge")
    public void testSetAge(ExpectedStatus status, String firstName, String lastName,Integer age){
        if(status == ExpectedStatus.PASSED) {
            Man john = new Man(firstName, lastName, age);
            john.setAge(15);
            Assert.assertEquals(john.getAge(), Integer.valueOf(15));
        }
    }



}