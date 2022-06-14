package com.company.lesson1DZ;

import com.company.lesson1DZ.Course;
import com.company.lesson1DZ.Man;
import com.company.lesson1DZ.Obstacle;
import com.company.lesson1DZ.Team;

public class Main {

    public static void main(String[] args) {
        Man one = new Man("Иванов", 33);
        Man two = new Man("Петров", 22);
        Man three = new Man("Сидоров", 12);
        Man[] arrOfMan = {one, two, three};
        Team firstTeam = new Team("Winners", arrOfMan);

        Obstacle oneObs = new Obstacle("Бег", 20);
        Obstacle twoObs = new Obstacle("Прыжки", 13);
        Obstacle threeObs = new Obstacle("Заплыв на 50м", 25);
        Obstacle[] arrOfObs = {oneObs, twoObs, threeObs};
        Course tmpCourse = new Course(arrOfObs);

        tmpCourse.doIt(firstTeam);
        firstTeam.showManThatDone();
        System.out.println("+_+_+_+_+_+_+_+_+_");
        firstTeam.showInfoAboutManInTeam();


    }
}
