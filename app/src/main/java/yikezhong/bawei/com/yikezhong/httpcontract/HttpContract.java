package yikezhong.bawei.com.yikezhong.httpcontract;

import dagger.Component;
import yikezhong.bawei.com.yikezhong.httpmodule.HttpModule;
import yikezhong.bawei.com.yikezhong.ui.duanzi.view.DuanZiFragment;
import yikezhong.bawei.com.yikezhong.ui.shiping.view.ShiPingFragment;
import yikezhong.bawei.com.yikezhong.ui.tuijian.view.TuiJianFragment;

/**
 * Created by Think on 2018/6/5.
 * 桥梁
 */
@Component(modules = HttpModule.class)
public interface HttpContract {
    //推荐界面
    void injectTuiJian(TuiJianFragment tuiJianFragment);

    //段子界面
    void injectDuanZi(DuanZiFragment duanZiFragment);

    //视频界面
    void injectShiPing(ShiPingFragment shiPingFragment);
}
