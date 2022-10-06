package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode ** finished by Crishawna Nash
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job job = new Job();
        Job job2 = new Job();
        assertNotEquals(job.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job jobCT = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(jobCT instanceof Job);
        assertTrue(jobCT.getEmployer() instanceof Employer);
        assertTrue(jobCT.getLocation() instanceof Location);
        assertTrue(jobCT.getPositionType() instanceof PositionType);
        assertTrue(jobCT.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", jobCT.getName());
        assertEquals("ACME", jobCT.getEmployer().getValue());
        assertEquals("Desert", jobCT.getLocation().getValue());
        assertEquals("Quality control", jobCT.getPositionType().getValue());
        assertEquals("Persistence", jobCT.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job jobEq = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobEq2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(jobEq2.equals(jobEq));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job jobST = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        char line[] = jobST.toString().toCharArray();

        assertEquals('\n', line[line.length-1]);
        assertEquals('\n', line[0]);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job jobRT = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String response ="\nID: " + jobRT.getId() + "\nName: " + jobRT.getName() + "\nEmployer: " + jobRT.getEmployer() + "\nLocation: " + jobRT.getLocation() + "\nPosition Type: " + jobRT.getPositionType() + "\nCore Competency: " +jobRT.getCoreCompetency() + "\n";

        assertEquals(jobRT.toString(), response);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job jobEmpt = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

        assertEquals(jobEmpt.toString(),String.valueOf(jobEmpt));
        assertTrue(jobEmpt.getEmployer().getValue()=="Data not available");
        assertTrue(jobEmpt.getLocation().getValue()=="Data not available");
        assertTrue(jobEmpt.getCoreCompetency().getValue()=="Data not available");
        assertTrue(jobEmpt.getPositionType().getValue()=="Data not available");
        assertEquals(String.valueOf(jobEmpt),jobEmpt.toString());
    }

}
