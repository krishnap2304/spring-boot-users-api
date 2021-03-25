package com.example.demo.model;

public class User {
    private String id;
    private String name;

    public User(){

    }

    public User(String id, String name, String designation){
        this.id = id;
        this.name = name;
        this.designation =designation;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!id.equals(user.id)) return false;
        if (!name.equals(user.name)) return false;
        return designation.equals(user.designation);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + designation.hashCode();
        return result;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    private String designation;

}
