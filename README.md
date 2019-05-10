# ATMzero

Write simple ATM application.

App should offer following services:
- account creation
- money transfer
- account details printout

Account Creation

When account must be created use following parameters:
- account number(int)
- account's owner name(String)
- account balance(double)

Validation:
- prevent creation accounts with identical number
- prevent creation of accounts with negative account number
- prevent creation of accounts with negative balance

Money Transfer

During money transfer following parameteres must be used:
- source account(int)
- target account(int)
- amount for transfer(double)

If all elements are valid, application should add amount of money to target account and deduct amount of money from source account.

Validation:
- prevent money transfer if funds are insufficient on source account
- prevent money transfer if source account number is invalid / non-existing
- prevent money transfer if target account number is invalid / non-existing

