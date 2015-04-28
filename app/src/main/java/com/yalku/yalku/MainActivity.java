package com.yalku.yalku;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.yalku.yalku.transformers.DepthPageTransformer;
import com.yalku.yalku.transformers.ZoomOutPageTransformer;


public class MainActivity extends FragmentActivity {

    ViewPager pager = null;

    MyFragmentPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        this.setContentView(R.layout.activity_main);
        this.pager = (ViewPager) this.findViewById(R.id.pager);
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(
                getSupportFragmentManager());
        adapter.addFragment(ScreenSlidePageFragment.newInstance(getResources()
                .getColor(R.color.android_blue), 1));
        adapter.addFragment(ScreenSlidePageFragment.newInstance(getResources()
                .getColor(R.color.android_purple), 2));
        adapter.addFragment(ScreenSlidePageFragment.newInstance(getResources()
                .getColor(R.color.android_green), 3));
        adapter.addFragment(ScreenSlidePageFragment.newInstance(getResources()
                .getColor(R.color.android_yellow), 4));
        adapter.addFragment(ScreenSlidePageFragment.newInstance(getResources()
                .getColor(R.color.android_red), 5));
        this.pager.setAdapter(adapter);


        //You can use this to put and effect when slide, or not.
        this.pager.setPageTransformer(true, new DepthPageTransformer()
                                                /*ZoomOutPageTransformer()*/);



    }

    @Override
    public void onBackPressed() {
        if (this.pager.getCurrentItem() == 0)
            super.onBackPressed();
        else
            this.pager.setCurrentItem(this.pager.getCurrentItem() - 1);

    }
}