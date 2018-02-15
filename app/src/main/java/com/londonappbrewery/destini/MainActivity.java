package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

enum StoryState{FIRST, SECOND, THIRD, FORTH}

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "Destiny_";

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStoryTextView;
    private Button mButtonTop;
    private Button mButtonBottom;
    private StoryState mStoryState = StoryState.FIRST;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Log.d(TAG, "Top");
               switch(mStoryState) {
                   case FIRST:
                       moveToThirdState();
                       break;
                   case SECOND:
                       moveToThirdState();
                       break;
                   case THIRD:
                       mStoryTextView.setText(R.string.T6_End);
                       mButtonTop.setVisibility(View.GONE);
                       mButtonBottom.setVisibility(View.GONE);
                       break;
               }
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Bottom");
                switch(mStoryState) {
                    case FIRST:
                        mStoryTextView.setText(R.string.T2_Story);
                        mButtonTop.setText(R.string.T2_Ans1);
                        mButtonBottom.setText(R.string.T2_Ans2);
                        mStoryState = StoryState.SECOND;
                        break;
                    case SECOND:
                        mStoryTextView.setText(R.string.T4_End);
                        mButtonTop.setVisibility(View.GONE);
                        mButtonBottom.setVisibility(View.GONE);
                        break;
                    case THIRD:
                        mStoryTextView.setText(R.string.T5_End);
                        mButtonTop.setVisibility(View.GONE);
                        mButtonBottom.setVisibility(View.GONE);
                        break;
                }
            }
        });
    }

    private void moveToThirdState() {
        mStoryTextView.setText(R.string.T3_Story);
        mButtonTop.setText(R.string.T3_Ans1);
        mButtonBottom.setText(R.string.T3_Ans2);
        mStoryState = StoryState.THIRD;
    }
}
