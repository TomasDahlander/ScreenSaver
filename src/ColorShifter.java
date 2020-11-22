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
        int nr = rand.nextInt(7);

        if (nr == 0) return Color.RED;
        else if (nr == 1) return Color.BLUE;
        else if (nr == 2) return Color.CYAN;
        else if (nr == 3) return Color.GREEN;
        else if (nr == 4) return Color.MAGENTA;
        else if (nr == 5) return Color.ORANGE;
        else return Color.YELLOW;
    }
}
