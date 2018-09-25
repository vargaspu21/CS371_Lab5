package edu.up.cs371.epp.photofunpattern;

import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.graphics.Bitmap;
        import android.graphics.drawable.BitmapDrawable;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
        import android.widget.Button;
        import android.view.View;
import android.widget.Spinner;

import java.util.ArrayList;

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


    private ImageView originalImageView;


    private ImageView myOriginalView;
    private ImageView myNewImageView;

    private String[] myImageNames;
    private ArrayList<Bitmap> myImageBmps;

    private void initSpinner (){
        Spinner spinner = (Spinner) findViewById(R.id.imageNames);
        myImageNames =
                getResources().getStringArray(R.array.imageNames);
        ArrayAdapter adapter = new ArrayAdapter<String> (this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                myImageNames);
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener
                (new MySpinnerListener());
    }



    private void initImageArray (){
        myImageBmps = new ArrayList<Bitmap>();
        TypedArray imageIds =
                getResources().obtainTypedArray(R.array.imageIdArray);

        for (int i=0; i<myImageNames.length; i++) {
            int id = imageIds.getResourceId(i, 0);
            if (id == 0)
                id = imageIds.getResourceId(0, 0);
            Bitmap bmp =
                    BitmapFactory.decodeResource(getResources(), id);
            myImageBmps.add(bmp);
        }
    }


    private class MySpinnerListener implements
            AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parentView,
                                   View selectedItemView,
                                   int position,
                                   long id){
            originalImageView.setImageBitmap
                    (myImageBmps.get(position));
            BitmapDrawable originalDrawableBmp =
                    (BitmapDrawable) originalImageView.getDrawable();
            myOriginalBmp = originalDrawableBmp.getBitmap();
        }

        public void onNothingSelected(AdapterView<?> parentView){

        }
    }





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

        originalImageView =
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

        Spinner spinnerButton = (Spinner) findViewById(R.id.imageNames);
        spinnerButton.setOnItemSelectedListener(new MySpinnerListener());


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

