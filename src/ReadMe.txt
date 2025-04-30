Make sure you have python or python 3 installed in your computer, and also chromedriver which is the same version as google chrome you use.
To deploy this app:
Go to Terminal:  cd /Users/prakarsha/Downloads/chromedriver-mac-x64/chromedriver  (Replace this file location to your chromedriver.exe file location)
Go to Terminal: python3 -m http.server 8000
Now you should have the app running: http://localhost:8000/calculator.html
Now, go to CalculatorWebTest.java, and replace location to your file location: 
System.setProperty("webdriver.chrome.driver", "/Users/prakarsha/Downloads/chromedriver-mac-x64/chromedriver"); //Your file location

Testing GUI:
Click on Run CalculatorWebTest.java

Testing Model:
Click on Run CalculatorModel.java

You should see all tests running and green bar as all test cases work as expected.
