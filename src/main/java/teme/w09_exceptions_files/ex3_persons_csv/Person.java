package teme.w09_exceptions_files.ex3_persons_csv;

class Person implements Comparable<Person> {
    private String name;
    private String cnp;
    private String phone;
    private int height;

    public Person(String name, String cnp, String phone, int height) {
        this.name = name;
        this.cnp = cnp;
        this.phone = phone;
        this.height = height;
    }

    int getHeight() {
        return height;
    }

    String convertToLine() {
        return name + "," + cnp + "," + phone + "," + height;
    }

    static Person convertFromLine(String line) {
        String[] parts = line.split(",\\s*");
        try {
            return new Person(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]));
        } catch (Exception e) {
            System.out.println("failed to convert line to person: '" + line + "'" +
                    ", because: " + e);
            return null;
        }
    }

    @Override
    public int compareTo(Person other) {
        return name.compareTo(other.name) != 0
                ? name.compareTo(other.name)
                : Integer.compare(height, other.getHeight());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", cnp='" + cnp + '\'' +
                ", phone='" + phone + '\'' +
                ", height=" + height +
                '}';
    }
}
