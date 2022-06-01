package com.company.lesson1DZ;

public class Obstacle {
    private String nameOfObstacle;
    private int powerOfObstacle;

    public Obstacle(String _nameOfObstacle, int _powerOfObstacle) {
        this.nameOfObstacle = _nameOfObstacle;
        this.powerOfObstacle = _powerOfObstacle;
    }
    String getNameOfObstacle() {
        return this.nameOfObstacle;
    }

    int getPowerOfObstacle() {
        return this.powerOfObstacle;
    }
}
