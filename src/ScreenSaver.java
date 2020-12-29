import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ScreenSaver extends JFrame {

    MotionTracker tracker;
    ColorShifter colorShifter = new ColorShifter();
    Color color;
    javax.swing.Timer timer;

    private final JPanel grid = new JPanel();
    private final int rows = 27;
    private final int cols = 54;
    JLabel[][] labels = new JLabel[rows][cols];

    String dot = '\u25CF' + "";

    public ScreenSaver() {
        tracker = new MotionTracker(5, 8, rows, cols);

        setUpBoard();
        setUpListeners();

        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void setUpListeners(){
        KeyAdapter arrows = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) tracker.setHeadingVertical('N');
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) tracker.setHeadingVertical('S');
                else if (e.getKeyCode() == KeyEvent.VK_LEFT) tracker.setHeadingHorizontal('W');
                else if (e.getKeyCode() == KeyEvent.VK_RIGHT) tracker.setHeadingHorizontal('E');
            }
        };
        addKeyListener(arrows);

        ActionListener time = e -> {
            recalculate();
            repaint();
        };
        timer = new javax.swing.Timer(25, time);
        timer.start();
    }

    public void setUpBoard() {
        grid.setLayout(new GridLayout(rows, cols));
        setLayout(new BorderLayout());
        add(grid, BorderLayout.CENTER);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                labels[i][j] = new JLabel("", SwingConstants.CENTER);
                labels[i][j].setFont(new Font("SansSerif", Font.BOLD, 29));
                labels[i][j].setPreferredSize(new Dimension(30, 30));
                labels[i][j].setOpaque(true);
                grid.add(labels[i][j]);
            }
        }
        labels[tracker.getRow()][tracker.getCol()].setText(dot);
    }

    public void recalculate() {
        if (tracker.isInCorner()) {
            tracker.backOutOfCorner();
            color = colorShifter.getColor();
        }
        else {
            if (tracker.getRow() == 0 && tracker.getHeadingVertical() == 'N') {
                tracker.setHeadingVertical('S');
                color = colorShifter.getColor();
            }
            if (tracker.getCol() == 0 && tracker.getHeadingHorizontal() == 'W'){
                tracker.setHeadingHorizontal('E');
                color = colorShifter.getColor();
            }
            if (tracker.getRow() == rows - 1 && tracker.getHeadingVertical() == 'S'){
                tracker.setHeadingVertical('N');
                color = colorShifter.getColor();
            }
            if (tracker.getCol() == cols - 1 && tracker.getHeadingHorizontal() == 'E'){
                tracker.setHeadingHorizontal('W');
                color = colorShifter.getColor();
            }
        }
    }

    @Override
    public void repaint(){
        labels[tracker.getRow()][tracker.getCol()].setText("");

        int tempRow = tracker.getRow();
        int tempCol = tracker.getCol();

        if(tracker.getHeadingVertical() == 'N') tempRow--;
        else tempRow++;
        if(tracker.getHeadingHorizontal() == 'W') tempCol--;
        else tempCol++;

        tracker.updateTrackerLocation(tempRow,tempCol);
        labels[tracker.getRow()][tracker.getCol()].setText(dot);
        labels[tracker.getRow()][tracker.getCol()].setBackground(color);
    }

    public static void main(String[] args) {
        new ScreenSaver();
    }
}
