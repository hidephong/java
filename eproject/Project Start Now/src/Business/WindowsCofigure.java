/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Nha.HV
 */
public class WindowsCofigure {
       private void setLocation(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth())/2);
        int y = (int) ((dimension.getHeight() - getHeight())/2);
        setLocation(x,y);
    }

    private double getWidth() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private double getHeight() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void setLocation(int x, int y) {
        throw new UnsupportedOperationException("Not yet implemented");
    }


}
