package java9;

import java.util.Optional;

public class IfPresentOrElseDemo1 {

    public static void main(String[] args) {
        IfPresentOrElseDemo1 iPOED = new IfPresentOrElseDemo1();
        iPOED.formalAppraoch();
        iPOED.java9Approach();

    }

    private void java9Approach() {
        System.out.println("java9 approach");
        Optional<Double> discount = discountValueFor(500);
        discount.ifPresentOrElse(
                discountValue -> System.out.println("discount is "+ discountValue),
                () -> System.out.println("no discount")
        );

    }

    private void formalAppraoch() {
        System.out.println("formal approach");
        Optional<Double> offer = discountValueFor(50000);
        if(offer.isPresent()) {
            System.out.println("discount is " + offer);
        } else {
            System.out.println("no discount");
        }
    }

    private Optional<Double> discountValueFor(int input) {
        if(input >= 1000) {
            return Optional.of((input * 0.01 > 100) ? 100 : input * 0.01);
        }
        return Optional.empty();
    }
}
