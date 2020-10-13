package model;

import java.util.List;

public class MowerSystem {
    private Lawn lawn;
    private List<MowerConfig> mowers;

    public Lawn getLawn() {
        return lawn;
    }

    public void setLawn(Lawn lawn) {
        this.lawn = lawn;
    }

    public List<MowerConfig> getMowers() {
        return mowers;
    }

    public void setMowers(List<MowerConfig> mowers) {
        this.mowers = mowers;
    }

    public void startAll() {
        for (MowerConfig t : mowers) {
            Command c = t.getCommand();
            Mower mower = t.getMower();
            mower.start(c, lawn.getWidth(), lawn.getHeight());
            System.out.println(mower.toString());
        }
    }

}
