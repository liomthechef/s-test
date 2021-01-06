package square

data class Bank(var bankAccounts: HashMap<String, Long> = HashMap())

fun bankBalance(bank: Bank): Long {
    //take the values from the hashmap, sum all of them together to work out bank balance
    return bank.bankAccounts.map{it.value}.reduce{sum, element -> sum + element}
}