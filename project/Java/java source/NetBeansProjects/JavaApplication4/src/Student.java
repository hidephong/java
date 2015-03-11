/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lovely
 */
public class Student {
String fullname;
String dob;
String Phonenb;
String Mobilenb;
String Email;
String IMID;
String addr;

    public Student(String fullname, String dob, String Phonenb, String Mobilenb, String Email, String IMID, String addr) {
        this.fullname = fullname;
        this.dob = dob;
        this.Phonenb = Phonenb;
        this.Mobilenb = Mobilenb;
        this.Email = Email;
        this.IMID = IMID;
        this.addr = addr;
    }


    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getIMID() {
        return IMID;
    }

    public void setIMID(String IMID) {
        this.IMID = IMID;
    }

    public String getMobilenb() {
        return Mobilenb;
    }

    public void setMobilenb(String Mobilenb) {
        this.Mobilenb = Mobilenb;
    }

    public String getPhonenb() {
        return Phonenb;
    }

    public void setPhonenb(String Phonenb) {
        this.Phonenb = Phonenb;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "Student{" + "fullname=" + fullname + "dob=" + dob + "Phonenb=" + Phonenb + "Mobilenb=" + Mobilenb + "Email=" + Email + "IMID=" + IMID + "addr=" + addr + '}';
    }

}
