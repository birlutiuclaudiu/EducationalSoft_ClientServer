package database.businesslogic.validators;


import java.util.regex.Pattern;

public class UsernameValidator implements Validator<String> {

    /*
    * from :  https://www.baeldung.com/java-email-validation-regex
     */
    private final String USERNAME_REGEX = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public void validate(String s) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile(USERNAME_REGEX);
        if (!pattern.matcher(s).matches()) {
            throw new IllegalArgumentException("Invalid username");
        }

    }
}
