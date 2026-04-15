# SmartPay - Utility Bill Generator

This is a console based Java project. It calculates electricity and water bills based on how many units a customer has used.

---

## Project Structure

```
SmartPay/
├── src/
│   ├── Billable.java
│   ├── Customer.java
│   ├── BillCalculator.java
│   └── Main.java
├── .gitignore
└── README.md
```

---

## How to Run

First compile the code:
```
javac -d out src/*.java
```

Then run it:
```
java -cp out Main
```

---

## Bill Rates

| Units Used | Rate |
|------------|------|
| 0 to 100   | $1 per unit |
| 101 to 300 | $2 per unit |
| Above 300  | $5 per unit |

10% tax is added on top of the base amount.

---

## How it works

- You enter the customer name, old meter reading and new meter reading
- It figures out how many units were used
- Then calculates the bill using the slab rates above
- Prints a simple receipt at the end
- You can enter multiple customers one by one
- Type `Exit` to stop the program
