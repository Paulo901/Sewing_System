package com.api.Sewing_System.Properties.historic;

import com.api.Sewing_System.Models.Discounts;

import java.util.List;
import java.util.OptionalDouble;

public class PaymentCalculator {

    public PaymentCalculator(Double price, State state, List<Discounts> discounts){
        this.price = price;
        this.freightValue = freightCalculation(state) * 1.5;

        totalToPay(discounts);
    }

// ------------------------------------

    private Double price;

    private Double totalDiscounts = 0.0;

    private Double freightValue;

    private Double total;

// Methods <---------------------------

    public void totalToPay(List<Discounts> discounts){
        DiscountsCalculation(discounts);
        total = (price + freightValue)/ totalDiscounts;
    }

    public void DiscountsCalculation(List<Discounts> discounts){
        if (discounts != null) {
            discounts.forEach(discount -> totalDiscounts += discount.getDiscountValue());
        }else{
            totalDiscounts = 1.0;
        }
    }

    public Double freightCalculation(State state){

        switch (state){
            case AC -> {return 14.0;}
            case AM -> {return 14.0;}
            case AP -> {return 13.0;}
            case PA -> {return 13.0;}
            case RO -> {return 13.0;}
            case RR -> {return 14.0;}
            case TO -> {return 12.0;}

            case CE -> {return 0.0;}
            case MA -> {return 8.0;}
            case AL -> {return 9.0;}
            case BA -> {return 9.0;}
            case PI -> {return 6.0;}
            case RN -> {return 6.0;}
            case PE -> {return 8.0;}
            case PB -> {return 7.0;}
            case SE -> {return 10.0;}

            case MT -> {return 13.0;}
            case MS -> {return 15.0;}
            case GO -> {return 12.5;}
            case DF -> {return 13.0;}

            case MG -> {return 15.0;}
            case ES -> {return 15.0;}
            case SP -> {return 18.0;}
            case RJ -> {return 19.0;}

            case PR -> {return 20.0;}
            case RS -> {return 22.5;}
            case SC -> {return 22.0;}

            default -> {return 0.0;}

        }
    }

    public Double getTotal() {
        return total;
    }
}
