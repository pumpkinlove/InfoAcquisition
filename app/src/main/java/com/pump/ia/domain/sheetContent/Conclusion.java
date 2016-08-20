package com.pump.ia.domain.sheetContent;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/21 0021.
 * 结论、备注、记录人
 */
public class Conclusion implements Serializable {

    private String conclusion;              //结论
    private String remark;                  //备注
    private String recorder;                //记录人

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }
}
