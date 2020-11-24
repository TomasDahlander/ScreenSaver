import java.awt.*;
import java.util.Random;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2020-11-21 <br>
 * Time: 17:03 <br>
 * Project: ScreenSaver <br>
 */
public class ColorShifter {

    public Color getColor(){
        Random rand = new Random();
        int nr = rand.nextInt(10);

        if (nr == 0) return Color.RED;
        else if (nr == 1) return Color.BLUE;
        else if (nr == 2) return Color.CYAN;
        else if (nr == 3) return Color.GREEN;
        else if (nr == 4) return Color.MAGENTA;
        else if (nr == 5) return Color.ORANGE;
        else if (nr == 6) return Color.YELLOW;
        else if (nr == 7) return Color.WHITE;
        else if (nr == 8) return new Color(134, 151, 239);
        else return Color.BLACK;
    }
}
