package yikezhong.bawei.com.yikezhong.ui.base;

/**
 * Created by Think on 2018/6/5.
 */

public interface BaseContract {
    //抽取所有Presenter共性，比如绑定，解绑
    interface BasePresenter<T extends BaseView> {
        //绑定
        void attchView(T view);

        //解绑
        void detachView();
    }

    //抽取所有View的共性，比如显示进度条和关闭进度
    interface BaseView {
        void showLoading();

        void dismissLoading();
    }
}
