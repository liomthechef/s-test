# square

# Written in Kotlin, solving the code challenge of bank in a box without state.
# I've aimed the tests at ensuring deposit and withdrawal functionality are sound

# Bank was implemented as a singleton which can only be instantiated once.
# Constraints are primarily in the way the bank balance has been implemented. While Kotlin limits concurrency
# in this case there's not much scalability, ideally the bank balance would be inferred as a ledger and a balance
# inferred this way for a more performant model, this would permit higher throughput without creating safety issues
