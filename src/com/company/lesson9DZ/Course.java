package com.company.lesson9DZ;
import java.util.Objects;

public class Course {

    private String name;

    public  Course (String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course room = (Course) o;
        return Objects.equals(name, room.name);
    }


    public int hashCode() {
        return Objects.hash(name);
    }
}
