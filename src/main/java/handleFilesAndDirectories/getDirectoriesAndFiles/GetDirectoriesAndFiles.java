package handleFilesAndDirectories.getDirectoriesAndFiles;

import java.nio.file.Paths;

public class GetDirectoriesAndFiles {
    private static final String src = "src",
            main = "main",
            java = "java",
            resources = "resources",
            test = "test",
            configFileName = "config.properties",
            testCasesFileName = "testCases.json",
            elementsFileName = "elements.json";


    private static final String USER_DIR = System.getProperty("user.dir");

    public static String getConfigFilePath() {
        return Paths.get(USER_DIR, src, main, resources, configFileName).toString();
    }

    public static String getTestCasesFilePath() {
        return Paths.get(USER_DIR, src, test, resources, testCasesFileName).toString();
    }

    public static String getElementsJsonFilePath() {
        return Paths.get(USER_DIR, src, main, resources, elementsFileName).toString();
    }
}

