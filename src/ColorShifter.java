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

        return switch (nr) {
            case 0 -> Color.RED;
            case 1 -> Color.BLUE;
            case 2 -> Color.CYAN;
            case 3 -> Color.GREEN;
            case 4 -> Color.MAGENTA;
            case 5 -> Color.ORANGE;
            case 6 -> Color.YELLOW;
            case 7 -> Color.WHITE;
            case 8 -> new Color(134, 151, 239);
            default -> Color.BLACK;
        };
    }
}
