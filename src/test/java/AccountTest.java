import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @ParameterizedTest
    @CsvFileSource(files="src/main/resources/testIncomeExpenses.csv")
    void addIncome(int income1, int income2, int income3, int income4, int income5,
                   int expectedTotalIncome) {
        Account account = new Account();
        account.addIncome(income1);
        account.addIncome(income2);
        account.addIncome(income3);
        account.addIncome(income4);
        account.addIncome(income5);
        int expected = expectedTotalIncome;
        int actual = account.getTotalIncome();
        Assertions.assertEquals(expected, actual, "Метод должен добавлять доходы");
    }

    @ParameterizedTest
    @CsvFileSource(files="src/main/resources/testIncomeExpenses.csv")
    void addExpenses(int expenses1, int expenses2, int expenses3, int expenses4, int expenses5,
                     int expectedTotalExpenses) {
        Account account = new Account();
        account.addExpenses(expenses1);
        account.addExpenses(expenses2);
        account.addExpenses(expenses3);
        account.addExpenses(expenses4);
        account.addExpenses(expenses5);
        int expected = expectedTotalExpenses;
        int actual = account.getTotalExpenses();
        Assertions.assertEquals(expected, actual, "Метод должен добавлять расходы");
    }

    @ParameterizedTest
    @CsvFileSource(files="src/main/resources/testGetIncome.csv")
    void getTotalIncome(int income1, int income2, int expenses1, int expenses2,
                        int expectedTotalIncome) {
        Account account = new Account();
        account.addIncome(income1);
        account.addIncome(income2);
        account.addExpenses(expenses1);
        account.addExpenses(expenses2);
        int expected = expectedTotalIncome;
        int actual = account.getTotalIncome();
        Assertions.assertEquals(expected, actual, "Метод должен возвращать все доходы");
    }

    @Test
    void getTotalIncomeDefault() {
        Account account = new Account();
        int expected = 0;
        int actual = account.getTotalIncome();
        Assertions.assertEquals(expected, actual, "Метод должен возвращать дефолтное значение 0");
    }

    @Test
    void getTotalIncomeDefaultWithExpenses() {
        Account account = new Account();
        account.addExpenses(1000);
        int expected = 0;
        int actual = account.getTotalIncome();
        Assertions.assertEquals(expected, actual, "Метод должен возвращать дефолтное значение 0");
    }

    @ParameterizedTest
    @CsvFileSource(files="src/main/resources/testGetExpenses.csv")
    void getTotalExpenses(int income1, int income2, int expenses1, int expenses2,
                        int expectedTotalExpenses) {
        Account account = new Account();
        account.addIncome(income1);
        account.addIncome(income2);
        account.addExpenses(expenses1);
        account.addExpenses(expenses2);
        int expected = expectedTotalExpenses;
        int actual = account.getTotalExpenses();
        Assertions.assertEquals(expected, actual, "Метод должен возвращать все доходы");
    }

    @Test
    void getTotalExpensesDefault() {
        Account account = new Account();
        int expected = 0;
        int actual = account.getTotalExpenses();
        Assertions.assertEquals(expected, actual, "Метод должен возвращать дефолтное значение 0");
    }

    @Test
    void getTotalExpensesDefaultWithIncome() {
        Account account = new Account();
        account.addIncome(1000);
        int expected = 0;
        int actual = account.getTotalExpenses();
        Assertions.assertEquals(expected, actual, "Метод должен возвращать дефолтное значение 0");
    }

    @ParameterizedTest
    @CsvFileSource(files="src/main/resources/testGetTax.csv")
    void getTax6p(int income, int expenses, int expectedTax6p) {
        Account account = new Account();
        account.addIncome(income);
        account.addExpenses(expenses);
        int expected = expectedTax6p;
        int actual = account.getTax6p();
        Assertions.assertEquals(expected, actual, "Метод должен возвращать налог 6% от дохода");
    }

    @ParameterizedTest
    @CsvFileSource(files="src/main/resources/testGetTax.csv")
    void getTax15p(int income, int expenses, int expectedTax6p, int expectedTax15p) {
        Account account = new Account();
        account.addIncome(income);
        account.addExpenses(expenses);
        int expected = expectedTax15p;
        int actual = account.getTax15p();
        Assertions.assertEquals(expected, actual, "Метод должен возвращать налог 15% " +
                "от разницы доходов и расходов");
    }
}