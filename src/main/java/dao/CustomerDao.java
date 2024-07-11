package dao;


import model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerDao implements Dao<Customer> {

    List<Customer> customers = new ArrayList<Customer>();

    @Override
    public Customer save(Customer obj) {
        obj.setId(customers.getLast().getId() + 1);
        customers.add(obj);
        return obj;
    }

    @Override
    public boolean delete(Customer obj) {
        return customers.remove(obj);
    }

    @Override
    public void deleteAll(List<Customer> entities) {
        customers.removeAll(entities);
    }

    @Override
    public void saveAll(List<Customer> entities) {
        entities.forEach(this::save);
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public boolean deleteById(long id) {
        return customers.removeIf(x -> x.getId() == id);
    }

    @Override
    public Customer getOne(long id) {
        return customers.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }
}
