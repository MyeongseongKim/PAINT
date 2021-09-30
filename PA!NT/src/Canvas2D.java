import java.util.ArrayList;
import java.awt.*;
import javax.swing.JPanel;


public class Canvas2D extends JPanel {

    private static final Color COLOR_CUR_PEN_MARK = Color.BLACK;
    private static final Color COLOR_PEN_MARK = Color.GRAY;
    
    private static final Stroke STROKE_CUR_PEN_MARK = new BasicStroke(5f);
    private static final Stroke STROKE_PEN_MARK = new BasicStroke(5f);
    
    private App mApp;


    public Canvas2D(App app) {
        this.mApp = app;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        this.drawPenMarks(g2);
        this.drawCurPenMark(g2);
    }


    private void drawPenMarks(Graphics2D g2) {
        for (PenMark penMark : this.mApp.getPenMarks()) {
            this.drawPenMark(g2, penMark, COLOR_PEN_MARK, STROKE_PEN_MARK);
        }
    }

    private void drawCurPenMark(Graphics2D g2) {
        PenMark penMark = this.mApp.getCurPenMark();
        if (penMark != null) {
            this.drawPenMark(g2, penMark, COLOR_CUR_PEN_MARK, STROKE_CUR_PEN_MARK);
        }
    }

    private void drawPenMark(Graphics2D g2, PenMark penMark, Color c, Stroke s) {
        ArrayList<Point> pts = penMark.getPts();
        int n = pts.size();
        int[] xs = new int[n];
        int[] ys = new int[n];
        for (int i = 0; i < n; i++) {
            Point pt = pts.get(i);
            xs[i] = pt.x;
            ys[i] = pt.y;
        }

        g2.setColor(c);
        g2.setStroke(s);
        g2.drawPolyline(xs, ys, n);
    }
}
