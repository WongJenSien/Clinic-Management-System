/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;


/**
 *
 * @author HISOKA
 */
public class Patient {
   
    private String name;
    private String studentID;
    private String phoneNum;
    private String icNum;
    private int age;
    private char gender;
    
    public Patient(){}
    
    public Patient(String name,String studentID, String phoneNum, String icNum,int age, char gender){
        
        this.name = name;
        this.studentID=studentID; 
        this.phoneNum = phoneNum;
        this.icNum = icNum;
        this.age =age;
        this.gender = gender;
       // this.vList= new LinkedList<>();
        
       
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getIcNum() {
        return icNum;
    }

    public void setIcNum(String icNum) {
        this.icNum = icNum;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

//    public ListInterfaceWSH<VisitationRecord> getvList() {
//        return vList;
//    }

    @Override
    public String toString() {
        return "\n\nPatient"+
                "\nName\t\t\t: " + name +
                "\nStudentID\t\t: "+ studentID +
                "\nPhone Number\t\t: " + phoneNum + 
                "\nIC Number\t\t: " + icNum + 
                "\nAge\t\t\t: "+ age +
                "\nGender\t\t\t: " + gender;
    }

    

}
