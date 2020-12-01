package square

object BankAccount {
    var bankBalance = 0.00
}
var bank = BankAccount

class Customer(balance: Double) {
    private var customerBalance = 0.00
        set(value) {
            if (value < 0.00) throw IllegalArgumentException(
                "balance cannot be negative"
            )
            field = value
        }
    init {
        this.customerBalance = balance
    }

    fun deposit(amount: Double): Double {
        customerBalance = customerBalance.plus(amount)
        bank.bankBalance = bank.bankBalance.plus(amount)
        return customerBalance
    }
    fun withdraw(amount: Double): Double? {
        val response: Double?
        if (customerBalance.minus(amount) < 0.00) {
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
