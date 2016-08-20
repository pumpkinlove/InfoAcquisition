package com.pump.ia.domain.sheetContent.rural;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/21 0021.
 * 所属行政村
 */
public class AdministrativeVillage implements Serializable {

    private String administrativeVillage;               //所属行政村

    public String getAdministrativeVillage() {
        return administrativeVillage;
    }

    public void setAdministrativeVillage(String administrativeVillage) {
        this.administrativeVillage = administrativeVillage;
    }
}
