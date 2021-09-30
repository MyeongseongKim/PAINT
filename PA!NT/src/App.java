import java.util.ArrayList;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;


public class App implements MouseListener, MouseMotionListener {

    private JFrame mFrame = null;
    private Canvas2D mCanvas = null;

    private PenMark mCurPenMark = null;
    public PenMark getCurPenMark() {
        return this.mCurPenMark;
    }

    private ArrayList<PenMark> mPenMarks = null;
    public ArrayList<PenMark> getPenMarks() {
        return this.mPenMarks;
    }


    public App() {
        this.mFrame = new JFrame("PA!NT");
        this.mFrame.setSize(900, 600);
        this.mFrame.setVisible(true);
        this.mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        this.mCanvas = new Canvas2D(this);
        this.mFrame.add(this.mCanvas);

        this.mCanvas.addMouseListener(this);
        this.mCanvas.addMouseMotionListener(this);

        this.mPenMarks = new ArrayList<PenMark>();
    }


    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        App appCanvas = new App();
    }



    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mouse pressed");  
        Point pt = e.getPoint();
        this.mCurPenMark = new PenMark(pt);
        this.mCanvas.repaint();
    }
    
    
    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("mouse dragged");
        Point pt = e.getPoint();
        this.mCurPenMark.addPt(pt);
        this.mCanvas.repaint();;
    }
    

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouse released");
        this.mPenMarks.add(mCurPenMark);
        this.mCurPenMark = null;
        this.mCanvas.repaint();
    }
    

    @Override
    public void mouseMoved(MouseEvent e) {
        // System.out.println("mouse moved");                
    }

    
    @Override
    public void mouseClicked(MouseEvent e) {
        // System.out.println("mouse clicked");        
    }
    

    @Override
    public void mouseEntered(MouseEvent e) {
        // System.out.println("mouse entered");        
    }
    
    
    @Override
    public void mouseExited(MouseEvent e) {
        // System.out.println("mouse exited");                
    }
}
