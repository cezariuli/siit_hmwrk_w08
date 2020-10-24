package org.example;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    //static final Logger logger = LogManager.getLogger(App.class.getName());
    List<Student> students = new ArrayList<Student>();

    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
    }

    public void addStudent(Student student) {
        try {
            students.add(student);
        } catch (IllegalArgumentException e) {
            //nothing to do
         } catch (IndexOutOfBoundsException e) {
            //nothing to do
        }
    }

    public void deleteStudent(String id) {
        if ( id == "" ) {
            throw new IllegalArgumentException("Argument ID is empty");
        }

        for (Student s: students) {
            if (s.getId().equals(id)) {
                students.remove(s);
            }
        }
    }

    public List<Student> retrieveStudentsByAge(int age) {
        List<Student> tempList = new ArrayList<Student>();

        for(Student s: students) {
            if (age == s.getAge()) {
                tempList.add(s);
            }
        }

        return tempList;
    }
}
