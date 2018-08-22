package ru.macdroid.newsreader;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    RecyclerView recycler;
    RssObject rssObject;
    Toolbar toolbar;
    FloatingActionButton fab;
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    String RSS_LINK;
    String RSS_JSON = "https://api.rss2json.com/v1/api.json?rss_url=";
    String rssLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, SplashScreen.class));
            }
        }, 0);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Sports.ru");
        setSupportActionBar(toolbar);

        RSS_LINK = "http://www.sports.ru/rss/rubric.xml?s=1";

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        loadRss();
    }

    private void loadRss() {
        @SuppressLint("StaticFieldLeak") AsyncTask<String, String, String> loadRssAsync = new AsyncTask<String, String, String>() {

            ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);

            @Override
            protected void onPreExecute() {
                progressDialog.setMessage(getString(R.string.load_async));
                progressDialog.show();
            }

            @Override
            protected String doInBackground(String... strings) {
                String result;
                HttpDataHandler http = new HttpDataHandler();
                result = http.getHttpData(strings[0]);
                return result;
            }

            @Override
            protected void onPostExecute(String s) {
                progressDialog.dismiss();
                rssObject = new Gson().fromJson(s, RssObject.class);
                FeedAdapter feedAdapter = new FeedAdapter(rssObject, MainActivity.this, LayoutInflater.from(MainActivity.this));
                recycler.setAdapter(feedAdapter);
                feedAdapter.notifyDataSetChanged();
            }
        };

        StringBuilder urlGetData = new StringBuilder(RSS_JSON);
        urlGetData.append(RSS_LINK);
        loadRssAsync.execute(urlGetData.toString());
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
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (item.getItemId()) {

            case R.id.nav_main:
                RSS_LINK = "https://www.sports.ru/rss/rubric.xml?s=1";
                loadRss();
                break;

            case R.id.nav_box:
                RSS_LINK = "https://www.sports.ru/rss/rubric.xml?s=255";
                loadRss();
                break;

            case R.id.nav_ski:
                RSS_LINK = "https://www.sports.ru/rss/rubric.xml?s=256";
                loadRss();
                break;

            case R.id.nav_hockey:
                RSS_LINK = "https://www.sports.ru/rss/rubric.xml?s=239";
                loadRss();
                break;

            case R.id.nav_handball:
                RSS_LINK = "https://www.sports.ru/rss/rubric.xml?s=220";
                loadRss();
                break;

            case R.id.nav_aqua:
                RSS_LINK = "https://www.sports.ru/rss/rubric.xml?s=217";
                loadRss();
                break;

            case R.id.nav_football:
                RSS_LINK = "http://www.sports.ru/rss/rubric.xml?s=208";
                loadRss();
                break;

            case R.id.nav_tennis:
                RSS_LINK = "http://www.sports.ru/rss/rubric.xml?s=212";
                loadRss();
                break;

            case R.id.nav_run:
                RSS_LINK = "http://www.sports.ru/rss/rubric.xml?s=215";
                loadRss();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab:
                loadRss();
                break;
        }
    }
}
