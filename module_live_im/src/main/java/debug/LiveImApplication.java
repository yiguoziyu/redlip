package debug;


import android.app.Application;

import com.kuaibo.commonlib.base.BaseApplication;
import com.orhanobut.logger.Logger;

/**
 * <p>类说明</p>
 *
 * @author 张华洋 2017/2/15 20:09
 * @version V1.2.0
 * @name GirlsApplication
 */
public class LiveImApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

    }

    /**
     * 在这里模拟登陆，然后拿到sessionId或者Token
     * 这样就能够在组件请求接口了
     */
    private void login() {

    }
}
