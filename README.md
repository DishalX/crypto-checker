# Crypto Checker (Java Console App)

A Java console application that fetches real-time cryptocurrency prices using the CoinGecko API. The app lets users enter the name of any coin (e.g., "bitcoin", "ethereum") and displays:

- Current price in USD
- Market cap
- 24-hour price change percentage

## Features

- Real-time data from CoinGecko
- Clean and readable console interface
- Handles basic user input
- Easily extendable with additional coin data

## Technologies Used

- Java (11+)
- CoinGecko Public API (no key required)
- org.json (for parsing JSON responses)

## Sample Output

```
Enter a cryptocurrency name: Ethereum

--- Ethereum Stats ---
Price (USD): $1867.45
Market Cap: $225,768,000,000
24h Change: +2.65%
```

## How to Run

1. Download the `json-20210307.jar` from [here](https://repo1.maven.org/maven2/org/json/json/20210307/json-20210307.jar)
2. Compile the app:
   - macOS/Linux: `javac -cp .:json-20210307.jar CryptoChecker.java`
   - Windows: `javac -cp .;json-20210307.jar CryptoChecker.java`
3. Run the app:
   - macOS/Linux: `java -cp .:json-20210307.jar CryptoChecker`
   - Windows: `java -cp .;json-20210307.jar CryptoChecker`

## API Used

Data is retrieved from the free [CoinGecko API](https://www.coingecko.com/en/api), specifically the `simple/price` endpoint.

## Author

Dishal Xavier  
CSU Northridge - Computer Science Major 
[GitHub Profile](https://github.com/DishalX)
