# SmartPay - Utility Bill Generator

SmartPay is a console-based Java project that calculates electricity and water bills based on how many units a customer has used.

---

## Project Structure

```
SmartPay/
├── assets/
│   └── Gui interface screenshots.png
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

**1. Clone the repository:**

```sh
git clone https://github.com/asifforcode/SmartPay.git
cd SmartPay
```

**2. Compile the code:**

```sh
javac -d out src/*.java
```

**3. Run the program:**

```sh
java -cp out Main
```

---

## Bill Rates

| Units Used    | Rate per Unit |
| :------------ | :------------ |
| 0 to 100      | $1            |
| 101 to 300    | $2            |
| Above 300     | $5            |

> 10% tax is added on top of the base amount.

---

## How It Works

1. You enter the customer name, old meter reading and new meter reading
2. It figures out how many units were used
3. Then calculates the bill using the slab rates above
4. Prints a simple receipt at the end
5. You can enter multiple customers one by one
6. Type `Exit` to stop the program

---

## Screenshot

Here is the program running in the console with a sample bill receipt:

<p align="center">
  <img src="./assets/Gui interface screenshots.png" alt="SmartPay Console Output" width="850"/>
</p>
