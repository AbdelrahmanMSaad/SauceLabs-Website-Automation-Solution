package handleTestCases;

import com.google.gson.Gson;
import handleFilesAndDirectories.getDirectoriesAndFiles.GetDirectoriesAndFiles;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class RetrieveAllTestCases {
    public static TestCase[] retrieveAllTestCases() {
        try {
            InputStream inputStream = new FileInputStream(GetDirectoriesAndFiles.getTestCasesFile());
            String testDataJson = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            return new Gson().fromJson(testDataJson,TestCase[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        RetrieveAllTestCases.retrieveAllTestCases();
    }
}
