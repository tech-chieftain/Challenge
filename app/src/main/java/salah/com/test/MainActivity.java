package salah.com.test;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import salah.com.test.fragments.DashFragment.DashFragment;
import salah.com.test.fragments.HomeFragment.HomeFragment;
import salah.com.test.fragments.MapFragment.MapFragment;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final int ERROR_DIALOG_REQUEST = 9001;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListenet);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListenet = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            android.support.v4.app.Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.navigation_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.navigation_dashboard:
                    selectedFragment = new DashFragment();
                    break;
                case R.id.navigation_notifications:
                    selectedFragment = new MapFragment();
                    break;

            }



            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };
    public boolean isServicesOK(){
        boolean state = false;
        Log.d(TAG, "isServicesOK: checking google services version");

        int availabe = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);
        if(availabe == ConnectionResult.SUCCESS){
            Log.d(TAG, "isServicesOK: google play services is working");
            state = true;

        }
        else if (GoogleApiAvailability.getInstance().isUserResolvableError(availabe))
        {
            Log.d(TAG, "isServicesOK: an error occured but we can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this, availabe, ERROR_DIALOG_REQUEST);
            dialog.show();


        }
        else
        {
            Toast.makeText(this, "You can't make map request", Toast.LENGTH_LONG);
            state = false;
        }

        return state;
    }


}
