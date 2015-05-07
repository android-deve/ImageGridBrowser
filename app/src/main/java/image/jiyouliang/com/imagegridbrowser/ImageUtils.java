package image.jiyouliang.com.imagegridbrowser;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageUtils {
    private final static String TAG = ImageUtils.class.getSimpleName();

    /**获取手机中的图片*/
    public static List<String> getAlumbImages(Context context){
        //获取相册图片，按照时间排序
        List<String> fileList = new ArrayList<String>();
        Cursor cursor = context.getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                new String[]{MediaStore.Images.Media.DATA, MediaStore.Images.Media._ID, MediaStore.Images.Media.BUCKET_DISPLAY_NAME},
                null, null, MediaStore.Images.Media.DATE_TAKEN + " DESC");
        if (cursor != null && cursor.moveToFirst()) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToPosition(i);
                String filename = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                File imageFile = new File(filename);
                Log.e(TAG, "filename=" + imageFile);
                if (imageFile.exists()) {
                    fileList.add("file:/" + filename);
                }
            }
        }
        return fileList;
    }

}
