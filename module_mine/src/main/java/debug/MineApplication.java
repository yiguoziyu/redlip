package debug;


import android.app.Application;

import com.kuaibo.commonlib.base.BaseApplication;

/**
 * <p>类说明</p>
 *
 * @author 张华洋 2017/2/15 20:09
 * @version V1.2.0
 * @name GirlsApplication
 */
public class MineApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        login();
    }

    /**
     * 在这里模拟登陆，然后拿到sessionId或者Token
     * 这样就能够在组件请求接口了
     */
    private void login() {

    }
}
