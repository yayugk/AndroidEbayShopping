package com.example.younghong.navigationbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import static android.app.PendingIntent.getActivity;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener  {

    private ViewStub stubGrid;
    private ViewStub stubList;
    private ListView listView;
    private GridView gridView;
    private ListViewAdapter listViewAdapter;
    private GridViewAdapter gridViewAdapter;
    private List<Product> productList;
    private int currentViewMode = 0;

    static final int VIEW_MODE_LISTVIEW = 0;
    static final int VIEW_MODE_GRIDVIEW = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

/////
        stubList = (ViewStub) findViewById(R.id.stub_list);
        stubGrid = (ViewStub) findViewById(R.id.stub_grid);
//
        //Inflate ViewStub before get view

        stubList.inflate();
        stubGrid.inflate();
//
        listView = (ListView) findViewById(R.id.mylistview);
        gridView = (GridView) findViewById(R.id.mygridview);

        //get list of product
        getProductList();

        //Get current view mode in share reference
        SharedPreferences sharePreProductList = getSharedPreferences("ViewMode", MODE_PRIVATE);
        currentViewMode = sharePreProductList.getInt("currentViewMode", VIEW_MODE_LISTVIEW);//Default is view listview
        //Register item lick
        listView.setOnItemClickListener(onItemClick);
        gridView.setOnItemClickListener(onItemClick);

        switchView();

        //


        SharedPreferences sharedPreferences = getSharedPreferences("test", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        boolean mainLoginVar = sharedPreferences.getBoolean("login", true);
        String name = sharedPreferences.getString("name", "");
        String username = sharedPreferences.getString("username", "");
//
//        HomeFragment homeFrag = new HomeFragment();
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.frame, homeFrag, "fragment Home");
//        fragmentTransaction.commit();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        View hView =  navigationView.getHeaderView(0);
        TextView nav_user = (TextView)hView.findViewById(R.id.nav_header_name);
        nav_user.setText(name);
        TextView nav_username = (TextView)hView.findViewById(R.id.nav_header_username);
        nav_username.setText(username);
//        TextView homepage = (TextView) hView.findViewById(R.id.tvHomePage);


        if(mainLoginVar) {
            navigationView.getMenu().getItem(6).setVisible(true);
            navigationView.getMenu().getItem(7).setVisible(false);
        }
        else{
            nav_user.setText("");
            nav_username.setText("");
            navigationView.getMenu().getItem(6).setVisible(false);
            navigationView.getMenu().getItem(7).setVisible(true);
        }

        navigationView.setNavigationItemSelectedListener(this);

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

    AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Do any thing when user click to item
            Toast.makeText(getApplicationContext(), productList.get(position).getTitle() + " - " + productList.get(position).getDescription(), Toast.LENGTH_SHORT).show();
        }
    };

    private void switchView() {

        if(VIEW_MODE_LISTVIEW == currentViewMode) {
            //Display listview
            stubList.setVisibility(View.VISIBLE);
            //Hide gridview
            stubGrid.setVisibility(View.GONE);
        } else {
            //Hide listview
            stubList.setVisibility(View.GONE);
            //Display gridview
            stubGrid.setVisibility(View.VISIBLE);
        }
        setAdapters();
    }

    private void setAdapters() {
        if(VIEW_MODE_LISTVIEW == currentViewMode) {
            listViewAdapter = new ListViewAdapter(this, R.layout.list_item, productList);
            listView.setAdapter(listViewAdapter);
        } else {
            gridViewAdapter = new GridViewAdapter(this, R.layout.grid_item, productList);
            gridView.setAdapter(gridViewAdapter);
        }
    }

    public List<Product> getProductList() {
        //pseudo code to get product, replace your code to get real product here
        productList = new ArrayList<>();
        productList.add(new Product(R.drawable.icon_android, "Title 1", "This is description 1"));
        productList.add(new Product(R.drawable.icon_android, "Title 2", "This is description 2"));
        productList.add(new Product(R.drawable.icon_android, "Title 3", "This is description 3"));
        productList.add(new Product(R.drawable.icon_android, "Title 4", "This is description 4"));
        productList.add(new Product(R.drawable.icon_android, "Title 5", "This is description 5"));
        productList.add(new Product(R.drawable.icon_android, "Title 6", "This is description 6"));
        productList.add(new Product(R.drawable.icon_android, "Title 7", "This is description 7"));
        productList.add(new Product(R.drawable.icon_android, "Title 8", "This is description 8"));
        productList.add(new Product(R.drawable.icon_android, "Title 9", "This is description 9"));
        productList.add(new Product(R.drawable.icon_android, "Title 10", "This is description 10"));

        return productList;
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        }
        else if(id == R.id.item_menu_1){
            if(VIEW_MODE_LISTVIEW == currentViewMode) {
                currentViewMode = VIEW_MODE_GRIDVIEW;
            } else {
                currentViewMode = VIEW_MODE_LISTVIEW;
            }
            //Switch view
            switchView();
            //Save view mode in share reference
            SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("currentViewMode", currentViewMode);
            editor.commit();
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected (MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        final SharedPreferences sharedPreferences = getSharedPreferences("test", 0);
        boolean loginVar = sharedPreferences.getBoolean("login", true);

        TextView homepage = (TextView) findViewById(R.id.tvHomePage);

        homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getFragmentManager().beginTransaction().replace(R.id.frame, MainActivity.class).commit();
                finish();
                startActivity(getIntent());
            }
        });

        stubList.setVisibility(View.GONE);
        stubGrid.setVisibility(View.GONE);


        if(id != 0) {

            if (id == R.id.Home) {
                setTitle("Home");
                HomeFragment homeFrag = new HomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame, homeFrag, "fragment Home");
                fragmentTransaction.commit();
//                MainActivity.this.
//                        getSupportFragmentManager().
//                        beginTransaction().
//                        replace(R.id.frame, HomeFragment.newInstance()).commit();
            } else if (id == R.id.Notification) {
                setTitle("Notification");
                NotificationFragment notifiFrag = new NotificationFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame, notifiFrag, "fragment Notification");
                fragmentTransaction.commit();
            }
            else if (id == R.id.menuLogout){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("login", false);
                editor.commit();
                Intent logoutIntent = new Intent(MainActivity.this, MainActivity.class);
                logoutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                logoutIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(logoutIntent);
            }
            else if (id == R.id.menuLogin) {
                Intent signinLink = new Intent(MainActivity.this, LoginActivity.class);
                signinLink.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                signinLink.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(signinLink);
            }
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}

