package model;
import lombok.*;
import org.springframework.stereotype.Component;
import utils.CustomCurrency;


import java.util.UUID;

@Component
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Account {
    private Long id;
    private String number;
    private CustomCurrency currency;
    private Double balance;
    private Customer customer;
    public Account(CustomCurrency currency, Customer customer) {
        this.currency = currency;
        this.customer = customer;
        this.balance = 0.0;
        this.number = UUID.randomUUID().toString();
    }
}
