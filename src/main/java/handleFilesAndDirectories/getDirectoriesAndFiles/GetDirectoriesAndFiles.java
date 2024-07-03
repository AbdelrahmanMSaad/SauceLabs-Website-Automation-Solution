package handleFilesAndDirectories.getDirectoriesAndFiles;

import java.nio.file.Paths;

public class GetDirectoriesAndFiles {
    private static final String src = "src",
            main = "main",
            java = "java",
            resources = "resources",
            test = "test",
            configFileName = "config.properties",
            testCasesFeleName = "testCases.json";


    private static final String USER_DIR = System.getProperty("user.dir");

    public static String getConfigFile() {
        return Paths.get(USER_DIR, src, main, resources, configFileName).toString();
    }

    public static String getTestCasesFile() {
        return Paths.get(USER_DIR, src, test, resources, testCasesFeleName).toString();
    }
}

