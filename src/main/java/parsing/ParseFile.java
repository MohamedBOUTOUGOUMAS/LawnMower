package parsing;

import model.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseFile {

    public static MowerSystem parseFile(String filePath) {
        Lawn lawn = new Lawn();
        List<MowerConfig> mowersConfig = new ArrayList<MowerConfig>();
        try {
            File f = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = "";
            int counter = 0;
            while ((line = reader.readLine()) != null) {
                if (counter == 0) {
                    String [] lawnInfo = line.split(" ");
                    lawn.setWidth(Integer.parseInt(lawnInfo[0]));
                    lawn.setHeight(Integer.parseInt(lawnInfo[1]));
                }
                if (counter == 1) {
                    Mower mower = new Mower();
                    String [] mowerInfo = line.split(" ");
                    mower.setX(Integer.parseInt(mowerInfo[0]));
                    mower.setY(Integer.parseInt(mowerInfo[1]));
                    mower.setDirection(Direction.valueOf(mowerInfo[2]));

                    MowerConfig mowerConfig = new MowerConfig();
                    mowerConfig.setMower(mower);
                    mowersConfig.add(mowerConfig);
                }
                if (counter == 2) {
                    Command command = new Command();
                    command.setCmd(line);
                    MowerConfig mowerConfig = mowersConfig.get(mowersConfig.size() - 1);
                    mowerConfig.setCommand(command);
                }
                counter++;
                if (counter > 2) { counter = 1; }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MowerSystem mowerSystem = new MowerSystem();
        mowerSystem.setLawn(lawn);
        mowerSystem.setMowers(mowersConfig);
        return mowerSystem;
    }
}
