package square

class InvalidAmountException(amount: Long, message: String): IllegalArgumentException("invalid amount: $amount. $message")
class InsufficientBalance(amount: Long, accountId: String): IllegalArgumentException("insufficient balance $amount in account: $accountId")
class AccountAlreadyExists(accountId: String): IllegalArgumentException("Account already exists: $accountId")
class AccountDoesNotExist(accountId: String): IllegalArgumentException("Account does not exist, try creating it: $accountId")