package image.jiyouliang.com.imagegridbrowser;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;


public class MainActivity extends ActionBarActivity {

    private GridView gridview;
    private GridViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridview = (GridView)findViewById(R.id.gridview);
        mAdapter = new GridViewAdapter(this, ImageUtils.getAlumbImages(this));
        gridview.setAdapter(mAdapter);
    }


}
