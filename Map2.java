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
     
    String instituteName, universityname;
    private TreeMap<Integer, Department> departments;
     
    Institute(String universityname ,String instituteName, TreeMap<Integer,Department> departments)
    {
        this.universityname = universityname;
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

    public TreeMap<Integer, Department> getDepartments() 
    {
        return departments;
    }
     
}

class University
{
    String universityname;
    private TreeMap<Integer, Institute> institutes;
    University(String universityname, TreeMap<Integer, Institute> institutes)
    {
        this.universityname = universityname;
        this.institutes = institutes;
    }

    public void searchInstitute(String inst)
    {
        TreeMap<Integer,Student> studen;
        TreeMap<Integer,Department> departm;
        for(Map.Entry<Integer, Institute> insts:institutes.entrySet()){
            Institute ins=insts.getValue();
            if(inst==ins.instituteName)
            {
                System.out.println(ins.instituteName+" : \n");
                departm = ins.getDepartments();
                for(Map.Entry<Integer, Department> dept:departm.entrySet())
                {
                    Department dt = dept.getValue();
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
}
 
// main method
class Map2
{
    public static void main (String[] args) 
    {
        Student s1 = new Student("Mia", 1, "CSE");
        Student s2 = new Student("Priya", 2, "CSE");
        Student s3 = new Student("John", 1, "EE");
        Student s4 = new Student("Rahul", 2, "EE");

        Student s5 = new Student("Venkat", 1, "CSE");
        Student s6 = new Student("Saranya", 2, "CSE");
        Student s7 = new Student("Sathya", 1, "EE");
        Student s8 = new Student("Sharma", 2, "EE");
     
        // making a MAP of 
        // CSE Students.
        TreeMap <Integer, Student> cse_students = new TreeMap<Integer,Student>();
        cse_students.put(1,s1);
        cse_students.put(2,s2);

        TreeMap <Integer, Student> cse_students1 = new TreeMap<Integer,Student>();
        cse_students1.put(1,s5);
        cse_students1.put(2,s6);
         
        // making a MAP of 
        // EE Students
        TreeMap <Integer,Student> ee_students = new TreeMap<Integer,Student>();
        ee_students.put(1,s3);
        ee_students.put(2,s4);

        TreeMap <Integer,Student> ee_students1 = new TreeMap<Integer,Student>();
        ee_students1.put(1,s7);
        ee_students1.put(2,s8);
         
        Department CSE = new Department("CSE", cse_students);
        Department EE = new Department("EE", ee_students);

        Department CSE1 = new Department("CSE", cse_students1);
        Department EE1 = new Department("EE", ee_students1);
        
        TreeMap <Integer,Department> departments = new TreeMap<Integer, Department>();
        departments.put(1,CSE);
        departments.put(2,EE);

        TreeMap <Integer,Department> departments1 = new TreeMap<Integer, Department>();
        departments1.put(1,CSE1);
        departments1.put(2,EE1);
         
        // creating an instance of Institute.
        Institute JIT = new Institute("AnnaUniversity","JIT", departments);
        Institute CIET = new Institute("AnnaUniversity","CIET", departments1);

        TreeMap <Integer,Institute> institutes = new TreeMap<Integer, Institute>();
        institutes.put(1, JIT);
        institutes.put(2, CIET);

        //creating an instance of University
        University univer = new University("AnnaUniversity", institutes);
        
        univer.searchInstitute("JIT");
        //int n = institute.getTotalStudentsInInstitute();
        //System.out.print("Total students in institute: "+n);
        //institute.searchDepartment("EE");
    }
}