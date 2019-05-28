
import java.awt.*;
import java.lang.reflect.Field;
import java.util.Random;

//create a public class called guitar
public class Guitar {
    //declare all fields that make up a guitar plus character and double arrays used for creating notes
    private int numStrings;
    private double guitarLength;
    private String guitarManufacturer;
    private Color guitarColor;
    static char arr [] = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
    static double length[] = new double[]{.25, .5, 1, 2, 4};

    //default constructor
    public Guitar(){
        this.numStrings = 6;
        this.guitarLength = 28.6;
        this.guitarManufacturer = "Gibson";
        this.guitarColor = Color.red;

    }
    //constructor
    public Guitar(int numStrings, double guitarLength, String guitarManufacturer, Color guitarColor){
        this.numStrings = numStrings;
        this.guitarLength = guitarLength;
        this.guitarManufacturer = guitarManufacturer;
        this.guitarColor = guitarColor;
    }


    //getter methods for each field
    public int getNumStrings() {
        return numStrings;
    }

    public double getGuitarLength() {
        return guitarLength;
    }

    public String getGuitarManufacturer() {
        return guitarManufacturer;
    }

    public Color getGuitarColor() {
        return guitarColor;
    }

    //this is the play guitar method that outputs random notes along with the lengths of each note
    public String playGuitar(){
        //initialize random variable
        Random randomGen = new Random();
        int n;
        int l;
        //initialize random variable
        Random randomGen2 = new Random();
        String play = "";
        play = play + "[";
        for(int i=0; i<16; i++){
            //generate random notes and lengths
            n = randomGen.nextInt(4);
            l = randomGen2.nextInt(4);
            if(i==15)
                play = play +arr[n]+ "("+length[l]+")" + " ]";
            else
                play = play +arr[n]+ "("+length[l]+")" + ", ";

        }
        return play;
    }

    //toString method to produce the dimensions of the guitar
    public String toString() {
        return "Guitar{" +
                "numStrings=" + numStrings +
                ", guitarLength=" + guitarLength +
                ", guitarManufacturer='" + guitarManufacturer + '\'' +
                ", guitarColor=" +convertColorToString(guitarColor)+
                '}';
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

