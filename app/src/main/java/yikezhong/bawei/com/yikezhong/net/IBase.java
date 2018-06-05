package yikezhong.bawei.com.yikezhong.net;

import android.view.View;

/**
 * Created by Think on 2018/6/5.
 */

public interface IBase {
    //返回的是布局文件
    int getContentLayout();

    //注入
    void inject();

    void initview(View view);
}
