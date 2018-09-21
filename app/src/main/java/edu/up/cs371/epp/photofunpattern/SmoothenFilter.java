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

        int red = constrain(((Color.red(onePixel) + Color.red(twoPixel) + Color.red(threePixel) + Color.red(fourPixel)
                + Color.red(fivePixel) + Color.red(sixPixel) + Color.red(sevenPixel) + Color.red(eightPixel) + Color.red(ninePixel))/ 10)
                + (Color.red(fivePixel)/5));
        int green = constrain(((Color.green(onePixel) + Color.green(twoPixel) + Color.green(threePixel) + Color.green(fourPixel)
                + Color.green(fivePixel) + Color.green(sixPixel) + Color.green(sevenPixel) + Color.green(eightPixel) + Color.green(ninePixel))/ 10)
                + (Color.green(fivePixel)/5));
        int blue = constrain(((Color.blue(onePixel) + Color.blue(twoPixel) + Color.blue(threePixel) + Color.blue(fourPixel)
                + Color.blue(fivePixel) + Color.blue(sixPixel) + Color.blue(sevenPixel) + Color.blue(eightPixel) + Color.blue(ninePixel))/ 10)
                + (Color.red(fivePixel)/5));

        return Color.argb(Color.alpha(fivePixel), red, green, blue);
    }

}
