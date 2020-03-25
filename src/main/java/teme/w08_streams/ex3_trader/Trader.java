package teme.w08_streams.ex3_trader;

class Trader {
    private final String name;
    private String city;

    Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    String getName() {
        return name;
    }

    String getCity() {
        return city;
    }

    void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Trader{" + "name='" + name + '\'' + ", city='" + city + '\'' + '}';
    }
}
