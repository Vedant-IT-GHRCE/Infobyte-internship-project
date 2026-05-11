Java ATM Machine 🏧
A simple ATM Machine simulation using Core Java only — no frameworks, no external libraries.
---
📁 Project Structure
```
ATMMachine/
└── src/
    └── atm/
        ├── Main.java          → Entry point
        ├── Bank.java          → Manages all accounts
        ├── Account.java       → Account data + PIN validation + balance logic
        ├── ATM.java           → Session handling, menu, user interaction
        └── Transaction.java   → Stores transaction records with timestamp
```
---
▶️ How to Run
Using Terminal (Command Line)
```bash
# Step 1: Compile
javac -d out src/atm/*.java

# Step 2: Run
java -cp out atm.Main
```
Using IntelliJ IDEA / Eclipse
Open the `ATMMachine` folder as a project
Set `src` as the source root
Run `Main.java`
---
🧾 Demo Accounts (Pre-loaded)
Account No	PIN	Holder Name	Balance
0121	2006	Vedant Raut	Rs 25000
0122	1985	Hemraj Raut Rs 100000
0123	1990	Sushma Raut	Rs 50000
---
✅ Features
🔐 Login with Account Number + PIN
🔁 3 PIN attempts before card block
💰 Check Balance
⬆️ Deposit money
⬇️ Withdraw money (with insufficient balance check)
📋 Mini Statement — shows all transactions of current session with timestamp
🚪 Exit / Eject Card and switch accounts
---
🧠 Core Java Concepts Used
Concept	Where Used
Classes & Objects	Account, Bank, ATM, Transaction
Encapsulation	Private fields + getters/setters
HashMap	Bank stores accounts by account no
ArrayList	Transaction history per session
Scanner	Console input from user
Loops & Conditionals	Menu navigation, PIN retry logic
String methods	PIN comparison, input parsing
Exception Handling	Invalid amount input (try-catch)
LocalDateTime	Transaction timestamps
String.format	Formatted console output
---
📸 Sample Output
```
  ╔══════════════════════════════════════╗
  ║        JAVA ATM MACHINE v1.0         ║
  ║     Insert Card to Get Started       ║
  ╚══════════════════════════════════════╝

  Enter Account Number: 0121
  Enter PIN: 2006
  ✓ Welcome, Vedant Raut !

  ┌──────────────────────────┐
  │        ATM MENU          │
  ├──────────────────────────┤
  │  1. Check Balance        │
  │  2. Deposit              │
  │  3. Withdraw             │
  │  4. Mini Statement       │
  │  5. Exit / Eject Card    │
  └──────────────────────────┘

  Choose option: 1
  ┌─────────────────────────────────┐
  │  Available Balance: Rs 50000.00 │
  └─────────────────────────────────┘
```
