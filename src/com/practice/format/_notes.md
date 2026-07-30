## DateTime Notes

- Remember that the parse() method of **DateFormat** and **NumberFormat** throws java.text.ParseException. 
  - So, it must either be declared in the throws clause of the main() method or the call to parse() must be wrapped in a try/catch block
    - `NumberFormat formatter = NumberFormat.getInstance(fr);`
    - `String s = formatter.format(amount) ;`
    - `Number amount2 = formatter.parse(s);`