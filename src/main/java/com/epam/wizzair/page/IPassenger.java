package com.epam.wizzair.page;

import com.epam.wizzair.page.exception.ElementNotActiveException;
import com.epam.wizzair.page.impl.Passenger;
import com.epam.wizzair.page.util.BaggageCabinOptions;
import com.epam.wizzair.page.util.BaggageCheckedOptions;
import com.epam.wizzair.page.util.CheckInMethod;

/**
 * Created by Dzmitry_Sankouski on 06-Mar-17.
 */
public interface IPassenger {

    //sets checked-in baggage in accordance with arguments (depOption for Departure, retOption is for Return)
    public Passenger setCheckedInBaggage(BaggageCheckedOptions depOption);

    public Passenger setCheckedInBaggage(BaggageCheckedOptions depOption, BaggageCheckedOptions retOption);

    //sets cabin baggage
    public Passenger setCabinBaggage(BaggageCabinOptions depOption);

    public Passenger setCabinBaggage(BaggageCabinOptions depOption, BaggageCabinOptions retOption);

    //SportEquipment
    public boolean isDepSportEquipmentEn();//returns true if Departure Sport Equipment added

    public boolean isRetSportEquipmentEn();//returns true if Return Sport Equipment added

    public Passenger setSportEquipment(boolean isDepEnabled, boolean isRetEnabled);

    public Passenger setSportEquipment(boolean isDepEnabled);


    public Passenger setCheckInMethod(CheckInMethod depMethod, CheckInMethod retMethod);

    public Passenger setCheckInMethod(CheckInMethod depMethod);




    public void gotoDepSeatSelection();

    public void gotoRetSeatSelection();

    public void submit() throws ElementNotActiveException;

}
