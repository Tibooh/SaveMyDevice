package com.eservices.tandrentreprise.savemydevice.activities;

import com.eservices.tandrentreprise.savemydevice.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.eservices.tandrentreprise.savemydevice.fragments.CreateDemandFragment;
import com.eservices.tandrentreprise.savemydevice.fragments.ListDemandFragment;
import com.eservices.tandrentreprise.savemydevice.fragments.LoginFragment;
import com.eservices.tandrentreprise.savemydevice.fragments.MyDemandFragment;
import com.eservices.tandrentreprise.savemydevice.fragments.LegalFragment;
import com.eservices.tandrentreprise.savemydevice.fragments.MessagesFragment;
import com.eservices.tandrentreprise.savemydevice.fragments.ParametreFragment;
import com.eservices.tandrentreprise.savemydevice.fragments.SignupFragment;
import com.google.firebase.auth.FirebaseAuth;

/**Activity principale de l'application*/
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FirebaseAuth auth;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_home_black_24dp);

        Fragment fragment = new ListDemandFragment();;
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.commit();


        // 3.9
        final CoordinatorLayout mainLayout = (CoordinatorLayout) findViewById(R.id.main_layout);
        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        //3.9
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                float moveFactor = (navigationView.getWidth() * slideOffset);

                mainLayout.setTranslationX(moveFactor);
            }
        };

        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        auth = FirebaseAuth.getInstance();
        hideItem();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Fragment fragment = null;
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_home) {
            fragment = new ListDemandFragment();
        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        return true;
    }

    //Redirections vers les pages via le menu
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    // 3.4 and 3.8
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;

        if (id == R.id.nav_demand) {
            fragment = new MyDemandFragment();
        } else if (id == R.id.nav_message) {
            fragment = new MessagesFragment();
        }else if ( id == R.id.nav_add){
            fragment = new CreateDemandFragment();
        } else if (id == R.id.nav_settings) {
            fragment = new ParametreFragment();
        } else if (id == R.id.nav_legal) {
            fragment = new LegalFragment();
        } else if (id == R.id.home){
            fragment = new ListDemandFragment();
        } else if (id == R.id.nav_connect){
            fragment=new LoginFragment();
        } else if (id == R.id.nav_create_account){
            fragment=new SignupFragment();

        } else if (id == R.id.nav_deconnect){
            FirebaseAuth auth = FirebaseAuth.getInstance();
            if (auth.getCurrentUser() != null) {
                Toast.makeText(MainActivity.this, "A bientot :" + auth.getCurrentUser().getEmail(),
                        Toast.LENGTH_SHORT).show();
                auth.signOut();
            }
            Intent i = new Intent(MainActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void hideItem()
    {
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu nav_Menu = navigationView.getMenu();
        nav_Menu.findItem(R.id.nav_settings).setVisible(false);
        if (auth.getCurrentUser() != null) {
            //icone connecté
            nav_Menu.findItem(R.id.nav_demand).setVisible(true);
            nav_Menu.findItem(R.id.nav_message).setVisible(true);
            nav_Menu.findItem(R.id.nav_add).setVisible(true);
            nav_Menu.findItem(R.id.nav_settings).setVisible(true);
            nav_Menu.findItem(R.id.nav_demand).setVisible(true);
            nav_Menu.findItem(R.id.nav_deconnect).setVisible(true);
            //icone non connecté
            nav_Menu.findItem(R.id.nav_connect).setVisible(false);
            nav_Menu.findItem(R.id.nav_create_account).setVisible(false);
        }else{
            nav_Menu.findItem(R.id.nav_demand).setVisible(false);
            nav_Menu.findItem(R.id.nav_message).setVisible(false);
            nav_Menu.findItem(R.id.nav_add).setVisible(false);
            nav_Menu.findItem(R.id.nav_settings).setVisible(false);
            nav_Menu.findItem(R.id.nav_demand).setVisible(false);
            nav_Menu.findItem(R.id.nav_deconnect).setVisible(false);
            //icone non connecté
            nav_Menu.findItem(R.id.nav_connect).setVisible(true);
            nav_Menu.findItem(R.id.nav_create_account).setVisible(true);

        }
    }
}