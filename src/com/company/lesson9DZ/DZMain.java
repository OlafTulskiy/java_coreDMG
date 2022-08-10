package com.company.lesson9DZ;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class DZMain {

    public static void main(String[] args) {
        List<Student> aa = getListOfStudents(10);

        //первая часть
        List<Course> unicCourse = aa.stream().
                flatMap(Student->Student.getCourseList().stream()).
                distinct().collect(Collectors.toList());
        System.out.println("****************");

        //вторая часть
        List<Student> threeMostlySmart = aa.stream().sorted((o1, o2) -> {
            if(o1.getCourseList().size() == o2.getCourseList().size())
                return o1.getName().compareTo(o2.getName());
            else if (o1.getCourseList().size() > o2.getCourseList().size())
                return -1;
            else return 1;
        }).limit(3).collect(Collectors.toList());

        System.out.println("****************");

        //часть 3
        Course ourCourse = new Course("Course - 5");
        List<Student> courseInListStudent = aa.stream().filter(Student->Student.getCourseList().contains(ourCourse)).collect(Collectors.toList());
        System.out.println("****************");



    }

    private static List<Student> getListOfStudents (int count) {
        ArrayList<Student> result = new ArrayList<>();
        for (int i = 0; i < count; i++){
            ArrayList<Course> course = new ArrayList<>();
            int randomInt = (int) (1 + Math.random()*6);
            for(int j = 1; j < randomInt; j++) {
                course.add(new Course("Course - "+j));
            }
            result.add(new Student("Student"+i, course));
        }

        return result;
    }

}
