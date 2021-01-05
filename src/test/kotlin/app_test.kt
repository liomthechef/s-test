package square

import java.math.BigDecimal
import kotlin.test.assertEquals
import org.junit.Test as test

class TestAlice {
    private val alice = Customer(balance = BigDecimal.ZERO)
    // test if the customer account handles various conditions
    @test
    fun aliceTests() {
        bank.bankBalance = BigDecimal.ZERO
        assertEquals(BigDecimal("30.00"), alice.deposit(BigDecimal("30.00")))
        assertEquals(BigDecimal("10.00"), alice.withdraw(BigDecimal("20.00")))
        assertEquals(BigDecimal("10.00"), bank.bankBalance)
        assertEquals(null, alice.withdraw(BigDecimal("20.00")))
    }
}

class TestBank {
    private val george = Customer(balance = BigDecimal.ZERO)
    private val bruce = Customer(balance = BigDecimal.ZERO)
    // Logic to test if the bank balance handles changes in multiple customer transactions
    @test
    fun bankTests() {
        bank.bankBalance = BigDecimal.ZERO
        assertEquals(BigDecimal("120.00"), george.deposit(BigDecimal("120.00")))
        assertEquals(BigDecimal("200.00"), bruce.deposit(BigDecimal("200.00")))
        assertEquals(BigDecimal("320.00"), bank.bankBalance)
        assertEquals(BigDecimal("20.00"), george.withdraw(BigDecimal("100.00")))
        assertEquals(BigDecimal("220.00"), bank.bankBalance)
    }
}

class TestDecimals {
    private val eccentricCustomer = Customer(balance = BigDecimal.ZERO)
    @test
    fun bankTests() {
        bank.bankBalance = BigDecimal.ZERO
        assertEquals(BigDecimal("120.0000002"), eccentricCustomer.deposit(BigDecimal("120.0000002")))
        assertEquals(BigDecimal("320.0000003"), eccentricCustomer.deposit(BigDecimal("200.0000001")))
        assertEquals(BigDecimal("320.1000004"), eccentricCustomer.deposit(BigDecimal("0.1000001")))
        assertEquals(BigDecimal("320.1000004"), bank.bankBalance)
    }
}
