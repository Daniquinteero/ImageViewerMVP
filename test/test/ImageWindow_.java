package test;

import imageviewer.architecture.ImageWindow;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ImageWindow_ {
    private Case c;

    public ImageWindow_(Case c) {
        this.c = c;
    }
    
    @Test
    public void execute() {
        ImageWindow window = new ImageWindow(c.imageWidth, c.imageHeight).adjustTo(c.panelWidth, c.panelHeight);
        assertEquals(c.x, window.x());
        assertEquals(c.y, window.y());
        assertEquals(c.width, window.width());
        assertEquals(c.height, window.height());
    }
    
    @Parameters
    public static List<Case> cases() {
        List<Case> list = new ArrayList<>();
        list.add(new Case(200,200,400,400,100,100,200,200));
        list.add(new Case(200,200,100,100,0,0,100,100));
        list.add(new Case(200,200,100,200,0,50,100,100));
        list.add(new Case(200,200,200,100,50,0,100,100));
        return list;
    }
    
    
    public static class Case {
        int imageWidth;
        int imageHeight;
        int panelWidth;
        int panelHeight;
        
        int x;
        int y;
        int width;
        int height;

        public Case(int imageWidth, int imageHeight, int panelWidth, int panelHeight, int x, int y, int width, int height) {
            this.imageWidth = imageWidth;
            this.imageHeight = imageHeight;
            this.panelWidth = panelWidth;
            this.panelHeight = panelHeight;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
        
    }
    
}
