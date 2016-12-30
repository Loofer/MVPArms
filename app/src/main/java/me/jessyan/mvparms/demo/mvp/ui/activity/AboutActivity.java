package me.jessyan.mvparms.demo.mvp.ui.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jess.arms.utils.UiUtils;

import butterknife.BindView;
import common.AppComponent;
import common.WEActivity;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.di.component.DaggerAboutComponent;
import me.jessyan.mvparms.demo.di.module.AboutModule;
import me.jessyan.mvparms.demo.mvp.contract.AboutContract;
import me.jessyan.mvparms.demo.mvp.presenter.AboutPresenter;

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
 * 版权： xx有限公司 版权所有（c）2016
 * <p>
 * 作者：Loofer
 * 版本：1.0
 * 创建日期 ：2016/12/28 21:48.
 * 描述：
 * <p>
 * 注:如果您修改了本类请填写以下内容作为记录，如非本人操作劳烦通知，谢谢！！！
 * Modified Date Modify Content:
 * <p>
 * ==========================================================
 */

public class AboutActivity extends WEActivity<AboutPresenter> implements AboutContract.View {


    @BindView(R.id.backdrop)
    ImageView mBackdrop;
//    @BindView(R.id.toolbar_title_tv)
//    TextView mToolbarTitleTv;
    @BindView(R.id.common_toolbar)
    Toolbar mAboutToolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout mToolbarLayout;

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerAboutComponent
                .builder()
                .appComponent(appComponent)
                .aboutModule(new AboutModule(this)) //请将AboutModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected View initLayout() {
        return LayoutInflater.from(this).inflate(R.layout.activity_about, null, false);
    }


    public void initBack(){
        //        setStatusBarColor()
        mAboutToolbar.setTitle("关于我");
        setSupportActionBar(mAboutToolbar);
        mAboutToolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        mAboutToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        String currentGirl = "http://ww2.sinaimg.cn/large/610dc034jw1f5k1k4azguj20u00u0421.jpg";

        //毛玻璃效果
        Glide.with(this)
                .load(currentGirl)
//                .bitmapTransform(new BlurTransformation(this, 15))
                .into(mBackdrop);
    }


    @Override
    protected boolean useToolbar() {
        return false;
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
        UiUtils.startActivity(this, intent);
    }

    @Override
    public void killMyself() {
        finish();
    }

}