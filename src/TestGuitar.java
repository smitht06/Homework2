import java.lang.reflect.Field;
import java.awt.Color;
public class TestGuitar {
    public static void main(String args[]){
            Guitar myGuitar = new Guitar(6, 45.9, "Charvel", Color.red);
            System.out.println("number of strings: " +myGuitar.getNumStrings());
            System.out.println("Guitar color: "+convertColorToString(myGuitar.getGuitarColor()));
            System.out.println("Manufacturer: "+myGuitar.getGuitarManufacturer());
            System.out.println("Guitar Length: " +myGuitar.getGuitarLength());
            System.out.println(myGuitar.playGuitar());
            System.out.println(myGuitar.toString());

            Guitar myGuitarTwo = new Guitar(12, 40, "Mitchell", Color.CYAN);
            System.out.println("number of strings: " +myGuitarTwo.getNumStrings());
            System.out.println("Guitar color: "+convertColorToString(myGuitarTwo.getGuitarColor()));
            System.out.println("Manufacturer: "+myGuitarTwo.getGuitarManufacturer());
            System.out.println("Guitar Length: " +myGuitarTwo.getGuitarLength());
            System.out.println(myGuitarTwo.playGuitar());
            System.out.println(myGuitarTwo.toString());

            Guitar myGuitarThree = new Guitar(1700,467,"NASA", Color.yellow);
            System.out.println();
    }



    public String toString() {
        return super.toString();

    }

    public static String convertColorToString(Color c) {
        for (Field f : Color.class.getFields()) {
            try {
                if (f.getType() == Color.class && f.get(null).equals(c)) {
                    return f.getName();
                }
            } catch (java.lang.IllegalAccessException e) {
            }
        }
        return c.toString();
    }
}