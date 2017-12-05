package mycollege.asmobisoft.com.restaurentapp.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mycollege.asmobisoft.com.restaurentapp.Adaptor.NavigationDrawerAdapter;
import mycollege.asmobisoft.com.restaurentapp.Model.NavDrawerItem;
import mycollege.asmobisoft.com.restaurentapp.Navigationnn.FavoriteFragment;
import mycollege.asmobisoft.com.restaurentapp.Navigationnn.LastOrderFragment;
import mycollege.asmobisoft.com.restaurentapp.Navigationnn.MenuFragment;
import mycollege.asmobisoft.com.restaurentapp.Navigationnn.MycartFragment;
import mycollege.asmobisoft.com.restaurentapp.Navigationnn.OffersFragment;
import mycollege.asmobisoft.com.restaurentapp.Navigationnn.SettingFragment;
import mycollege.asmobisoft.com.restaurentapp.Navigationnn.SupportFragment;
import mycollege.asmobisoft.com.restaurentapp.R;

public class Navigation extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {
    private static String TAG = MainActivity.class.getSimpleName();
    //private TypedArray navMenuIcons;
    List<NavDrawerItem> data;
    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    private ArrayList<NavDrawerItem> datas;
    private LinearLayout nav_header_container;
    private TextView drawerTitle;
    private TextView drawerCount;
    private ImageView drawerIcon;
    private TextView tvUserName;
    private ImageView ivUserImage;
    private String[] navMenuTitles;
    private int[] navMenuIcons;
    private NavigationDrawerAdapter adapter;
    private RecyclerView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);


        nav_header_container = (LinearLayout) findViewById(R.id.nav_header_container);
        drawerTitle = (TextView) mToolbar.findViewById(R.id.titlee);
        drawerIcon = (ImageView) mToolbar.findViewById(R.id.ivTitleIcon);


        drawerCount = (TextView) mToolbar.findViewById(R.id.tv_count);

        tvUserName = (TextView) findViewById(R.id.tvUserName);
        mDrawerList = (RecyclerView) findViewById(R.id.drawerList);


        if (getSupportActionBar() != null) {

            getSupportActionBar().setDisplayShowHomeEnabled(true);
            drawerFragment = (FragmentDrawer) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
            drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
            drawerFragment.setDrawerListener(this);

            // display the first menu_main drawer view on app launch
            displayView(0);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

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

        if (id == R.id.action_search) {
            Toast.makeText(getApplicationContext(), "Search action is selected!", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new MenuFragment();
                title = getString(R.string.title_menu);

                break;
            case 1:
                fragment = new OffersFragment();
                title = getString(R.string.title_offers);
                break;
            case 2:
                fragment = new MycartFragment();
                title = getString(R.string.title_mycart);
                break;
            case 3:
                fragment = new LastOrderFragment();
                title = getString(R.string.title_lastorder);
                break;
            case 4:
                fragment = new FavoriteFragment();
                title = getString(R.string.title_favorite);
                break;
            case 5:
                fragment = new SettingFragment();
                title = getString(R.string.action_settings);
                break;
            case 6:
                fragment = new SupportFragment();
                title = getString(R.string.title_support);
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);

        }
    }
}



