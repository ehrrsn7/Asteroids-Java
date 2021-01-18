# Asteroids

### Author: Elijah Harrison
<br>

Welcome to Java Asteroids! This program is a game. ** Deliverable coming soon. **

*[* Demonstration video goes here *]()*

## Development History

Version 0.0 - Java Project created

Version 0.1 - Game Loop and JFrame created

[Version 0.2](https://github.com/ehrrsn7/Asteroids-Java/commit/c3766469482f3e1356da85b02d75ef065ae09ce6) - 
Graphics working properly -
[See demonstration video here](https://youtu.be/7VTV3HpEoC4)<br>

## Development Environment

Coded using Visual Studio Code (See this [Visual Studio Code tutorial on setting up Java workflow](https://code.visualstudio.com/docs/languages/java))

---

## Relevant Links

Abstraction in Java - https://www.geeksforgeeks.org/abstract-methods-in-java-with-examples/

Common Painting Solutions in Java - https://docs.oracle.com/javase/tutorial/uiswing/painting/problems.html

JFrame screen dimensions getter - https://www.tutorialspoint.com/get-jframe-window-size-information-in-java

Bug: don't use setSize()/getSize(), use setPreferredSize() and getPreferredSize(). Why? Honestly, I don't know. - 
https://stackoverflow.com/questions/1783793/java-difference-between-the-setpreferredsize-and-setsize-methods-in-compone#:~:text=setSize%20will%20resize%20the%20component,re%2Dsized%20the%20component%20manually.&text=setSize%20sets%20the%20size%20of%20the%20component.

Dynamic Array: ArrayList syntax - 
https://www.callicoder.com/java-arraylist/#:~:text=ArrayList%20in%20Java%20is%20used,and%20implements%20Java's%20List%20interface.


## Notes:

Look up ```.clone()``` to 'duplicate' simple objects (shallow objects) -- specifically to duplicate "```point```" from ```ship``` in ```ship.fire()``` to pass to ```laser```

(note -- Brother Macbeth told me that this method doesn't work very well as a 'deep' duplicator. Aka it's fine to use with a ```point``` object but not very effective in copying very large objects.)

