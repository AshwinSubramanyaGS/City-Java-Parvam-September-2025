interface Greeting {
    void sayHello();
}

public class InLineClassDemo {
    public static void main(String[] args) {
        
        Greeting englishGreeting = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hello!");
            }
        };

        Greeting spanishGreeting = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("¡Hola!");
            }
        };

        englishGreeting.sayHello();
        spanishGreeting.sayHello();
    }
}