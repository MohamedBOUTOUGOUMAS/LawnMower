package engine;

import model.Command;

public interface IMovementStrategy {
    public void process(Command command, int lawnW, int lawnH);
    public void move(int lawnW, int lawnH);
    public void turnLeft();
    public void turnRight();

}
