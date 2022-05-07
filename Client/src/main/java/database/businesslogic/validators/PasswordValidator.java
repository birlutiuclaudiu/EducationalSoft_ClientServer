package database.businesslogic.validators;

import java.util.regex.Pattern;

public class PasswordValidator implements Validator<String> {

    /*
    * from: https://www.ocpsoft.org/tutorials/regular-expressions/password-regular-expression/
    * At least one digit [0-9]
    * At least one lowercase character [a-z]
    * At least one uppercase character [A-Z]
    * At least one special character [*.!@#$%^&(){}[]:;<>,.?/~_+-=|\]
    * At least 8 characters in length, but no more than 32.
     */
    private final String PASSWORD_REGEX = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$";

    @Override
    public void validate(String s) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        if (!pattern.matcher(s).matches()) {
            throw new IllegalArgumentException("Invalid password: minimum 8 characters, digit, specia character: ., letters");
        }
    }
}
