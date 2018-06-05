package yikezhong.bawei.com.yikezhong.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import javax.inject.Inject;

import yikezhong.bawei.com.yikezhong.net.IBase;

/**
 * Created by Think on 2018/6/5.
 */

public abstract class BaseActivity<T extends BaseContract.BasePresenter> extends AppCompatActivity implements IBase, BaseContract.BaseView {

    //@Inject
    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentLayout());
        inject();

        if (mPresenter != null) {
            //绑定
            mPresenter.attchView(this);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            //解绑
            mPresenter.detachView();
        }
    }

    @Override
    public void initview(View view) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }
}
