package square

data class Bank(var bankAccounts: HashMap<String, Long> = HashMap())

fun bankBalance(bank: Bank): Long {
    //take the values from the hashmap, sum all of them together to work out bank balance
    return bank.bankAccounts.map{it.value}.reduce{sum, element -> sum + element}
}

fun createAccount(bank: Bank, accountId: String) {
// method checks if key exists, if it doesn't, it creates it with a default value.
    if (bank.bankAccounts[accountId] != null) { throw AccountAlreadyExists(accountId)}
    require (bank.bankAccounts[accountId] == null ) {"account already exists"}
    bank.bankAccounts[accountId] = 0
}

fun accountBalance(bank: Bank, accountId: String): Long {
    val balance = bank.bankAccounts[accountId]
    require( balance != null) { "account is null, does it exist?"}
    return balance
}

fun deposit(bank: Bank, accountId: String, amount: Long): Long {
    val accountBalance: Long = bank.bankAccounts[accountId] ?: throw AccountDoesNotExist(accountId)
    if (amount < 0) { throw InvalidAmountException(amount, "deposit amount should be greater than zero")}

    bank.bankAccounts [accountId] = accountBalance.plus(amount)
    return accountBalance.plus(amount)
}

fun withdraw(bank: Bank, accountId: String, amount: Long): Long {
    val accountBalance: Long = bank.bankAccounts[accountId] ?: throw AccountDoesNotExist(accountId)
    if (amount < 0) { throw InvalidAmountException(amount, "withdraw amount should be greater than zero")}
    if (accountBalance.minus(amount) < 0) { throw InsufficientBalance(amount, accountId)}
    bank.bankAccounts[accountId] = accountBalance.minus(amount)
    return accountBalance.minus(amount)
}