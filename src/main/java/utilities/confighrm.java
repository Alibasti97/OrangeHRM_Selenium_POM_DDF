package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class confighrm {

    static public Properties getProps(String filename){
        Properties myProp = new Properties();
        try{
            File propFile = new File("C:\\Users\\Ali Hassan\\IdeaProjects\\OrangeHRM\\src\\test\\resourceshrm\\data.properties");
            if (propFile.exists()) myProp.load(new FileInputStream(propFile));

            else
                System.out.println("File not Found:" + filename);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return myProp;
    }
}
