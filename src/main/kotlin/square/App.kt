package square

object BankAccount {
 var bankBalance = 0.00
}
/// initializing the bank at runtime due to lack of persistence
val bank = BankAccount

class Customer(var name: String, balance: Double) {
    var balance = 0.00
        set(value) {
            if (value < 0.00) throw IllegalArgumentException(
                    "balance cannot be negative")
            field = value
        }
    init {
        this.balance = balance
    }

}

fun deposit(amount: Double, customer: Customer): Double {
    customer.balance = customer.balance.plus(amount)
    bank.bankBalance = bank.bankBalance.plus(amount)
    return customer.balance
}

fun withdraw(amount: Double, customer: Customer): Double? {
    if (customer.balance.minus(amount) < 0.00) {
        return null
    }
    else {
        customer.balance = customer.balance.minus(amount)
        bank.bankBalance = bank.bankBalance.minus(amount)
        return customer.balance
    }
}
