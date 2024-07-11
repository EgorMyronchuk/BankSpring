package model;
import lombok.*;

import java.util.Currency;
import java.util.UUID;

@Component
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Account {
    private Long id;
    private String number;
    private Currency currency;
    private Double balance;
    private Customer customer;
    public Account(Currency currency, Customer customer) {
        this.currency = currency;
        this.customer = customer;
        this.balance = 0.0;
        this.number = UUID.randomUUID().toString();
    }
}
