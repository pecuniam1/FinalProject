# FinalProject
This is my final project.
The entry point is Main.java

### [Click here for the github page](https://github.com/pecuniam1/FinalProject)

### Total Files
| File Name | Location | Description |
| --------- | -------- | ------------|
| .gitignore | / | This little guy? I wouldn\'t worry about this little guy |
| Main.java | /src/main/java/ | The entry point where the main method is |
| Drink.java | /src/main/java/ | Defines a drink object which is a child of MenuItem |
| Food.java | /src/main/java/ | Defines a food object which is a child of MenuItem |
| MenuItem.java | /src/main/java/ | The superclass for all menu items |
| MenuItemFactory.java | /src/main/java/ | This factory builds all of the MenuItem items |
| MyTestRunner.java | /src/test/java/ | The class I use for unit testing.
| README.md | / | You\'re reading this right now, so you know what this is. If not, see README.md |

### Notes
***
I was going to spend some time creating an app that was perfectly centered for any screen size, but that isn't the point of this exercise, and I was spending too much time on it, so if you need to change the resolution to match your screen (I can\'t image why you would), in Main.java, lines 9 and 10:
```java
private static int screen_width = 1920;
private static int screen_height = 1080;
```
***
The ```getFullMenu()``` method will provide the menu items. In a live version, this would query the database for the menu items.
