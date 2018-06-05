package yikezhong.bawei.com.yikezhong;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import yikezhong.bawei.com.yikezhong.ui.duanzi.view.DuanZiFragment;
import yikezhong.bawei.com.yikezhong.ui.shiping.view.ShiPingFragment;
import yikezhong.bawei.com.yikezhong.ui.tuijian.view.TuiJianFragment;

/*
* 且换页面
* */
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomTabBar btab = findViewById(R.id.main_btab);

        btab.init(getSupportFragmentManager())
                .setImgSize(60, 60)
                .setFontSize(15)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.RED, Color.DKGRAY)
                .addTabItem("推荐", R.mipmap.raw_a2, R.mipmap.raw_a1, TuiJianFragment.class)
                .addTabItem("段子", R.mipmap.raw_b2, R.mipmap.raw_b1, DuanZiFragment.class)
                .addTabItem("视频", R.mipmap.raw_c2, R.mipmap.raw_c1, ShiPingFragment.class)
                .isShowDivider(false);

    }
}
