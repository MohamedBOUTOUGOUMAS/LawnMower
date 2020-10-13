package model;

public class MowerConfig {
    private Mower mower;
    private Command command;

    public Mower getMower() {
        return mower;
    }

    public void setMower(Mower mower) {
        this.mower = mower;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
