package com.epam.wizzair.page;

import com.epam.wizzair.page.util.BaggageCabinOptions;
import com.epam.wizzair.page.util.BaggageCheckedOptions;

/**
 * Created by Dzmitry_Sankouski on 06-Mar-17.
 */
public interface IPassenger {

    public void setCheckedInBaggage(BaggageCheckedOptions depOption);

    public void setCheckedInBaggage(BaggageCheckedOptions depOption, BaggageCheckedOptions retOption);

    public void setCabinBaggage(BaggageCabinOptions depOption);

    public void setCabinBaggage(BaggageCabinOptions depOption, BaggageCabinOptions retOption);

    public void setSportEquipment(boolean isDepEnabled, boolean isRetEnabled);

    public void setSportEquipment(boolean isDepEnabled);

    public void setCheckInMethod(boolean isDepOnline, boolean isRetOnline);

    public void setCheckInMethod(boolean isDepOnline);

    public void gotoSeatSelection();

    public void confirm();

}
