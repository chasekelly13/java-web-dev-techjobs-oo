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



}
