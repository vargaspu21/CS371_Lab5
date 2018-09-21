package edu.up.cs371.epp.photofunpattern;

import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.graphics.Bitmap;
        import android.graphics.drawable.BitmapDrawable;
        import android.widget.ImageView;
        import android.widget.Button;
        import android.view.View;

/**
 *  class PhotoFun controls this photo manipulation app.
 *
 *  @author  Edward C. Epp
 *  @version November 2017
 *   https://github.com/edcepp/PhotoFunPattern
 *
 */

public class PhotoFun extends AppCompatActivity {

    // Image resources
    private Bitmap myOriginalBmp;
    private ImageView myNewImageView;

    /*
    * onCreate This constructor lays out the user interface, initializes the
    * original image and links buttons to their actions.
    *
    * @param savedInstanceState Required by parent object
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_fun);

        ImageView originalImageView =
                (ImageView) findViewById(R.id.originalImage);
        BitmapDrawable originalDrawableBmp =
                (BitmapDrawable) originalImageView.getDrawable();
        myOriginalBmp = originalDrawableBmp.getBitmap();

        myNewImageView = (ImageView) findViewById(R.id.newImage);

        Button smoothenFilterButton =
                (Button) findViewById(R.id.smoothenFilterButton);
        smoothenFilterButton.setOnClickListener(new smoothenFilterButtonListener());
        Button westEdgeDetectionFilterButton =
                (Button) findViewById(R.id.westEdgeDetectionFilterButton);
        westEdgeDetectionFilterButton.setOnClickListener
                (new westEdgeDetectionFilterButtonListener());
    }

    /*
    * class grayFilterButtonListener this inner class defines the action for
    * the gray filter button.
    */
    private class smoothenFilterButtonListener implements View.OnClickListener {
        public void onClick(View button) {
            SmoothenFilter filter = new SmoothenFilter();
            myNewImageView.setImageBitmap(filter.apply(myOriginalBmp));
        }
    }
    
    /*
    * class grayFilterButtonListener this inner class defines the action for the
    * brightness filter
    * button.
    */
    private class westEdgeDetectionFilterButtonListener
            implements View.OnClickListener {
        public void onClick(View button) {
            WestEdgeDetectionFilter filter = new WestEdgeDetectionFilter();
            myNewImageView.setImageBitmap(filter.apply(myOriginalBmp));
        }
    }
}

