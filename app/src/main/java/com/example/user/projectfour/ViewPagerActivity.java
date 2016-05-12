package com.example.user.projectfour;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class ViewPagerActivity extends AppCompatActivity {

    private ImageFragmentPagerAdapter mImageFragmentPagerAdapter;
    private ViewPager mViewPager;
    private RadioGroup mRadioGroup;
    static final int NUM_ITEMS = 6;
    public static final String[] IMAGE_NAME = {"borabora", "dubai", "switzerland", "kenya", "london", "iceland",};
    public static final String[] IMAGE_COUNT = {"Image one", "Image two", "Image three", "Image four", "Image five", "Image six",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        mImageFragmentPagerAdapter = new ImageFragmentPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.viewPager);


        mRadioGroup = (RadioGroup) findViewById(R.id.radiogroup);

        mViewPager.setAdapter(mImageFragmentPagerAdapter);

        scrollingPagesTowards();
        scrollingPagesRadioButton();
    }

    // Changes images scrolling screen
    private void scrollingPagesTowards() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mRadioGroup.check(R.id.radioButton);
                        break;
                    case 1:
                        mRadioGroup.check(R.id.radioButton2);
                        break;
                    case 2:
                        mRadioGroup.check(R.id.radioButton3);
                        break;
                    case 3:
                        mRadioGroup.check(R.id.radioButton4);
                        break;
                    case 4:
                        mRadioGroup.check(R.id.radioButton5);
                        break;
                    case 5:
                        mRadioGroup.check(R.id.radioButton6);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    // Changes images pressed RadioButton
    private void scrollingPagesRadioButton() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.radioButton2:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.radioButton3:
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.radioButton4:
                        mViewPager.setCurrentItem(3);
                        break;
                    case R.id.radioButton5:
                        mViewPager.setCurrentItem(4);
                        break;
                    case R.id.radioButton6:
                        mViewPager.setCurrentItem(5);
                        break;
                }
            }
        });
    }


    public static class ImageFragmentPagerAdapter extends FragmentPagerAdapter {
        public ImageFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public Fragment getItem(int position) {
            SwipeFragment fragment = new SwipeFragment();
            return SwipeFragment.newInstance(position);
        }
    }

    public static class SwipeFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View swipeView = inflater.inflate(R.layout.fragment, container, false);
            TextView textView = (TextView) swipeView.findViewById(R.id.txtCount);
            ImageView imageView = (ImageView) swipeView.findViewById(R.id.image);
            Bundle bundle = getArguments();
            int position = bundle.getInt("position");
            String imageFileName = IMAGE_NAME[position];
            String imageCount = IMAGE_COUNT[position];
            int imgResId = getResources().getIdentifier(imageFileName, "drawable", "com.example.user.projectfour");
            textView.setText(imageCount);
            imageView.setImageResource(imgResId);
            return swipeView;
        }


        static SwipeFragment newInstance(int position) {
            SwipeFragment swipeFragment = new SwipeFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("position", position);
            swipeFragment.setArguments(bundle);
            return swipeFragment;
        }
    }
}
