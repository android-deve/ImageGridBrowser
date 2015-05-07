package image.jiyouliang.com.imagegridbrowser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * @Jack Boy
 */
public class GridViewAdapter extends ArrayAdapter<String> {

    private final DisplayImageOptions displayImageOptions;

    public GridViewAdapter(Context context, List<String> data) {
        super(context, 0, data);
        displayImageOptions = ImageLoaderUtil.initImageLoader(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_gridview_layout, null);
        }
        String uri = getItem(position);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.imageview);
        ImageLoader.getInstance().displayImage(uri, imageView,displayImageOptions);
        return convertView;
    }
}
