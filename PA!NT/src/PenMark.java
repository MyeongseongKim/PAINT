import java.util.ArrayList;
import java.awt.Point;


public class PenMark {

    private ArrayList<Point> mPts = null;
    public ArrayList<Point> getPts() {
        return this.mPts;
    }
    

    public PenMark(Point pt) {
        this.mPts = new ArrayList<Point>();
        this.mPts.add(pt);
    }
    
    
    public void addPt(Point pt) {
        this.mPts.add(pt);
    }
}
