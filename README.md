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
1001	2006	Vedant Raut	Rs 25000
1002	1985	Hemraj Raut Rs 100000
1003	1990	Sushma Raut	Rs 50000
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
🧠 Core Concepts Implemented
Classes & Objects
Encapsulation
HashMap & ArrayList
Loops and Conditional Statements
Exception Handling
LocalDateTime API
---
📌 Project Objective

The objective of this project is to understand and implement real-world banking operations using Core Java concepts in a simple ATM simulation system.
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
<img width="1918" height="1018" alt="Screenshot 2026-05-12 122756" src="https://github.com/user-attachments/assets/fa02d13c-1084-44a7-9546-e37de1bb4c0e" />
<img width="1918" height="1007" alt="Screenshot 2026-05-12 122839" src="https://github.com/user-attachments/assets/3a08f389-7d03-46a2-a287-e9eff83541d1" />
<img width="1915" height="1020" alt="Screenshot 2026-05-12 122813" src="https://github.com/user-attachments/assets/0eeefa66-67e6-45a9-bd6e-843c84128a62" />
<img width="1918" height="1031" alt="Screenshot 2026-05-12 122904" src="https://github.com/user-attachments/assets/6c4f21ca-84b0-4365-863b-de7ed71cc9b3" />
<img width="1912" height="1025" alt="Screenshot 2026-05-12 122922" src="https://github.com/user-attachments/assets/2d90a606-9006-427d-bfc4-184847c4a76b" />


