# square

## Solving the code challenge of bank in a box

I implemented the bank as a hashmap of accounts, using a dataclass for portability, I focused on simplicity and the criteria.<br>
The currency value is in cents using a long datatype, by using the base currency unit instead of float safe option such as BigDecimal it makes currency changes simpler, as well as less complex code.<br>
A money library would have been an option as well, but I felt too complex for the test to import for this purpose<br><br>

I really wanted to turn this into an event based ledger instead of a hashmap, but to make it performant I felt like I would have overcooked it especially when taking into account debits/credits<br><br>

## Tests
<br>
Tests aim to provide coverage of general usage from a consumer perspective as well as edge cases such as negative withdrawals, deposits, accounts not existing, etc.
The goal was to document the code via the tests.<br>

## Constraints
Constraints are primarily in scalability, I initially wanted to implement the bank as a ledger of transactions but felt the processing complexity didn't fit the trade-off of the brief.<br>
Concurrency could be an issue with the approaches I took, such as the account creation method, but it wasn't part of the brief.<br>
I would have preferred to use a result type to manage exception handling in favour of throwing specific exceptions but kotlin doesn't support it as a return type yet.

## Assumptions
Currency wasn't immediately important to the test<br>
Transactional history/logging wasn't necessary despite being important in the real world.<br>

## Prerequisites
Java, Gradle.

## Languages
Kotlin/Java11, built via Gradle.<br>
Java<br>
Junit<br>

## Build
./gradlew build<br><br>

## Tests
./gradlew test<br>
You can see test reports in ./build/reports/tests/test/index.html
