/**
 * Created by Tomas Dahlander <br>
 * Date: 2020-11-21 <br>
 * Time: 15:07 <br>
 * Project: ScreenSaver <br>
 */
public class MotionTracker {

    private final int gridSizeRow;
    private final int gridSizeCol;

    private int row;
    private int col;

    private char headingVertical = 'N';
    private char headingHorizontal = 'E';

    public MotionTracker(int row, int col, int gridSizeRow, int gridSizeCol){
        this.row = row;
        this.col = col;
        this.gridSizeRow = gridSizeRow;
        this.gridSizeCol = gridSizeCol;
    }

    public boolean isInCorner(){
        if(row == 0 && col == 0) return true;
        else if(row == 0 && col == gridSizeCol-1) return true;
        else if(row == gridSizeRow-1 && col == 0) return true;
        else if(row == gridSizeRow-1 && col == gridSizeCol-1) return true;
        else return false;
    }

    public void backOutOfCorner(){
        if(headingVertical == 'N') headingVertical = 'S';
        else headingVertical = 'N';
        if(headingHorizontal == 'E') headingHorizontal = 'W';
        else headingHorizontal = 'E';
    }

    public void updateTrackerLocation(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public char getHeadingVertical() {
        return headingVertical;
    }

    public void setHeadingVertical(char headingVertical) {
        this.headingVertical = headingVertical;
    }

    public char getHeadingHorizontal() {
        return headingHorizontal;
    }

    public void setHeadingHorizontal(char headingHorizontal) {
        this.headingHorizontal = headingHorizontal;
    }
}
