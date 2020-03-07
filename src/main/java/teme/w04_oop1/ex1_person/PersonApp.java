package teme.w04_oop1.ex1_person;

class PersonApp {

    //just for manual testing of the Person class
    public static void main(String[] args) {

        Person p1 = new Person("Ion", 1989, "black");
        Person p2 = new Person("Ana", 2001, "blond");
        System.out.println("p1: " + p1.toString());
        System.out.println("p1 older than p2: " + p1.isOlderThan(p2));
    }
}

//TODO: define your Person class in a SEPARATE file in same package! (and make it public)
