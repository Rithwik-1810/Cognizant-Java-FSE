public class RegistrationService {
    private final Validator validator;

    public RegistrationService(Validator validator) {
        this.validator = validator;
    }

    public void register(String input) {
        validator.validate(input);
    }
}
