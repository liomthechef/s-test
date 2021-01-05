package square

data class Customer(val name: String) {
    var balance: Long = 0
}

data class Transaction(val value: Long, val transactionType: TransactionType) {}

enum class TransactionType {
    Credit, Debit
}

fun deposit(customer: Customer, amount: Long): Long? {
    val response: Long?
    if (amount < 0) {
        response = null
    } else {
        val transactionRecord = Transaction(amount, TransactionType.Credit)
        ledger(customer, transactionRecord)

        customer.balance = customer.balance.plus(amount)
        response = customer.balance
    }
    return response
}

fun withdraw(customer: Customer, amount: Long): Long? {
    val response: Long?
    // check if withdrawal amount exceeds bank balance
    if (customer.balance.minus(amount) < 0) {
        response = null
    } else {
        val transactionRecord = Transaction(amount, TransactionType.Debit)
        ledger(customer, transactionRecord)
        customer.balance = customer.balance.minus(amount)

        response = customer.balance
    }
    return response
}


fun main() {}
