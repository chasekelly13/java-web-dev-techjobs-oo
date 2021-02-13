package test;


import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    private Job job1, job2, job3, job4;

    @Before
    public void createJobObjects() {
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality " +
                "control"), new CoreCompetency("Persistence"));
        job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality " +
                "control"), new CoreCompetency("Persistence"));
    }

    //First test: testing "Each Job object should contain a unique ID number, and these should also be sequential
    // integers."
    @Test
    public void testSettingJobId() {
        assertEquals(job1.getId() + 1, job2.getId(), .001);
    }

    //Second test: testing "Each Job object should contain six fields—id, name, employer, location, positionType, and
    // coreCompetency. The data types for these fields are int, String, Employer, Location, PositionType, and
    // CoreCompetency, respectively."
    @Test
    public void testJobConstructorSetsAllFields() {
        //asserting that each constructor is assigned correctly
        assertEquals("Product tester", job3.getName());
        assertEquals("ACME", job3.getEmployer().getValue());
        assertEquals("Desert", job3.getLocation().getValue());
        assertEquals("Quality control", job3.getPositionType().getValue());
        assertEquals("Persistence", job3.getCoreCompetency().getValue());
        //asserting that each data type is for the fields is the correct class
        assertTrue(job3.getName() instanceof String);
        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
    }

    //Third test: testing "Two Job objects are considered equal if they have the same id value, even if one or more
    // of the other fields differ. Similarly, the two objects are NOT equal if their id values differ, even if all
    // the other fields are identical."
    @Test
    public void testJobsForEquality() {
        assertFalse(job4.equals(job3));
    }

    //Fourth test: testing: "When passed a Job object, it should return a string that contains a blank line before and after the job information."

    @Test
    public void testFirstAndLastLineBlank(){
        char firstChar = job3.toString().charAt(0);
        char lastChar = job3.toString().charAt(job3.toString().length()-1);
        assertTrue(firstChar == lastChar);
    }

    //Fifth test: testing: The string should contain a label for each field, followed by the data stored in that field.
    @Test
    public void testValuesAreAssignedProperly(){
        String string = ("\n" + "ID: " + job3.getId() + "\n" +
                "Name: " + job3.getName() + "\n" +
                "Employer: " + job3.getEmployer() +"\n" +
                "Location: " + job3.getLocation() + "\n" +
                "Position Type: " + job3.getPositionType() + "\n" +
                "Core Competency: " + job3.getCoreCompetency() + "\n");
        assertEquals(string, job3.toString());
    }

    //Sixth test: testing: If a field is empty, the method should add, “Data not available” after the label.
    @Test
    public void testIfEmptyValuesHoldDataNotAvailable(){
        job3.setName("");
        job3.getEmployer().setValue("");
        job3.getLocation().setValue("");
        job3.getPositionType().setValue("");
        job3.getCoreCompetency().setValue("");
        String string = ("\n" + "ID: " + job3.getId() + "\n" +
                "Name: " + "Data not available" + "\n" +
                "Employer: " + "Data not available" +"\n" +
                "Location: " + "Data not available" + "\n" +
                "Position Type: " + "Data not available" + "\n" +
                "Core Competency: " + "Data not available" + "\n");
        assertEquals(string, job3.toString());
    }

}
