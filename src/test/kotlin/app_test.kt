package square

import kotlin.test.assertEquals
import org.junit.Test as test

class TestAlice {
    private val alice = Customer(balance = 0.00)
    // test if the customer account handles various conditions
    @test
    fun aliceTests() {
        bank.bankBalance = 0.00
        assertEquals(30.00, alice.deposit(30.00))
        assertEquals(10.00, alice.withdraw(20.00))
        assertEquals(10.00, bank.bankBalance)
        assertEquals(null, alice.withdraw(20.00))
    }
}

class TestBank {
    private val george = Customer(balance = 0.00)
    private val bruce = Customer(balance = 0.00)
    // Logic to test if the bank balance handles changes in deposits
    @test
    fun bankTests() {
        bank.bankBalance = 0.00
        assertEquals(120.00, george.deposit(120.00))
        assertEquals(200.00, bruce.deposit(200.00))
        assertEquals(320.00, bank.bankBalance)
        assertEquals(20.00, george.withdraw(100.00))
        assertEquals(220.00, bank.bankBalance)
    }
}
