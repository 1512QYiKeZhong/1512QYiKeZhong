package yikezhong.bawei.com.yikezhong.api;

/**
 * Created by Think on 2018/6/5.
 */

public class IApi {
    private static IApi iApi=null;
    private final ApiInterface apiInterface;

    public IApi(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    public static IApi getIApi(ApiInterface apiInterface){
        if (iApi==null){
            iApi=new IApi(apiInterface);
        }
        return iApi;
    }

}
