package handleTestCases;

import java.util.Objects;

public class GetTestCase {

    public TestCase getTestCase(String testCaseName){
        TestCase requiredTestCase = null;
        for (TestCase testCase : Objects.requireNonNull(RetrieveAllTestCases.retrieveAllTestCases())){
            if (testCase.getTestCaseName().equalsIgnoreCase(testCaseName)){
                requiredTestCase = testCase;
                return requiredTestCase;
            }
        }

        return requiredTestCase;
    }
}
