package square

import kotlin.test.assertEquals
import org.junit.Test as test

class TestAlice {

    private val alice = Customer(
            name = "alice",
            balance = 0.00
    )
    // test if the customer account handles various conditions
    @test
    fun aliceTests() {
        assertEquals(30.00, deposit(30.00, alice))
        assertEquals(10.00, withdraw(20.00, alice))
        assertEquals(10.00, BankAccount.bankBalance)
        assertEquals(null, withdraw(20.00, alice))
    }
}

class TestBank {

    private val george = Customer(
            name = "george",
            balance = 0.00
    )

    private val bruce = Customer(
            name = "bruce",
            balance = 0.00
    )

    // Logic to test if the bank handles changes in deposits
    @test
    fun bankTests() {
        assertEquals(120.00, deposit(120.00, george))
        assertEquals(200.00, deposit(200.00, bruce))
        assertEquals(320.00, BankAccount.bankBalance)
        assertEquals(20.00, withdraw(100.00, george))
        assertEquals(220.00, BankAccount.bankBalance)
    }


}

