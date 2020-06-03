package models;

public class Customer {

    static int count = 0;

    private int id;
    private String name;

    public Customer() {
    }

    public Customer(String name) {
        this.id = count++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
