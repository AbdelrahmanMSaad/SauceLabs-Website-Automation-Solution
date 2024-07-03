package handleFilesAndDirectories.handleConfigFile;

import handleFilesAndDirectories.getDirectoriesAndFiles.GetDirectoriesAndFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetPropertiesFromConfigFile {
    public static String getPropertyFromConfigFile(String property) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File(GetDirectoriesAndFiles.getConfigFile()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties properties = new Properties();
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(property);
    }
}
