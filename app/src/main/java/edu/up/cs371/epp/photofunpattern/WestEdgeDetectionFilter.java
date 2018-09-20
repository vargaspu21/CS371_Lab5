package edu.up.cs371.epp.photofunpattern;

import android.graphics.Color;

/**
 *  class BrightFilter changes the image manipulation behavior of its parent
 *  PhotoFilter to increase an image brightness by value of 100.
 *
 *  @author Edward C. Epp
 *  @version November 2017
 *  https://github.com/edcepp/PhotoFunPattern
 */

public class WestEdgeDetectionFilter extends PhotoFilter {

    //private final int ADJUSTMENT = 100;

    /*
    * transformPixel This method overrides the transformPixel in the parent
    * class. It adds 100 to each RGB color component. The maxium value of each
    * component is limited to 255
    *
    * @param inPixel is a 32 bit pixel that contains RGB color values
    * @return a new Pixel in which each of the RGB components has been increased
    */
    public int transformPixel(int onePixel, int twoPixel, int threePixel,int fourPixel, int fivePixel,
                              int sixPixel, int sevenPixel, int eightPixel, int ninePixel) {

        int red = constrain(Color.red(onePixel) + Color.red(twoPixel) + Color.red(threePixel)
                + (Color.red(fourPixel)*-2) + Color.red(fivePixel) + (Color.red(sixPixel)*-1)
                + (Color.red(sevenPixel)*-1) + (Color.red(eightPixel)*-1) + (Color.red(ninePixel)));
        int green = constrain(Color.green(onePixel) + Color.green(twoPixel) + Color.green(threePixel)
                + (Color.green(fourPixel)*-2) + Color.green(fivePixel) + (Color.green(sixPixel)*-1)
                + (Color.green(sevenPixel)*-1) + (Color.green(eightPixel)*-1) + (Color.green(ninePixel))));
        int blue = constrain(Color.blue(onePixel) + Color.blue(twoPixel) + Color.blue(threePixel)
                + (Color.blue(fourPixel)*-2) + Color.blue(fivePixel) + (Color.blue(sixPixel)*-1)
                + (Color.blue(sevenPixel)*-1) + (Color.blue(eightPixel)*-1) + (Color.blue(ninePixel))));
        int outPixel = Color.argb(Color.alpha(fivePixel), red, green, blue);
        return outPixel;
    }

}
