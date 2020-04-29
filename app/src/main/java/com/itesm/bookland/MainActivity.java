package com.itesm.bookland;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        drawer=findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);

        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this,drawer,toolbar,R.string.nav_drawer_open,
                R.string.nav_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.navHome);
        }
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navHome:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                break;
            case R.id.navScifi:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ScifiFragment()).commit();
                break;
                case R.id.navSports:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SportsFragment()).commit();
                break;
            case R.id.navEnglish:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new EnglishLiteratureFragment()).commit();
                break;
            case R.id.navArtC:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ArtCultureFragment()).commit();
                break;
            case R.id.navComics:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ComicsFragment()).commit();
                break;
            case R.id.navSelfHelp:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SelfHelpFragment()).commit();
                break;
            case  R.id.nav_map:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MapsFragment()).commit();
                break;
            case R.id.nav_email:
                Toast.makeText(getApplicationContext(),"Send", Toast.LENGTH_SHORT).show();
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
