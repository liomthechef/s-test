package square

var bankAccounts: HashMap<String, Transaction> = HashMap()

fun ledger(customer: Customer, transactionRecord: Transaction) {
    bankAccounts[customer.name] = transactionRecord
}

fun bankBalance(): Long {
 return 0
}