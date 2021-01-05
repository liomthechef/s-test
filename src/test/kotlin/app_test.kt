package square

import kotlin.test.assertEquals
import org.junit.Test as test

class TestTransactions {
    private val alice = Customer(name = "alice")
    // test if the customer account handles various conditions
    @test
    fun test_deposits_withdrawals() {
//        bank.bankBalance = 0
        assertEquals(3000, deposit(alice, 3000))
        assertEquals(1000, withdraw(alice, 2000))
//        assertEquals(1000, bank.bankBalance)
    }
}

class TestBank {
    private val george = Customer(name = "george")
    private val bruce = Customer(name = "bruce")
    // Logic to test if the bank balance handles changes in multiple customer transactions
    @test
    fun bankTests() {
//        bank.bankBalance = 0
        assertEquals(12000, deposit(george, 12000))
        assertEquals(20000, deposit(bruce, 20000))
//        assertEquals(32000, bank.bankBalance)
        assertEquals(2000, withdraw(george, 10000))
//        assertEquals(22000, bank.bankBalance)
    }
}
