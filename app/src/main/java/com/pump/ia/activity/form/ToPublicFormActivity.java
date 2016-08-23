package com.pump.ia.activity.form;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.pump.ia.R;
import com.pump.ia.activity.BaseActivity;
import com.pump.ia.adapter.FormTitlesAdapter;
import com.pump.ia.adapter.MyFragmentAdapter;
import com.pump.ia.fragment.form.share.BankBusinessFragment;
import com.pump.ia.fragment.form.share.ConclusionFragment;
import com.pump.ia.fragment.form.topublic.EnterpriseAssetsFragment;
import com.pump.ia.fragment.form.topublic.EnterpriseBaseInfoFragment;
import com.pump.ia.fragment.form.topublic.EnterpriseDemandFragment;
import com.pump.ia.fragment.form.topublic.EnterpriseFinanceFragment;
import com.pump.ia.fragment.form.topublic.EnterpriseInfoFragment;
import com.pump.ia.fragment.form.topublic.EnterpriseLiabilitiesFragment;
import com.pump.ia.view.RvDividerDecoration;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import fr.castorflex.android.verticalviewpager.VerticalViewPager;

@ContentView(R.layout.activity_to_public_form)
public class ToPublicFormActivity extends BaseActivity {

    @ViewInject(R.id.title_middle)
    private TextView title_middle;

    @ViewInject(R.id.title_left)
    private TextView title_left;

    @ViewInject(R.id.rv_public_form_titles)
    private RecyclerView rv_public_form_titles;

    @ViewInject(R.id.vvp_public_form_content)
    private VerticalViewPager vvp_public_form_content;

    private FormTitlesAdapter titlesAdapter;

    private MyFragmentAdapter contentAdapter;

    private static final String[] TITLES = {"企业信息","基础信息","企业资产","企业负债","企业收支","银行业务","潜在需求","结论"};
    private List<Fragment> contentList;

    private EnterpriseInfoFragment enterpriseInfoFragment = new EnterpriseInfoFragment();
    private EnterpriseBaseInfoFragment enterpriseBaseInfoFragment = new EnterpriseBaseInfoFragment();
    private EnterpriseAssetsFragment enterpriseAssetsFragment = new EnterpriseAssetsFragment();
    private EnterpriseLiabilitiesFragment enterpriseLiabilitiesFragment = new EnterpriseLiabilitiesFragment();
    private EnterpriseFinanceFragment enterpriseFinanceFragment = new EnterpriseFinanceFragment();
    private BankBusinessFragment bankBusinessFragment = new BankBusinessFragment();
    private EnterpriseDemandFragment enterpriseDemandFragment = new EnterpriseDemandFragment();
    private ConclusionFragment conclusionFragment = new ConclusionFragment();

    private int flagPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        x.view().inject(this);

        initData();
        initView();

    }
    @Override
    protected void initData() {


        titlesAdapter = new FormTitlesAdapter(TITLES, this);

        contentList = new ArrayList<>();
        contentList.add(enterpriseInfoFragment);
        contentList.add(enterpriseBaseInfoFragment);
        contentList.add(enterpriseAssetsFragment);
        contentList.add(enterpriseLiabilitiesFragment);
        contentList.add(enterpriseFinanceFragment);
        contentList.add(bankBusinessFragment);
        contentList.add(enterpriseDemandFragment);
        contentList.add(conclusionFragment);

        contentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), contentList);

    }

    @Override
    protected void initView() {
        title_middle.setText("对公");
        title_left.setVisibility(View.VISIBLE);
        rv_public_form_titles.setHasFixedSize(true);
        rv_public_form_titles.setLayoutManager(new LinearLayoutManager(this));
        rv_public_form_titles.addItemDecoration(new RvDividerDecoration(this,RvDividerDecoration.VERTICAL_LIST));
        rv_public_form_titles.setAdapter(titlesAdapter);
        titlesAdapter.setOnItemClickListener(new FormTitlesAdapter.TitleClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                vvp_public_form_content.setCurrentItem(position);
            }
        });


        vvp_public_form_content.setOffscreenPageLimit(10);
        vvp_public_form_content.setAdapter(contentAdapter);
        vvp_public_form_content.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                List<TextView> textViewList = titlesAdapter.getTvList();
                textViewList.get(flagPosition).setBackgroundColor(getResources().getColor(R.color.white));
                textViewList.get(flagPosition).setTextColor(getResources().getColor(R.color.gray_light));
                textViewList.get(position).setBackgroundColor(getResources().getColor(R.color.blue_band_light));
                textViewList.get(position).setTextColor(getResources().getColor(R.color.black));
                flagPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Event(value = R.id.title_left)
    private void goBack(View view){
        finish();
    }

    @Event(value = R.id.fab_submit_form_public)
    private void public_form_submit(View view){
        Snackbar.make(view, "--submit--", Snackbar.LENGTH_LONG).show();
    }

    @Event(value = R.id.fab_clear_form_public)
    private void fab_clear_form_public(View view){
        Snackbar.make(view, "--clear=-", Snackbar.LENGTH_LONG).show();
    }
}
