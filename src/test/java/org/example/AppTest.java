package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testCorrectAge()
    {
        Student student1 = new Student("Nicusor", "Dan", "M", "1986-05-16", "1860516123456");
        assertEquals(34,student1.getAge());
        //assertTrue( true );
    }

    @Test
    public void testIncorrectNameInput()
    {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Incorrect format for First Name or/and Last Name");

        Student student1 = new Student("", "Dan", "M", "1986-05-16", "1860516123456");


    }

    @Test
    public void testGender() {

        Student student1 = new Student("Nicusor", "Dan", "M", "1986-05-16", "1860516123456");
        assertEquals("M", student1.getGender());
    }

}
