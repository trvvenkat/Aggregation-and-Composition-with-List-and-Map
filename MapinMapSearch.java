import java.io.*;
import java.util.*;
 
// student class
class Student 
{
    String name;
    int id ;
    String dept;
     
    Student(String name, int id, String dept) 
    {
         
        this.name = name;
        this.id = id;
        this.dept = dept;
         
    }
}
 
/* Department class contains list of student
Objects. It is associated with student
class through its Object(s). */
class Department 
{
     
    String name;
    private TreeMap<Integer,Student> students;
    Department(String name, TreeMap<Integer,Student> students) 
    {
         
        this.name = name;
        this.students = students;
         
    }
     
    public TreeMap<Integer, Student> getStudents() 
    {
        return students;
    }
}
 
/* Institute class contains list of Department
Objects. It is asoociated with Department
class through its Object(s).*/
class Institute 
{
     
    String instituteName;
    private TreeMap<Integer, Department> departments;
     
    Institute(String instituteName, TreeMap<Integer,Department> departments)
    {
        this.instituteName = instituteName;
        this.departments = departments;
    }
     
    // count total students of all departments
    // in a given institute 
    public int getTotalStudentsInInstitute()
    {
        int noOfStudents = 0;
        TreeMap<Integer,Student> students; 
        for(Map.Entry<Integer, Department> depts:departments.entrySet())
        {
            Department dept = depts.getValue();
            students = dept.getStudents();
            for(Map.Entry<Integer, Student> stds:students.entrySet())
            {
                noOfStudents++;
                Student stu = stds.getValue();
                System.out.println("Department : "+stu.dept+" Id : "+stu.id+" Name : "+stu.name);
            }
        }
        return noOfStudents;
    }

    public void searchDepartment(String depart)
    {
        TreeMap<Integer,Student> studen; 
        for(Map.Entry<Integer, Department> depts:departments.entrySet()){
            Department dt=depts.getValue();
            if(depart==dt.name)
            {
                studen = dt.getStudents();
                for(Map.Entry<Integer, Student> stds:studen.entrySet())
                {
                    Student stu = stds.getValue();
                    System.out.println("Department : "+stu.dept+" Id : "+stu.id+" Name : "+stu.name);
                }
            }
        }
    }
     
} 
 
// main method
class MapinMapSearch
{
    public static void main (String[] args) 
    {
        Student s1 = new Student("Mia", 1, "CSE");
        Student s2 = new Student("Priya", 2, "CSE");
        Student s3 = new Student("John", 1, "EE");
        Student s4 = new Student("Rahul", 2, "EE");
     
        // making a MAP of 
        // CSE Students.
        TreeMap <Integer, Student> cse_students = new TreeMap<Integer,Student>();
        cse_students.put(1,s1);
        cse_students.put(2,s2);
         
        // making a MAP of 
        // EE Students
        TreeMap <Integer,Student> ee_students = new TreeMap<Integer,Student>();
        ee_students.put(1,s3);
        ee_students.put(2,s4);
         
        Department CSE = new Department("CSE", cse_students);
        Department EE = new Department("EE", ee_students);
        
        TreeMap <Integer,Department> departments = new TreeMap<Integer, Department>();
        departments.put(1,CSE);
        departments.put(2,EE);
         
        // creating an instance of Institute.
        Institute institute = new Institute("BITS", departments);
        //int n = institute.getTotalStudentsInInstitute();
        //System.out.print("Total students in institute: "+n);
        institute.searchDepartment("EE");
    }
}