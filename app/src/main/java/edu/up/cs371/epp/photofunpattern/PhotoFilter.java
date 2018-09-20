package edu.up.cs371.epp.photofunpattern;

import android.graphics.Bitmap;

/**
 *  class PhotoFilter is the abstract filter parent class. Its default behavior
 *  is the leave an image unchanged.
 *
 *  @author Edward C. Epp
 *  @version November 2017
 *  https://github.com/edcepp/PhotoFunPattern
 */
public abstract class PhotoFilter {

    /*
    * constrain This method does not permit an RGB color value to over or under
    * saturate. It maintains values between 0 and 255 inclusive.
    *
    * @param inPixel is an integer input color component value that may be out
    *                of range
    * @return a new color component in range
    */
    protected int constrain(int color) {
        if (color > 255)
            return 255;
        else if (color < 0)
            return 0;
        else
            return color;
    }

    /*
    * tranformPixel This is the default transform method. It leaves the pixel
    * unchanged. It implements a copy image function.
    *
    * @param inPixel is a 32 bit pixel that contains RGB color values
    * @return a new Pixel in which unchanged color components
    */
    protected int transformPixel (int onePixel, int twoPixel, int threePixel,int fourPixel, int fivePixel,
                                  int sixPixel, int sevenPixel, int eightPixel, int ninePixel){
        return fivePixel;
    }

    /*
    * apply This method visits every pixel in the input image. It applies a
    * transform to each pixel.
    *
    * @param inBmp is the original image
    * @return a new image in which each pixel has been transformed
    */
    public Bitmap apply(Bitmap inBmp) {
        int width = inBmp.getWidth();
        int height = inBmp.getHeight();

        Bitmap newBmp = Bitmap.createBitmap(width, height, inBmp.getConfig());

        for (int w = 1; w < width-1; w++) {
            for (int h = 1; h < height-1; h++) {
                    int onePixel = inBmp.getPixel(w - 1, h - 1);
                    int twoPixel = inBmp.getPixel(w, h - 1);
                    int threePixel = inBmp.getPixel(w + 1, h - 1);
                    int fourPixel = inBmp.getPixel(w - 1, h);
                    int fivePixel = inBmp.getPixel(w, h);
                    int sixPixel = inBmp.getPixel(w + 1, h);
                    int sevenPixel = inBmp.getPixel(w - 1, h + 1);
                    int eightPixel = inBmp.getPixel(w, h + 1);
                    int ninePixel = inBmp.getPixel(w + 1, h + 1);
                    int outPixel = transformPixel(onePixel, twoPixel, threePixel, fourPixel, fivePixel,
                            sixPixel, sevenPixel, eightPixel, ninePixel);
                    newBmp.setPixel(w, h, outPixel);

            }
        }
        return newBmp;
    }
}
