# SmartPay - A Simple Utility Bill Calculator

Welcome to SmartPay! This is a straightforward desktop app built with Java Swing to make calculating utility bills a bit easier. It gives you a simple window where you can enter your meter readings and get a detailed bill for electricity and water use in seconds.

---

## What It Can Do

- **Simple to Use:** It's a classic desktop app, so it's easy to figure out. No command line needed.
- **Calculates Based on Slabs:** The billing isn't just a flat rate. It uses different price slabs, so the more you use, the higher the rate, just like real utility bills.
- **See Your Bill Instantly:** As soon as you hit calculate, you'll see a full receipt right in the app.
- **Catches Mistakes:** The app checks for simple errors, like putting in text instead of numbers or if your old reading is higher than your new one.
- **Start Fresh:** A "Clear" button lets you wipe the fields clean for the next bill.

---

## Project Files

Here’s how the project is laid out:

```
SmartPay/
├── assets/
│   ├── Landing page.png
│   └── Bill receipt.png
├── src/
│   ├── Billable.java
│   ├── BillCalculator.java
│   ├── Customer.java
│   ├── Main.java
│   └── SmartPayGUI.java
├── .gitignore
└── README.md
```

---

## Getting It Running

Want to run it on your own machine? Here’s how.

1.  **Clone the Project:**
    First, you'll need to grab the files from GitHub. Open up your terminal and run this command:

    ```sh
    git clone https://github.com/asifforcode/SmartPay.git
    ```

2.  **Go to the Directory:**
    Once it's downloaded, hop into the project folder:

    ```sh
    cd SmartPay
    ```

3.  **Compile the Code:**
    Next, you need to compile the Java source files. This command gathers all the code in the `src` folder and gets it ready to run.

    ```sh
    javac -d out src/*.java
    ```

4.  **Run the App:**
    And finally, launch the application with this command.

    ```sh
    java -cp out Main
    ```

    The SmartPay window should pop right up on your screen!

---

## How to Use It

Using the app is pretty simple:

1.  Fire up the application.
2.  Type in the customer's name and their last and current meter readings.
3.  Hit the **"Calculate Bill"** button.
4.  The app does the math and shows you a full receipt in the text box.
5.  When you're ready to do another one, just click **"Clear"**.

---

## How Bills Are Calculated

The rates are based on how many units are used:

| Units Consumed | Price Per Unit |
| :------------- | :------------- |
| 0 to 100       | $1             |
| 101 to 300     | $2             |
| Over 300       | $5             |

After the main charge is calculated, a 10% tax is added to get the final amount.

---

## Screenshots

Here’s what the app looks like.

**The Main Screen:**
*This is what you see when you first open the app. Just fill in the fields and you're ready to go.*
![SmartPay Main UI](./assets/Landing%20page.png)

**The Bill Receipt:**
*After you hit calculate, you get a nice, clean receipt like this.*
![SmartPay Bill Receipt](./assets/Bill%20receipt.png)

