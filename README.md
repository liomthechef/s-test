# square

## Solving the code challenge of bank in a box

I implemented the bank as a hashmap of accounts, using a dataclass for portability, I focused on simplicity and the criteria heavily here
The currency value is in cents using a long datatype, by using the base currency unit instead of float safe option such as BigDecimal it makes currency changes simpler, as well as less complex code.

A money library would have been an option as well, but I felt too complex for the test to import for this purpose
I left an unused account balance check because it felt like it should be there for future uses.
I really wanted to turn this into an event based ledger instead of a hashmap, but to make it performant I felt like i would have overcooked it especially when taking into account debits/credits

## Tests

Tests focus on basic transactional events that are expected, as well as the bank handling multiple members.
Tried to consider some edge case exceptions such as the account not existing, so added a require check for the hashmap lookup to be not null.
Some negative withdrawal checks have been factored in as I imagine that would be a common user error.

## Constraints
Constraints are primarily in scalability, I initially wanted to implement the bank as a ledger of transactions but felt
the processing complexity didn't fit the trade-off of the brief.
Concurrency could be an issue with the approaches I took, such as the account creation method.
The account creation method will not create duplicate accounts with the same key, however the c

## Assumptions
Currency wasn't immediately important to the test
Transactional history/logging wasn't necessary despite being important in the real world

## Prerequisites
Java, Gradle.

## Languages
Kotlin/Java11, built via Gradle.
Java
Junit

## Build
./gradlew build

## Tests
./gradlew test
You can see test reports in ./build/reports/tests/test/index.html
