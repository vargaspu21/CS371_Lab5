package edu.up.cs371.epp.photofunpattern;

import android.graphics.Color;

/**
 *  class GrayFilter changes the image manipulation behavior of its parent
 *  PhotoFilter to convert the image to gray scale.
 *
 *  @author Edward C. Epp
 *  @version November 2017
 *  https://github.com/edcepp/PhotoFunPattern
 */

public class SmoothenFilter extends PhotoFilter {

    /*
    * tranformPixel This method overrides the transformPixel in the parent
    * class. It transforms a color pixel to gray by averaging its three RGB
    * components.
    *
    * @param inPixel is a 32 bit pixel that contains RGB color values
    * @return a new Pixel in which each of the RGB components is their averaged
    * value
    */
    public int transformPixel(int onePixel, int twoPixel, int threePixel,int fourPixel, int fivePixel,
                              int sixPixel, int sevenPixel, int eightPixel, int ninePixel) {
        double red = constrain(Color.red(onePixel) + (Color.red(twoPixel)*(1/10)) + (Color.red(threePixel)*(1/10))
        + (Color.red(fourPixel)*(1/10)) + (Color.red(fivePixel)*(1/5)) + (Color.red(sixPixel)*(1/10))
        + (Color.red(sevenPixel)*(1/10)) + (Color.red(eightPixel)*(1/10)) + Color.red(ninePixel)*(1/10));
        int green = constrain(Color.green(onePixel) + (Color.green(twoPixel)*(1/10)) + (Color.green(threePixel)*(1/10))
                + (Color.green(fourPixel)*(1/10)) + (Color.green(fivePixel)*(1/5)) + (Color.green(sixPixel)*(1/10))
                + (Color.green(sevenPixel)*(1/10)) + (Color.green(eightPixel)*(1/10)) + Color.green(ninePixel)*(1/10));
        int blue = constrain(Color.blue(onePixel) + (Color.blue(twoPixel)*(1/10)) + (Color.blue(threePixel)*(1/10))
                + (Color.blue(fourPixel)*(1/10)) + (Color.blue(fivePixel)*(1/5)) + (Color.blue(sixPixel)*(1/10))
                + (Color.blue(sevenPixel)*(1/10)) + (Color.blue(eightPixel)*(1/10)) + Color.blue(ninePixel)*(1/10));
        // int intensity = (Color.red(fivePixel) + Color.green(fivePixel) +
                //Color.blue(fivePixel)) / 3;
        return Color.argb(Color.alpha(fivePixel), red,green,blue);
    }

}
