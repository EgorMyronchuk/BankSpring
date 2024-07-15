package service;


import dao.CustomerDao;
import lombok.RequiredArgsConstructor;
import model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerDao customerDao;

    public Customer getCustomerById(Long id) {
        if (customerDao.getOne(id) == null) {

       }
        return customerDao.getOne(id);
    }

    public List<Customer> getAllCustomers() {
        List<Customer> mylist = customerDao.findAll();;
        if (mylist.size() == 0) {
            throw
        }
        return mylist;
    }

    public void saveCustomer(Customer customer) {
        customerDao.save(customer);
    }

    public void changeCustomer(Customer customer) {
        customerDao.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerDao.deleteById(id);
    }

    public void createAccountForCustomer(Long id , Currency currency) {
       Customer customer = customerDao.getOne(id);
        customer.getAccounts().add(new Account(currency , customer));
    }

    public void deleteAccountForCustomer(Long id , Account account ) {
        customerDao.getOne(id).getAccounts().remove(account);
    }
}
