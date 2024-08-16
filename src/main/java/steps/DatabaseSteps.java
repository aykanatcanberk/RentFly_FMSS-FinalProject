package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DatabaseUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DatabaseSteps {

    @Given("a connection to the database")
    public void connectToDatabase() {
        DatabaseUtils.connect();
    }

    @When("checking the data type of email column")
    public void checkEmailColumnType() {
        DatabaseUtils.checkEmailColumnType();
    }

    @Then("the data type should be varchar with a maximum length of 50")
    public void validateEmailColumnType() {
        assertEquals("character varying", DatabaseUtils.columns.get("email"));
        assertEquals(50, (int) DatabaseUtils.varcharLengths.get("email"));
    }

    @When("checking the data type of sign_up_date column")
    public void checkSignUpDateColumnType() {
        DatabaseUtils.checkSignUpDateColumnType();
    }

    @Then("the data type of sign_up_date should be date")
    public void validateSignUpDateColumnType() {
        assertEquals("date", DatabaseUtils.columns.get("sign_up_date"));
    }

    @When("checking the data type of password column")
    public void checkPasswordColumnType() {
        DatabaseUtils.checkPasswordColumnType();
    }

    @Then("the data type should be varchar with a maximum length of 250")
    public void validatePasswordColumnType() {
        assertEquals("character varying", DatabaseUtils.columns.get("password"));
        assertEquals(250, (int) DatabaseUtils.varcharLengths.get("password"));
    }

    @When("checking the data type of phone column")
    public void checkPhoneColumnType() {
        DatabaseUtils.checkPhoneColumnType();
    }

    @Then("the data type of phone should be varchar with a maximum length of 50")
    public void validatePhoneColumnType() {
        assertEquals("character varying", DatabaseUtils.columns.get("phone"));
        assertEquals(50, (int) DatabaseUtils.varcharLengths.get("phone"));
    }

    @When("checking the data type of birth_date column")
    public void checkBirthDateColumnType() {
        DatabaseUtils.checkBirthDateColumnType();
    }

    @Then("the data type of birth_date should be date")
    public void validateBirthDateColumnType() {
        assertEquals("date", DatabaseUtils.columns.get("birth_date"));
    }

    @When("checking the data type of status column")
    public void checkStatusColumnType() {
        DatabaseUtils.checkStatusColumnType();
    }

    @Then("the data type of status should be varchar with a maximum length of 50")
    public void validateStatusColumnType() {
        assertEquals("character varying", DatabaseUtils.columns.get("status"));
        assertEquals(50, (int) DatabaseUtils.varcharLengths.get("status"));
    }

    @When("checking foreign key constraints")
    public void checkForeignKeyConstraints() {
        DatabaseUtils.checkForeignKeyConstraints();
    }

    @Then("the correct foreign key constraints should exist")
    public void validateForeignKeyConstraints() {
        assertTrue(DatabaseUtils.foreignKeysExist("signup", "social", "social_id"));
    }
}
