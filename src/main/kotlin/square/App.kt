package square

import java.math.BigDecimal

object BankAccount {
    var bankBalance: BigDecimal = BigDecimal.ZERO
}
var bank = BankAccount

class Customer(balance: BigDecimal) {
    private var customerBalance: BigDecimal = BigDecimal.ZERO
        set(value) {
            if (value < BigDecimal.ZERO) {
                throw IllegalArgumentException("balance cannot be negative")
            }
            field = value
        }
    init {
        this.customerBalance = balance
    }

    fun deposit(amount: BigDecimal): BigDecimal {
        customerBalance = customerBalance.plus(amount)
        bank.bankBalance = bank.bankBalance.plus(amount)
        return customerBalance
    }
    fun withdraw(amount: BigDecimal): BigDecimal? {
        val response: BigDecimal?
        if (customerBalance.minus(amount) < BigDecimal.ZERO) {
            response = null
        } else {
            customerBalance = customerBalance.minus(amount)
            bank.bankBalance = bank.bankBalance.minus(amount)
            response = customerBalance
        }
        return response
    }
}

fun main() {}
