

package square

import kotlin.test.assertEquals
import org.junit.Test as test

class Alice() {

    private val alice = Customer(
            name = "alice",
            balance = 0.00
    )
    @test
    fun aliceTests() {
        assertEquals(30.00, deposit(30.00, alice))
        assertEquals(10.00, withdraw(20.00, alice))
        assertEquals(10.00, BankAccount.bankBalance)
        assertEquals(null, withdraw(20.00, alice))
    }
}

