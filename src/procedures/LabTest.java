package procedures;

public class LabTest {
    private String testName;
    private boolean result;

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public LabTest(String testName) {
        this.testName = testName;
    }
}
