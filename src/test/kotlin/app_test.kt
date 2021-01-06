package square

import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import org.junit.Test as test

class TestDepositsAndWithdrawals {

    @test
    fun test_deposits_withdrawals() {
        val bank = Bank()
        createAccount(bank, accountId = "alice")
        assertEquals(3000, deposit(bank,"alice", 3000))
        assertEquals(1000, withdraw(bank,"alice", 2000))
        assertEquals(1000, bankBalance(bank))
    }

    @test
    fun test_customer_insufficient_funds() {
        val bank = Bank()
        createAccount(bank, accountId = "george")
        assertEquals(12000, deposit(bank,"george",12000))
        assertFailsWith<InsufficientBalance>{withdraw(bank,"george", 20000)}
    }

    @test
    fun test_customer_negative_deposit() {
        val bank = Bank()
        createAccount(bank, accountId = "greg")
        assertFailsWith<InvalidAmountException>{deposit(bank,"greg",-12000)}
    }
    @test
    fun test_customer_negative_withdrawal() {
        val bank = Bank()
        createAccount(bank, accountId = "sally")
        assertFailsWith<InvalidAmountException>{withdraw(bank,"sally",-12000)}
    }
}

class TestBalances {
    @test
    fun test_account_balance() {
        val bank = Bank()
        createAccount(bank, accountId = "alice")
        assertEquals(3000, deposit(bank,"alice", 3000))
        assertEquals(3000, accountBalance(bank, "alice"))
    }

    @test
    fun test_bank_balance() {
        val bank = Bank()
        createAccount(bank, accountId = "alice")
        assertEquals(3000, deposit(bank,"alice", 3000))
        assertEquals(3000, bankBalance(bank))
    }
}

class TestBankIntegrity {
    // Logic to test if the bank balance handles changes in multiple customer transactions
    @test
    fun test_bank_balance_with_multiple_customers() {
        val bank = Bank()
        createAccount(bank, accountId = "george")
        createAccount(bank, accountId = "bruce")
        assertEquals(12000, deposit(bank,"george",12000))
        assertEquals(20000, deposit(bank,"bruce", 20000))
        assertEquals(32000, bankBalance(bank))
        assertEquals(2000, withdraw(bank,"george", 10000))
        assertEquals(22000, bankBalance(bank))
    }
}

class TestAccounts {
    @test
    fun test_account_nonexistent_exception() {
        val bank = Bank()
        assertFailsWith<AccountDoesNotExist> { deposit(bank,"greg", 3000) }
    }

    @test
    fun test_account_already_exists_exception() {
        val bank = Bank()
        createAccount(bank, accountId = "bruce")
        assertFailsWith<AccountAlreadyExists> { createAccount(bank, accountId = "bruce") }
    }
}
