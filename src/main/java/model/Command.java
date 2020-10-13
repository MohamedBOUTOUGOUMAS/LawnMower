package model;

public class Command {
    private String cmd;
    private int index = 0;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public boolean hasNext() {
        return index < cmd.length();
    }

    public Order getNextChar() {
        Order c = Order.valueOf(String.valueOf(cmd.charAt(index)));
        index++;
        return c;
    }

    @Override
    public String toString() {
        return cmd;
    }
}
