package handleTestCases;

public class TestCase {
    private String testCaseName,
            userName,
            password,
            firstName, lastName, zipcode,
            expectedUrl;

    public TestCase(String testCaseName, String userName, String password, String firstName, String lastName, String zipcode, String expectedUrl) {
        this.testCaseName = testCaseName;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipcode = zipcode;
        this.expectedUrl = expectedUrl;
    }

    public String getTestCaseName() {
        return testCaseName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getExpectedUrl() {
        return expectedUrl;
    }
}
