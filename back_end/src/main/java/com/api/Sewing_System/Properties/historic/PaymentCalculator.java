package com.api.Sewing_System.Properties.historic;

import com.api.Sewing_System.Models.Discounts;

import java.util.List;
import java.util.OptionalDouble;

public class PaymentCalculator {

    public PaymentCalculator(Double price, State state){
        this.price = price;
        this.state = state;
    }

// ------------------------------------

    private Double price;
    private State state;
    private Double freightValue = freightCalculation() * 1.5;

// Methods <---------------------------

    public Double totalToPay(List<Discounts> discounts){
        return (price + freightValue) / DiscountsCalculation(discounts).getAsDouble();
    }

    public OptionalDouble DiscountsCalculation(List<Discounts> discounts){
        if (discounts != null) {
            return discounts.stream()
                     .mapToDouble(Discounts::getDiscountValue)
                     .average();

        }
        return OptionalDouble.of(1);
    }

    public Double freightCalculation(){

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
}
