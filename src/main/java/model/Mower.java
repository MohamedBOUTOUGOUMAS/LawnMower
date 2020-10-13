package model;

import engine.IMovementStrategy;
import engine.StepByStepStrategy;

public class Mower {
    private int x;
    private int y;
    private Direction direction;

    private IMovementStrategy engine = new StepByStepStrategy(this);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return x+" "+y+" "+direction;
    }

    public void start(Command command, int lawnW, int lawnH) {
        engine.process(command, lawnW, lawnH);
    }
}
