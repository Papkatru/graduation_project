package tests.web.data;

import com.github.javafaker.Faker;

public class StepikData {
    Faker faker = new Faker();
    public String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            fullName = firstName + " " + lastName,
            email = faker.internet().emailAddress(),
            password = faker.internet().password();

}
