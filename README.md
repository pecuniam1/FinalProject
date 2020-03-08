# FinalProject
This is my final project.
The entry point is Main.java

### [Click here for the github page](https://github.com/pecuniam1/FinalProject)

### Design Patterns
| Pattern | Class | Description |
| --------- | -------- | ------------|
| Factory | src/main/javaMenuItemFactory | This is the factory that builds all of the menu items. |
| Inheritance | src/main/java/MenuItem | Drink and Food are children of this class. |
| Iterator | src/main/MenuItemIterator | The iterator for MenuItems. This makes it so I can just loop through MenuItems. |

## Reflections
---
### **What I found easy.**
The easist part of designing this program was making reusable methods for small objects like JPanels. My first attempt at this program was one giant class that was difficult to really work through because all of the functionality was in one method and it was static. When something didn't work, I created small pieces of code that I knew would work (this would have been a great time to implement unit testing). I ended up taking most of those small pieces of code out and moving them to the ViewBuilder and the Factory.
### **What I found difficult**
Not using global variables. I tried so hard not to declare 2 JPanels as global objects, but I was spending too much time on it. Also, I found designing the view very cumbersome. I am so used to view templates, that I had forgotten how java has these built-in view objects. I had a hard time positioning and adding to the panels. I never did find a way to add large amounts of text to a panel without using either labels or textboxes.
### **What I would do differently next time**
Obviously besides making it look better, test-driven development. I would have started with small pieces of code, unit tested them, then put it in a class and move on. It\'s much easier to diagnose a problem in 5 lines of code instead of 200. Secondly, I would have tried to implement some kind of multi-threaded application. Even if it was as simple as calling all of the methods in the ViewBuilder at the same time. I\'ve never really programmed a mult-threaded application, and I would like some progress. Finally, I would have spent more time before it was due working on it. Even though I started working on this weeks ago, I never really felt motivated to *really* work on it until the last 2 weeks.
