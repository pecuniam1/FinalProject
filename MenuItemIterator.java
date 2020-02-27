// import java.util.Iterator;

// class MenuItemIterator<MenuItem> implements Iterable<MenuItem> {
//     private MenuItem[] menuItemArray;
//     private int size;

//     public MenuItemIterator(MenuItem[] array) {
//         this.menuItemArray = array;
//         this.size = menuItemArray.length;
//     }

//     @Override
//     public Iterator<MenuItem> iterator() {
//         Iterator<MenuItem> it = new Iterator<MenuItem>() {
//             private int index = 0;

// 			@Override
// 			public boolean hasNext() {
// 				return index < size && menuItemArray[index] != null;
// 			}

// 			@Override
// 			public MenuItem next() {
// 				return menuItemArray[index++];
//             }
            
//             @Override
//             public void remove() {
//                 throw new UnsupportedOperationException();
//             }
//             return it;
//         }
//     }
// }