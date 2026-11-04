# 🏦 DLC Vault Banking

> *Your money, tracked. Your history, secured.*

A Java console banking app for recording deposits and payments, reviewing account activity, and running financial reports. Every transaction is saved to a CSV file, so your history carries over between sessions.

---

## Features

| Screen | Options |
|---|---|
| **Home** | Add Deposit · Make Payment · View Ledger · Exit |
| **Ledger** | All Transactions · Deposits · Payments · Reports |
| **Reports** | Month to Date · Previous Month · Year to Date · Previous Year · Search by Vendor |

-- All ledger views and reports display **newest to oldest**.

## Built-In Safeguards

- **Crash-proof menus:** invalid input shows an error instead of stopping the app
- **Clean records:** descriptions and vendors are trimmed and require a minimum length
- **Accurate amounts:** must be a number greater than 0; payments are saved as negative automatically
- **Auto timestamps:** date and time are recorded for every transaction

## 🎨 Color-Coded Interface

| Color | Used For |
|---|---|
| 🔵 Steel Blue | Headers |
| 🟡 Gold | Menu options & dividers |
| 🟢 Green | Successful transactions |
| 🔴 Red | Errors |
| ⚪ Gray | Prompts & subtitles |

## Data File

`src/main/resources/Transaction.csv`

```
date|time|description|vendor|amount
2026-11-01|10:42:18|weekly groceries|Walmart|-86.47
```

## ▶️ How to Run

1. Open the project in **IntelliJ IDEA** (Java 17+).
2. Confirm `Transaction.csv` is in `src/main/resources/`.
3. Run `Main.java`.
4. Enter a menu number to navigate.

---

<p align="center"><i>Built by Jess Cruz · Thank you for choosing DLC Vault Banking.</i></p>