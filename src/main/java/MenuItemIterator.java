package src.main.java;

import java.util.ArrayList;
import java.util.Iterator;

public class MenuItemIterator implements Iterator {
    ArrayList<MenuItem> list;
    int position = 0;

    public MenuItemIterator(ArrayList<MenuItem> list) {
        this.list = list;
    }

    public boolean hasNext() {
        return position > list.size();
    }

   public MenuItem next() {
        return (MenuItem) list.get(position);
   }

   public void add(MenuItem mi) {
       list.add(mi);
       position++;
   }
}
