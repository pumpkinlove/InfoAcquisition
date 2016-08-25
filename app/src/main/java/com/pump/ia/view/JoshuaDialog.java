package com.pump.ia.view;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.pump.ia.R;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by xu.nan on 2016/8/25.
 */
public class JoshuaDialog extends DialogFragment {

    @ViewInject(R.id.tv_dialog_confirm)
    private TextView tv_confirm;
    @ViewInject(R.id.tv_dialog_cancel)
    private TextView tv_cancel;
    @ViewInject(R.id.tv_dialog_title)
    private TextView tv_title;
    @ViewInject(R.id.tv_dialog_content)
    private TextView tv_content;

    private View.OnClickListener confirmListener;
    private View.OnClickListener cancelListener;

    private String title;
    private String content;
    private String confirmMessage;
    private String cancelMessage;

    @Override
    public void onStart() {
        Log.e("------------","onStart");
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics dm = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
            dialog.getWindow().setLayout((int) (dm.widthPixels * 0.77), ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.e("------------","onCreate");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e("------------","onCreateView");
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.layout_joshua_dialog, container);
        x.view().inject(this, view);

        initData();
        initView();

        return view;
    }

    private void initData(){

    }

    private void initView(){
        if(title != null){
            tv_title.setText(title);
        }else{
            tv_title.setVisibility(View.GONE);
        }
        tv_content.setText(content);
        if(confirmMessage != null){
            tv_confirm.setText(confirmMessage);
        }
        if(cancelMessage != null){
            tv_cancel.setText(cancelMessage);
        }
        tv_confirm.setOnClickListener(confirmListener);
        tv_cancel.setOnClickListener(cancelListener);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        Log.e("------------","onDismiss");
        super.onDismiss(dialog);
    }

    @Override
    public void onDestroy() {
        Log.e("------------","onDestroy");
        super.onDestroy();
    }

    public String getCancelMessage() {
        return cancelMessage;
    }

    public void setCancelMessage(String cancelMessage) {
        this.cancelMessage = cancelMessage;
    }

    public String getConfirmMessage() {
        return confirmMessage;
    }

    public void setConfirmMessage(String confirmMessage) {
        this.confirmMessage = confirmMessage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public View.OnClickListener getCancelListener() {
        return cancelListener;
    }

    public void setCancelListener(View.OnClickListener cancelListener) {
        this.cancelListener = cancelListener;
    }

    public View.OnClickListener getConfirmListener() {
        return confirmListener;
    }

    public void setConfirmListener(View.OnClickListener confirmListener) {
        this.confirmListener = confirmListener;
    }
}
