package com.example.user.projectfour;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.widget.Toast;

public class DrawerActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_drawer);

        initNavigationDrawer();

        mIntent = new Intent(this, ViewPagerActivity.class);
    }


    public void initNavigationDrawer() {

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_drawer);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem item) {

                    if (item.isChecked()) item.setChecked(false);
                    else item.setChecked(true);

                    mDrawerLayout.closeDrawers();

                    int id = item.getItemId();
                    switch (id) {
                        case R.id.navigation_drawer_item1:
                            Toast.makeText(getApplicationContext(), "Image Gallery", Toast.LENGTH_SHORT).show();
                            startActivity(mIntent);
                            break;
                    }
                    return true;
                }
            });
        }

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_design_support_layout);

        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                mToolbar, R.string.drawer_open, R.string.drawer_close);

        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mActionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mActionBarDrawerToggle.onConfigurationChanged(newConfig);
    }
}
