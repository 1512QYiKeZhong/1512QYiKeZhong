package yikezhong.bawei.com.yikezhong.api;

import retrofit2.http.GET;
import rx.Observable;
import yikezhong.bawei.com.yikezhong.bean.BannerBean;

/**
 * Created by Think on 2018/6/5.
 */

public interface ApiInterface {
    //推荐 热门里的轮播图
    @GET("quarter/getAd")
    Observable<BannerBean>getBanner();

}
