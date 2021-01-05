# square

## Written in Kotlin, solving the code challenge of bank in a box without state.

I created the bank as a singleton to compensate for a lack of persistent datastore.
Customers are simple classes with inbuilt methods, this made safety around null/negative values easier.

Values are all represented as BigDecimal's using java's BigDecimal library with standard float constraints, this is done
in order to handle financial transactions that require high degrees of accuracy
Tests focus on handling deposits/withdrawal that would result in a negative value as well as ensuring the bank can handle multiple
members, as well as ensuring that BigDecimal rounding is dealt with appropriately.

## Constraints
Constraints are primarily in scalability, you could implement the bank balance as a transaction ledger or more simply via
a transactional ACID compliant database.
Concurrency has not been considered as per the brief.

## Prerequisites
Java 11, Gradle.

## Languages
Kotlin/Java11, built via Gradle.
Java BigDecimal
Junit

## Build
./gradlew build

## Tests
./gradlew test
