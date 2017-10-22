package ve.com.joalbert.pipesize;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


public class PreferenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.action_settings));
        setSupportActionBar(toolbar);
        Fragment host= new PipePreference();
        getFragmentManager().beginTransaction().replace(R.id.container,host).
                commit();
    }

}
