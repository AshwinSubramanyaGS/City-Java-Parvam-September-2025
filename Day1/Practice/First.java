class Student{
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private String usn;
    public String getUsn() {
        return usn;
    }
    public void setUsn(String usn) {
        this.usn = usn;
    }
    public Student(String name, String usn) {
        this.name = name;
        this.usn = usn;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", usn=" + usn + "]";
    }

}
public class First{
    public static void main(String arg[]){
        String s="name";
        String s1= s ;
        String s2= "usn" ;//Same object different reference
        //String s2=new String(s);//New object

/*         s=s.concat(" car");
        System.out.println("s: "+s1+"\ns2: "+s2);
 */
        Student stu=new Student(s, s2);
        System.out.println(stu);
    }
}