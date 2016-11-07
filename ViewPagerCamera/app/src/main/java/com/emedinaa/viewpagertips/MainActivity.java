package com.emedinaa.viewpagertips;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.emedinaa.viewpagertips.adapters.ScreenSlidePagerAdapter;
import com.emedinaa.viewpagertips.fragments.OnFragmentListener;

public class MainActivity extends AppCompatActivity implements OnFragmentListener {

    private static final String TAG ="MainActivity" ;
    private ViewPager mPager;
    private ScreenSlidePagerAdapter mPagerAdapter;
    private EditText eteMessage;
    private Button btnAUpdate,btnBUpdate,btnCUpdate,btnCamera;

    private static final int ACTION_TAKE_PHOTO = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPager = (ViewPager) findViewById(R.id.pager);
        eteMessage = (EditText) findViewById(R.id.eteMessage);
        btnAUpdate = (Button) findViewById(R.id.btnAUpdate);
        btnBUpdate = (Button) findViewById(R.id.btnBUpdate);
        btnCUpdate = (Button) findViewById(R.id.btnCUpdate);
        btnCamera = (Button) findViewById(R.id.btnCamera);

        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        events();
    }

    private void events() {

        btnAUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message= eteMessage.getText().toString().trim();
                if(!TextUtils.isEmpty(message))
                {
                    mPagerAdapter.updateFragment(ScreenSlidePagerAdapter.FRAG_A,message);
                }
            }
        });
        btnBUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message= eteMessage.getText().toString().trim();
                if(!TextUtils.isEmpty(message))
                {
                    mPagerAdapter.updateFragment(ScreenSlidePagerAdapter.FRAG_B,message);
                }
            }
        });
        btnCUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message= eteMessage.getText().toString().trim();
                if(!TextUtils.isEmpty(message))
                {
                    mPagerAdapter.updateFragment(ScreenSlidePagerAdapter.FRAG_C,message);
                }
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPager.setCurrentItem(ScreenSlidePagerAdapter.FRAG_CAMERA);
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case ACTION_TAKE_PHOTO: {
                if (resultCode == RESULT_OK) {
                    Log.v(TAG, "PHOTO " + data);
                    mPager.setCurrentItem( ScreenSlidePagerAdapter.FRAG_CAMERA );
                }
                break;
            }
        }

    }
}
