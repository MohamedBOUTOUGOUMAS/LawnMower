package engine;

import model.*;

public class StepByStepStrategy implements IMovementStrategy {
    private Mower mower;

    public StepByStepStrategy(Mower mower) {
        this.mower = mower;
    }

    public void process(Command command, int lawnW, int lawnH) {
        while (command.hasNext()) {
            Order c = command.getNextChar();
            switch (c) {
                case G:
                    turnLeft();
                    break;
                case D:
                    turnRight();
                    break;
                case A:
                    move(lawnW, lawnH);
                    break;
            }
        }
    }

    public void move(int lawnW, int lawnH) {
        switch (mower.getDirection()) {
            case N:
                if (mower.getY() < lawnH) { mower.setY(mower.getY() + 1); }
                break;
            case S:
                if (mower.getY() > 0) { mower.setY(mower.getY() - 1); }
                break;
            case E:
                if (mower.getX() < lawnW) { mower.setX(mower.getX() + 1); }
                break;
            case W:
                if (mower.getX() > 0) { mower.setX(mower.getX() - 1); }
                break;
            default:
                break;
        }
    }

    public void turnLeft() {
        switch (mower.getDirection()) {
            case N:
                mower.setDirection(Direction.W);
                break;
            case S:
                mower.setDirection(Direction.E);
                break;
            case E:
                mower.setDirection(Direction.N);
                break;
            case W:
                mower.setDirection(Direction.S);
                break;
            default:
                break;
        }
    }

    public void turnRight() {
        switch (mower.getDirection()) {
            case N:
                mower.setDirection(Direction.E);
                break;
            case S:
                mower.setDirection(Direction.W);
                break;
            case E:
                mower.setDirection(Direction.S);
                break;
            case W:
                mower.setDirection(Direction.N);
                break;
            default:
                break;
        }
    }
}
