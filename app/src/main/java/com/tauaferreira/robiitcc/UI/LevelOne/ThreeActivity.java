package com.tauaferreira.robiitcc.UI.LevelOne;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tauaferreira.robiitcc.R;

import org.xmlpull.v1.XmlPullParser;

public class ThreeActivity extends AppCompatActivity {
    private static final String IMAGEVIEW_TAG = "icon bitmap";


    @SuppressLint({"ResourceType", "ClickableViewAccessibility"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_template_container);
        View view1 = getLayoutInflater().inflate(R.layout.create_robot_shapes, null);

       FrameLayout fl2 = findViewById(R.id.fl_container_content);
       fl2.addView(view1);
        ImageView btBack = findViewById(R.id.button_backArrow);


        btBack.setOnClickListener(v->{
            this.finish();
        });

        ImageView imageViewTriangle = findViewById(R.id.black_triangle);
        imageViewTriangle.setTag(IMAGEVIEW_TAG);

        ImageView imageViewResult = findViewById(R.id.graph_level);

        imageViewTriangle.setOnLongClickListener(v -> {

            String clipText = "Tanto faz";
            ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());

            ClipData dragData = new ClipData(
                    (CharSequence) v.getTag(),
                    new String[] { ClipDescription.MIMETYPE_TEXT_PLAIN },
                    item);


            View.DragShadowBuilder myShadow = new View.DragShadowBuilder(imageViewTriangle);

            v.startDragAndDrop(dragData,  // The data to be dragged
                    myShadow,  // The drag shadow builder
                    null,      // No need to use local data
                    0          // Flags (not currently used, set to 0)
            );

            v.setVisibility(View.INVISIBLE);


            return true;
        });

        int windowwidth = getWindowManager().getDefaultDisplay().getWidth();
        int windowheight = getWindowManager().getDefaultDisplay().getHeight();

        imageViewTriangle.setOnTouchListener((v, event) -> {

            switch(event.getActionMasked())
            {
                case MotionEvent.ACTION_DOWN:
                    break;
                case MotionEvent.ACTION_MOVE:
                    int x_cord = (int) event.getRawX();
                    int y_cord = (int) event.getRawY();
                    if (x_cord > windowwidth) {
                        x_cord = windowwidth;
                    }
                    if (y_cord > windowheight) {
                        y_cord = windowheight;
                    }
                    System.out.println("X:" + x_cord +"- Y:" + y_cord);
                    if(x_cord > imageViewResult.getX() - 100 && x_cord < imageViewResult.getX() + 100 && y_cord > imageViewResult.getY() -100 &&  y_cord < imageViewResult.getY() +100){
                    Drawable drawable= getResources().getDrawable(R.drawable.phases_create_shape_circle);
                    imageViewResult.setImageDrawable(drawable);}
                    break;
                default:
                    break;
            }
            return true;
        });

//
//         imageView.setOnDragListener((v, e) -> {
//            switch(e.getAction()) {
//
//                case DragEvent.ACTION_DRAG_STARTED:
//                   Float lc = e.getX();
//                    System.out.println(lc.toString());
//                    // Determines if this View can accept the dragged data.
//                    if (e.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
//
//                        // As an example of what your application might do, applies a blue color tint
//                        // to the View to indicate that it can accept data.
//                        ((ImageView)v).setColorFilter(Color.BLUE);
//
//                        // Invalidate the view to force a redraw in the new tint.
//                        v.invalidate();
//
//                        // Returns true to indicate that the View can accept the dragged data.
//                        return true;
//
//                    }
//
//                    // Returns false to indicate that, during the current drag and drop operation,
//                    // this View will not receive events again until ACTION_DRAG_ENDED is sent.
//                    return false;
//
//                case DragEvent.ACTION_DRAG_ENTERED:
//
//                  // Invalidates the view to force a redraw in the new tint.
//                    v.invalidate();
//
//                    // Returns true; the value is ignored.
//                    return true;
//
//                case DragEvent.ACTION_DRAG_LOCATION:
//
//                    // Ignore the event.
//                    return true;
//
//                case DragEvent.ACTION_DRAG_EXITED:
//
//                    // Resets the color tint to blue.
//                    ((ImageView)v).setColorFilter(Color.BLUE);
//
//                    // Invalidates the view to force a redraw in the new tint.
//                    v.invalidate();
//
//                    // Returns true; the value is ignored.
//                    return true;
//
//                case DragEvent.ACTION_DROP:
//
//                    // Gets the item containing the dragged data.
//                    ClipData.Item item = e.getClipData().getItemAt(0);
//
//                    // Gets the text data from the item.
//                    CharSequence dragData = item.getText();
//
//                    // Displays a message containing the dragged data.
//                    Toast.makeText(this, "Dragged data is " + dragData, Toast.LENGTH_LONG).show();
//
//                    // Turns off any color tints.
//                    ((ImageView)v).clearColorFilter();
//
//                    // Invalidates the view to force a redraw.
//                    v.invalidate();
//
//                    // Returns true. DragEvent.getResult() will return true.
//                    return true;
//
//                case DragEvent.ACTION_DRAG_ENDED:
//
//                    // Turns off any color tinting.
//                    ((ImageView)v).clearColorFilter();
//
//                    // Invalidates the view to force a redraw.
//                    v.invalidate();
//
//                    // Does a getResult(), and displays what happened.
//                    if (e.getResult()) {
//                        Toast.makeText(this, "The drop was handled.", Toast.LENGTH_LONG).show();
//                    } else {
//                        Toast.makeText(this, "The drop didn't work.", Toast.LENGTH_LONG).show();
//                    }
//
//                    // Returns true; the value is ignored.
//                    return true;
//
//                // An unknown action type was received.
//                default:
//                    Log.e("DragDrop Example","Unknown action type received by View.OnDragListener.");
//                    break;
//            }
//            return false;
//        });
    }
}
