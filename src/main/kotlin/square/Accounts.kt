package square

data class Bank(var bankAccounts: HashMap<String, Long> = HashMap())

fun createAccount(bank: Bank, accountId: String) {
//getorput method checks if key exists, if it doesn't, it creates it with a default value under the key
    bank.bankAccounts.getOrPut(accountId, {0})
}

fun deposit(bank: Bank, accountId: String, amount: Long): Long? {
    val balance: Long? = bank.bankAccounts[accountId]
    require( balance != null) { "account is null, does it exist?"}
    require(amount > 0) { "amount must be greater than zero"}
    bank.bankAccounts [accountId] = balance.plus(amount)
    return balance.plus(amount)
}

fun withdraw(bank: Bank, accountId: String, amount: Long): Long? {
    val balance = bank.bankAccounts[accountId]
    require( balance != null) { "account is null, does it exist?"}
    require(balance.minus(amount) > 0) { "amount must be greater than balance to withdraw"}
    bank.bankAccounts[accountId] = balance.minus(amount)
    return balance.minus(amount)
}

fun accountBalance(bank: Bank, accountId: String): Long? {
    val balance = bank.bankAccounts[accountId]
    require( balance != null) { "account is null, does it exist?"}
    return balance
}

fun bankBalance(bank: Bank): Long {
    return bank.bankAccounts.map{it.value}.reduce{sum, element -> sum + element}
}
