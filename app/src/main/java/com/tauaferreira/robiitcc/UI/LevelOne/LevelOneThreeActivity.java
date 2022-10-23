package com.tauaferreira.robiitcc.UI.LevelOne;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tauaferreira.robiitcc.R;
import com.tauaferreira.robiitcc.Utils.BluetoothSocketClass;

public class LevelOneThreeActivity extends AppCompatActivity {

    View.OnLongClickListener longClickListener = v -> {
        ClipData data = ClipData.newPlainText("", "");
        View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);

        v.startDrag(data, myShadowBuilder, v, 0);

        return false;
    };
    ImageView imageViewResult;
    TextView mTxt;

    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            BluetoothSocketClass btSocket = new BluetoothSocketClass();
            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:

                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    final View view = (View) event.getLocalState();
                    if (view.getId() == R.id.white_triangle) {
                        Drawable drawable = getResources().getDrawable(R.drawable.phases_create_shape_white_triangle);
                        imageViewResult.setImageDrawable(drawable);
                        mTxt.setText("EI! Arraste a estrela, não o triângulo !!!!");

                        boolean sendMessage = btSocket.sendCommandToArduino("e");


                    } else if (view.getId() == R.id.black_triangle) {
                        Drawable drawable = getResources().getDrawable(R.drawable.phases_create_shape_black_triangle);
                        imageViewResult.setImageDrawable(drawable);
                        mTxt.setText("EI! Arraste a estrela, não o triângulo !!!!");
                        boolean sendMessage = btSocket.sendCommandToArduino("e");
                    } else if (view.getId() == R.id.white_circle || view.getId() == R.id.white_circle2) {
                        Drawable drawable = getResources().getDrawable(R.drawable.phases_create_shape_circle);
                        imageViewResult.setImageDrawable(drawable);
                        mTxt.setText("EI! Arraste a estrela, não o círculo !!!!");
                        boolean sendMessage = btSocket.sendCommandToArduino("e");
                    } else if (view.getId() == R.id.white_star) {
                        Drawable drawable = getResources().getDrawable(R.drawable.phases_create_shape_star);
                        imageViewResult.setImageDrawable(drawable);

                        boolean sendMessage = btSocket.sendCommandToArduino("c");

                        startActivity(new Intent(getBaseContext(), LevelOneFourActivity.class));
                    } else if (view.getId() == R.id.black_square) {
                        Drawable drawable = getResources().getDrawable(R.drawable.phases_create_shape_rectangle);
                        imageViewResult.setImageDrawable(drawable);
                        mTxt.setText("EI! Arraste a estrela, não o quadrado!!!!");
                        boolean sendMessage = btSocket.sendCommandToArduino("e");
                    }

                    break;
            }
            return true;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_template_container);

        imageViewResult = findViewById(R.id.graph_level);

        View view1 = getLayoutInflater().inflate(R.layout.create_robot_shapes, null);

        FrameLayout fl2 = findViewById(R.id.fl_container_content);
        fl2.addView(view1);

        ImageView btBack = findViewById(R.id.button_backArrow);
        btBack.setOnClickListener(v -> {
            this.finish();
        });



        ImageView imageViewWhiteTriangle = findViewById(R.id.white_triangle);
        ImageView imageViewBlackTriangle = findViewById(R.id.black_triangle);
        ImageView imageViewWhiteCircle = findViewById(R.id.white_circle);
        ImageView imageViewWhiteCircle2 = findViewById(R.id.white_circle2);
        ImageView imageViewStar = findViewById(R.id.white_star);

        ImageView imageViewSquare = findViewById(R.id.black_square);
        Drawable drawable = getResources().getDrawable(R.drawable.phases_create_shape_star);
        imageViewResult.setImageDrawable(drawable);


        imageViewBlackTriangle.setOnLongClickListener(longClickListener);
        imageViewWhiteTriangle.setOnLongClickListener(longClickListener);
        imageViewWhiteCircle.setOnLongClickListener(longClickListener);
        imageViewWhiteCircle2.setOnLongClickListener(longClickListener);

        imageViewSquare.setOnLongClickListener(longClickListener);
        imageViewStar.setOnLongClickListener(longClickListener);


        imageViewResult.setOnDragListener(dragListener);


    }

    @Override
    protected void onResume() {
        super.onResume();
        mTxt = findViewById(R.id.txt_phrase);
        mTxt.setText("Arraste a estrela para o meio!");
    }
}
