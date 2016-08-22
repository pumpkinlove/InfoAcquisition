package com.pump.ia.fragment.form.share;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.pump.ia.R;
import com.pump.ia.domain.sheetContent.Conclusion;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConclusionFragment extends Fragment {

    private Conclusion conclusion;

    @ViewInject(R.id.et_conclusion)
    private EditText et_conclusion;
    @ViewInject(R.id.et_remark)
    private EditText et_remark;
    @ViewInject(R.id.et_recorder)
    private EditText et_recorder;

    public Conclusion getConclusion(){
        conclusion.setConclusion(et_conclusion.getText().toString());
        conclusion.setRemark(et_remark.getText().toString());
        conclusion.setRecorder(et_recorder.getText().toString());
        return conclusion;
    }

    public ConclusionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_conclusion, container, false);
        x.view().inject(this, v);

        return v;
    }

}
