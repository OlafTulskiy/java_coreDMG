package com.company.lesson1DZ;

public class Team {
    private String nameOfTeam;
    private Man[] members;


    public Team(String setName, Man[] _members) {
        nameOfTeam = setName;
        this.members = _members;
    }

    public Team() {};

    Man[] getMembers() {
        return members;
    }

    public void showManThatDone() {
        for (int i = 0; i < members.length; i++) {
            if(members[i].getIsCourseDone()){
                System.out.println("Member of team - " + i + " passed the course");
                System.out.println("++++ name of member - " + members[i].getName());
                System.out.println("++++ age of member - " + members[i].getAge());
            }
        }
    }
    public void showInfoAboutManInTeam() {
        System.out.println("===========================");
        for (int i = 0; i < members.length; i++) {
            System.out.println("Member of team - " + i );
            System.out.println("++++ name of member - " + members[i].getName());
            System.out.println("++++ age of member - " + members[i].getAge());
            System.out.println("++++ power of member - " + members[i].getPowerOfMan());
            System.out.println("++++++++++++++++++++++++++");
        }
        System.out.println("===========================");
    }


}
