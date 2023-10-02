package org.launchcode.techjobs.oo;

import org.junit.Test;

import static java.lang.System.lineSeparator;
import static org.junit.jupiter.api.Assertions.*;


public class JobTest {

    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId () {
       Job test_job1 = new Job();
       Job test_job2 = new Job();
       assertNotEquals(test_job1.getId(), test_job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields () {
        Job test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("Product tester", test_job3.getName());
        assertEquals("ACME", test_job3.getEmployer().getValue());
        assertEquals("Desert", test_job3.getLocation().getValue());
        assertEquals("Quality control", test_job3.getPositionType().getValue());
        assertEquals("Persistence", test_job3.getCoreCompetency().getValue());

        assertTrue(test_job3 instanceof Job);
        assertTrue(test_job3.getEmployer() instanceof Employer);
        assertTrue(test_job3.getLocation() instanceof Location);
        assertTrue(test_job3.getPositionType() instanceof PositionType);
        assertTrue(test_job3.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job test_job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job test_job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(test_job4.equals(test_job5));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine () {
        Job test_job6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String stringJob = "\n" + "ID: " + test_job6.getId() + "\n" +
                "Name: " + test_job6.getName() + "\n" +
                "Employer: " + test_job6.getEmployer() + "\n" +
                "Location: " + test_job6.getLocation() + "\n" +
                "Position Type: " + test_job6.getPositionType() + "\n" +
                "Core Competency: " + test_job6.getCoreCompetency() + "\n";
        assertEquals(stringJob.charAt(0), test_job6.toString().charAt(0));
        assertEquals(stringJob.charAt(stringJob.length()-1), test_job6.toString().charAt(test_job6.toString().length()-1));
//        assertEquals("\n", test_job6.toString().charAt(0));
//        assertEquals("\n", test_job6.toString().charAt(test_job6.toString().length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData () {
        Job test_job7 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String stringJob = "\n" + "ID: " + test_job7.getId() + "\n" +
                "Name: " + test_job7.getName() + "\n" +
                "Employer: " + test_job7.getEmployer() + "\n" +
                "Location: " + test_job7.getLocation() + "\n" +
                "Position Type: " + test_job7.getPositionType() + "\n" +
                "Core Competency: " + test_job7.getCoreCompetency() + "\n";
        assertEquals(stringJob, test_job7.toString());
    }

    @Test
    public void testToStringHandlesEmptyField () {
        Job test_job8 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType(""), new CoreCompetency("Persistence"));
        String stringJob = "\n" + "ID: " + test_job8.getId() + "\n" +
                "Name: " + test_job8.getName() + "\n" +
                "Employer: " + "Data not available" + "\n" +
                "Location: " + test_job8.getLocation() + "\n" +
                "Position Type: " + "Data not available" + "\n" +
                "Core Competency: " + test_job8.getCoreCompetency() + "\n";
        assertEquals(stringJob, test_job8.toString());
    }

}
