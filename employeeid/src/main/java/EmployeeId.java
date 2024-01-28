import java.util.regex.Pattern;

public class EmployeeId {
    public boolean checkId(String empId) {
        StringBuffer regEx = new StringBuffer();
        String codeNo = "[259]";
        String id = "[a-c]+";
        String digit = "[0-9]";
        String nzDigit = "[1-9]";
        regEx.append(codeNo);
        regEx.append("-");
        regEx.append(id);
        regEx.append("-");
        regEx.append(nzDigit);
        regEx.append(digit);
        regEx.append(digit);
        regEx.append(digit);
        regEx.append(digit);
        String pattern = regEx.toString();
        boolean r = Pattern.matches(pattern, empId);
        return r;
    }
}
