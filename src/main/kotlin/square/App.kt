package square

object BankAccount {
 var bankBalance = 0.00
}
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

fun customerBalance(customer: Customer): Double {
    return customer.balance
}


fun main() {



 val alice = Customer(name = "alice", balance = 0.00)
    println(alice.name)
    println(alice.balance)
 deposit(20.00, alice)
    println(alice.name)
    println(alice.balance)

 withdraw(30.00, alice)
    println(alice.name)
    println(alice.balance)

 val result = customerBalance(alice)
    println("alices balance is $result")

    println ("bank balance is")
    println (bank.bankBalance)

}
