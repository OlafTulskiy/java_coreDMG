package com.company.lesson1DZ;

public class Course {

    private Obstacle[] arrOfObstacles;

    public Course (Obstacle[] _arrOfObstacles) {
        arrOfObstacles = new Obstacle[_arrOfObstacles.length-1];
        this.arrOfObstacles = _arrOfObstacles;
    }
    public void doIt(Team enterTeam) {
        for(int i = 0; i < enterTeam.getMembers().length; i++) {
            Man tmp = enterTeam.getMembers()[i];
            if (tmp.getPowerOfMan() <= arrOfObstacles[i].getPowerOfObstacle())
                enterTeam.getMembers()[i].setCourseDone(false);
        }

    }
}
