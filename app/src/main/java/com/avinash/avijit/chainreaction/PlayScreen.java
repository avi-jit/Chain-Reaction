package com.avinash.avijit.chainreaction;

import com.avinash.avijit.chainreaction.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class PlayScreen extends Activity {
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = false;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * If set, will toggle the system UI visibility upon interaction. Otherwise,
     * will show the system UI visibility upon interaction.
     */
    private static final boolean TOGGLE_ON_CLICK = false;

    /**
     * The flags to pass to {@link SystemUiHider#getInstance}.
     */
    private static final int HIDER_FLAGS = SystemUiHider.FLAG_HIDE_NAVIGATION;

    /**
     * The instance of the {@link SystemUiHider} for this activity.
     */
    private SystemUiHider mSystemUiHider;


    public int m=10;
    public int n=6;
    public int i=3;
    public int j=0;
    public Button b[][]=new Button[m][n];
    public int c[][]={{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}};
    public int colour[][]={{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}};
    public int turn=Color.RED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_play_screen);

        final View controlsView = findViewById(R.id.fullscreen_content_controls);

        final View contentView = findViewById(R.id.fullscreen_content);

        // Set up an instance of SystemUiHider to control the system UI for
        // this activity.
        mSystemUiHider = SystemUiHider.getInstance(this, contentView, HIDER_FLAGS);
        mSystemUiHider.setup();
        mSystemUiHider
                .setOnVisibilityChangeListener(new SystemUiHider.OnVisibilityChangeListener() {
                    // Cached values.
                    int mControlsHeight;
                    int mShortAnimTime;

                    @Override
                    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
                    public void onVisibilityChange(boolean visible) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
                            // If the ViewPropertyAnimator API is available
                            // (Honeycomb MR2 and later), use it to animate the
                            // in-layout UI controls at the bottom of the
                            // screen.
                            if (mControlsHeight == 0) {
                                mControlsHeight = controlsView.getHeight();
                            }
                            if (mShortAnimTime == 0) {
                                mShortAnimTime = getResources().getInteger(
                                        android.R.integer.config_shortAnimTime);
                            }
                            controlsView.animate()
                                    .translationY(visible ? 0 : mControlsHeight)
                                    .setDuration(mShortAnimTime);
                        } else {
                            // If the ViewPropertyAnimator APIs aren't
                            // available, simply show or hide the in-layout UI
                            // controls.
                            controlsView.setVisibility(visible ? View.VISIBLE : View.GONE);
                        }

                        if (visible && AUTO_HIDE) {
                            // Schedule a hide().
                            delayedHide(AUTO_HIDE_DELAY_MILLIS);
                        }
                    }
                });

        // Set up the user interaction to manually show or hide the system UI.
        /*contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TOGGLE_ON_CLICK) {
                    mSystemUiHider.toggle();
                } else {
                    mSystemUiHider.show();
                }
            }
        });*/

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.


        final FrameLayout f = (FrameLayout)findViewById(R.id.background1);

        b[0][0]=(Button)findViewById(R.id.button1);
        b[0][1]=(Button)findViewById(R.id.button2);
        b[0][2]=(Button)findViewById(R.id.button3);
        b[0][3]=(Button)findViewById(R.id.button4);
        b[0][4]=(Button)findViewById(R.id.button5);
        b[0][5]=(Button)findViewById(R.id.button6);

        b[1][0]=(Button)findViewById(R.id.button7);
        b[1][1]=(Button)findViewById(R.id.button8);
        b[1][2]=(Button)findViewById(R.id.button9);
        b[1][3]=(Button)findViewById(R.id.button10);
        b[1][4]=(Button)findViewById(R.id.button11);
        b[1][5]=(Button)findViewById(R.id.button12);

        b[2][0]=(Button)findViewById(R.id.button13);
        b[2][1]=(Button)findViewById(R.id.button14);
        b[2][2]=(Button)findViewById(R.id.button15);
        b[2][3]=(Button)findViewById(R.id.button16);
        b[2][4]=(Button)findViewById(R.id.button17);
        b[2][5]=(Button)findViewById(R.id.button18);

        b[3][0]=(Button)findViewById(R.id.button19);
        b[3][1]=(Button)findViewById(R.id.button20);
        b[3][2]=(Button)findViewById(R.id.button21);
        b[3][3]=(Button)findViewById(R.id.button22);
        b[3][4]=(Button)findViewById(R.id.button23);
        b[3][5]=(Button)findViewById(R.id.button24);


        b[4][0]=(Button)findViewById(R.id.button25);
        b[4][1]=(Button)findViewById(R.id.button26);
        b[4][2]=(Button)findViewById(R.id.button27);
        b[4][3]=(Button)findViewById(R.id.button28);
        b[4][4]=(Button)findViewById(R.id.button29);
        b[4][5]=(Button)findViewById(R.id.button30);

        b[5][0]=(Button)findViewById(R.id.button31);
        b[5][1]=(Button)findViewById(R.id.button32);
        b[5][2]=(Button)findViewById(R.id.button33);
        b[5][3]=(Button)findViewById(R.id.button34);
        b[5][4]=(Button)findViewById(R.id.button35);
        b[5][5]=(Button)findViewById(R.id.button36);

        b[6][0]=(Button)findViewById(R.id.button37);
        b[6][1]=(Button)findViewById(R.id.button38);
        b[6][2]=(Button)findViewById(R.id.button39);
        b[6][3]=(Button)findViewById(R.id.button40);
        b[6][4]=(Button)findViewById(R.id.button41);
        b[6][5]=(Button)findViewById(R.id.button42);

        b[7][0]=(Button)findViewById(R.id.button43);
        b[7][1]=(Button)findViewById(R.id.button44);
        b[7][2]=(Button)findViewById(R.id.button45);
        b[7][3]=(Button)findViewById(R.id.button46);
        b[7][4]=(Button)findViewById(R.id.button47);
        b[7][5]=(Button)findViewById(R.id.button48);

        b[8][0]=(Button)findViewById(R.id.button49);
        b[8][1]=(Button)findViewById(R.id.button50);
        b[8][2]=(Button)findViewById(R.id.button51);
        b[8][3]=(Button)findViewById(R.id.button52);
        b[8][4]=(Button)findViewById(R.id.button53);
        b[8][5]=(Button)findViewById(R.id.button54);

        b[9][0]=(Button)findViewById(R.id.button55);
        b[9][1]=(Button)findViewById(R.id.button56);
        b[9][2]=(Button)findViewById(R.id.button57);
        b[9][3]=(Button)findViewById(R.id.button58);
        b[9][4]=(Button)findViewById(R.id.button59);
        b[9][5]=(Button)findViewById(R.id.button60);






        i=0;
        j=0;

        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=0;
                j=0;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=0;
        j=1;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=0;
                j=1;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=0;
        j=2;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=0;
                j=2;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=0;
        j=3;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=0;
                j=3;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=0;
        j=4;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=0;
                j=4;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=0;
        j=5;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=0;
                j=5;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=1;
        j=0;

        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=1;
                j=0;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=1;
        j=1;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=1;
                j=1;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=1;
        j=2;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=1;
                j=2;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=1;
        j=3;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=1;
                j=3;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=1;
        j=4;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=1;
                j=4;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=1;
        j=5;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=1;
                j=5;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=2;
        j=0;

        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=2;
                j=0;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=2;
        j=1;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=2;
                j=1;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=2;
        j=2;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=2;
                j=2;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=2;
        j=3;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=2;
                j=3;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=2;
        j=4;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=2;
                j=4;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=2;
        j=5;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=2;
                j=5;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=3;
        j=0;

        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=3;
                j=0;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=3;
        j=1;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=3;
                j=1;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=3;
        j=2;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=3;
                j=2;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=3;
        j=3;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=3;
                j=3;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=3;
        j=4;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=3;
                j=4;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=3;
        j=5;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=3;
                j=5;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=4;
        j=0;

        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=4;
                j=0;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=4;
        j=1;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=4;
                j=1;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=4;
        j=2;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=4;
                j=2;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=4;
        j=3;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=4;
                j=3;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=4;
        j=4;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=4;
                j=4;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=4;
        j=5;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=4;
                j=5;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=5;
        j=0;

        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=5;
                j=0;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=5;
        j=1;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=5;
                j=1;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=5;
        j=2;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=5;
                j=2;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=5;
        j=3;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=5;
                j=3;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=5;
        j=4;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=5;
                j=4;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=5;
        j=5;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=5;
                j=5;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=6;
        j=0;

        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=6;
                j=0;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=6;
        j=1;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=6;
                j=1;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=6;
        j=2;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=6;
                j=2;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=6;
        j=3;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=6;
                j=3;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=6;
        j=4;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=6;
                j=4;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=6;
        j=5;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=6;
                j=5;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=7;
        j=0;

        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=7;
                j=0;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=7;
        j=1;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=7;
                j=1;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=7;
        j=2;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=7;
                j=2;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=7;
        j=3;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=7;
                j=3;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=7;
        j=4;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=7;
                j=4;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=7;
        j=5;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=7;
                j=5;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=8;
        j=0;

        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=8;
                j=0;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=8;
        j=1;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=8;
                j=1;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=8;
        j=2;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=8;
                j=2;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=8;
        j=3;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=8;
                j=3;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=8;
        j=4;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=8;
                j=4;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=8;
        j=5;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=8;
                j=5;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=9;
        j=0;

        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=9;
                j=0;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=9;
        j=1;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=9;
                j=1;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=9;
        j=2;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=9;
                j=2;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=9;
        j=3;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=9;
                j=3;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=9;
        j=4;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=9;
                j=4;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

        i=9;
        j=5;
        b[i][j].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=9;
                j=5;
                if(c[i][j]==0)
                {
                    colour[i][j]=turn;
                    b[i][j].setTextColor(colour[i][j]);
                    c[i][j]++;    
                    b[i][j].setText(""+c[i][j]);
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                }
                else if(colour[i][j]==turn)
                {
                    c[i][j]++;    
                    turn=(turn==(Color.RED))?Color.BLUE:Color.RED;
                    check(i,j,colour[i][j]);
                }
            }
        });

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }


    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
                delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };

    Handler mHideHandler = new Handler();
    Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            mSystemUiHider.hide();
        }
    };

    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }


        public void check(int i, int j, int col)

        {

            if (i == 0 && j == 0) {
                if (c[i][j] == 2) {
                    c[i][j] = 0;
                    c[i][j+1]++;   // 
                    check(i, j + 1, col);
                    c[i + 1][j]++; // 
                    check(i + 1, j, col);
                }

            } else if (i == 0 && j == n - 1) {
                if (c[i][j] == 2) {
                    c[i][j] = 0;
                    c[i][j - 1]++; // 
                    check(i, j - 1, col);
                    c[i + 1][j]++; // 
                    check(i + 1, j, col);
                }
            } else if (i == m - 1 && j == 0) {
                if (c[i][j] == 2) {
                    c[i][j] = 0;
                    c[i][j+1]++;   // 
                    check(i, j + 1, col);
                    c[i - 1][j]++; // 
                    check(i - 1, j, col);
                }
            } else if (i == m - 1 && j == n - 1) {
                if (c[i][j] == 2) {
                    c[i][j] = 0;
                    c[i][j - 1]++; // 
                    check(i, j - 1, col);
                    c[i - 1][j]++; // 
                    check(i - 1, j, col);
                }
            } else if (j == 0) {
                if (c[i][j] == 3) {
                    c[i][j] = 0;
                    c[i][j+1]++;   // 
                    check(i, j + 1, col);
                    c[i + 1][j]++; // 
                    check(i + 1, j, col);
                    c[i - 1][j]++; // 
                    check(i - 1, j, col);
                }
            } else if (j == n - 1) {
                if (c[i][j] == 3) {
                    c[i][j] = 0;
                    c[i][j - 1]++; // 
                    check(i, j - 1, col);
                    c[i + 1][j]++; // 
                    check(i + 1, j, col);
                    c[i - 1][j]++; // 
                    check(i - 1, j, col);
                }
            } else if (i == 0) {
                if (c[i][j] == 3) {
                    c[i][j] = 0;
                    c[i + 1][j]++; // 
                    check(i + 1, j, col);
                    c[i][j+1]++;   // 
                    check(i, j + 1, col);
                    c[i][j - 1]++; // 
                    check(i, j - 1, col);
                }
            } else if (i == m - 1) {
                if (c[i][j] == 3) {
                    c[i][j] = 0;
                    c[i - 1][j]++; // 
                    check(i - 1, j, col);
                    c[i][j+1]++;   // 
                    check(i, j + 1, col);
                    c[i][j - 1]++; // 
                    check(i, j - 1, col);
                }
            } else {
                if (c[i][j] == 4) {
                    c[i][j] = 0;
                    c[i + 1][j]++; // 
                    check(i + 1, j, col);
                    c[i - 1][j]++; // 
                    check(i - 1, j, col);
                    c[i][j+1]++;   // 
                    check(i, j + 1, col);
                    c[i][j - 1]++; // 
                    check(i, j - 1, col);
                }
            }

            for(long k=1;k<=10000;k++)
            {
                System.out.print("");
            }

            colour[i][j] = col;
            b[i][j].setTextColor(col);
            if (c[i][j] == 0)
                b[i][j].setText("");
            else
                b[i][j].setText("" + c[i][j]);



        }
    }


