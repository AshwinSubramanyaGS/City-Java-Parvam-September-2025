public class InstancesDemo {
        public static void main(String[] args) {
            Person s=new Person("CEC-Is-A");
            Person s2=s;
            s2.name="Champions";
            System.out.println("S= "+s.name+"\nS2= "+s2.name);
        }
}
class Person{
    String name;

    public Person(String name) {
        this.name = name;
    }
}