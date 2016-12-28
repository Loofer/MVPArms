package me.jessyan.mvparms.demo.mvp.ui.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import com.jess.arms.utils.UiUtils;

import common.AppComponent;
import common.WEActivity;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.di.component.DaggerToolBarComponent;
import me.jessyan.mvparms.demo.di.module.ToolBarModule;
import me.jessyan.mvparms.demo.mvp.contract.ToolBarContract;
import me.jessyan.mvparms.demo.mvp.presenter.ToolBarPresenter;

import static com.jess.arms.utils.Preconditions.checkNotNull;

/**
 * 通过Template生成对应页面的MVP和Dagger代码,请注意输入框中输入的名字必须相同
 * 由于每个项目包结构都不一定相同,所以每生成一个文件需要自己导入import包名,可以在设置中设置自动导入包名
 * 请在对应包下按以下顺序生成对应代码,Contract->Model->Presenter->Activity->Module->Component
 * 因为生成Activity时,Module和Component还没生成,但是Activity中有它们的引用,所以会报错,但是不用理会
 * 继续将Module和Component生成完后,编译一下项目再回到Activity,按提示修改一个方法名即可
 * 如果想生成Fragment的相关文件,则将上面构建顺序中的Activity换为Fragment,并将Component中inject方法的参数改为此Fragment
 */

/**
 * ============================================================
 * 版权： x x 版权所有（c）2016
 * <p>
 * 作者：Loofer
 * 版本：1.0
 * 创建日期 ：2016/12/28 17:48.
 * 描述：
 * <p>
 * 注:如果您修改了本类请填写以下内容作为记录，如非本人操作劳烦通知，谢谢！！！
 * Modified Date Modify Content:
 * <p>
 * ==========================================================
 */
public class ToolBarActivity extends WEActivity<ToolBarPresenter> implements ToolBarContract.View {


    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerToolBarComponent
                .builder()
                .appComponent(appComponent)
                .toolBarModule(new ToolBarModule(this)) //请将ToolBarModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected View initView() {
        setTitleBgColor(R.color.colorPrimary);
        setLogoIcon(R.mipmap.ic_launcher);
        setMainTitle("主标题");
        setSubTitle("子标题");
        setToolbarTitle("我是中间标题");
//        hideTitleNavigationButton();
        return LayoutInflater.from(this).inflate(R.layout.activity_toolbar, null, false);
    }


    @Override
    public boolean callbackOnMenuAction(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                UiUtils.makeText("搜索");
                return true;
            case R.id.action_login:
                UiUtils.makeText("登录");
                return true;
            case R.id.action_my_message:
                UiUtils.makeText("消息");
                return true;
            case R.id.action_sync_bookshelf:
                UiUtils.makeText("同步");
                return true;
            case R.id.action_scan_local_book:
                UiUtils.makeText("本地");
                return true;
            case R.id.action_wifi_book:
                UiUtils.makeText("wifi");
                return true;
            case R.id.action_feedback:
                UiUtils.makeText("反馈");
                return true;
            case R.id.action_settings:
                UiUtils.makeText("设置");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    /**
     * 重写Navigation回调
     *
     * @param view
     */
    @Override
    protected void callbackOnClickNavigationAction(View view) {
        super.callbackOnClickNavigationAction(view);
    }

    @Override
    protected int getMenuLayoutId() {
        return R.menu.menu_main;
    }

    @Override
    protected void initData() {

    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        UiUtils.SnackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        UiUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }


}