package dao;

import model.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class AccountDao implements Dao<Account> {

    List<Account> accounts = new ArrayList<Account>();

    @Override
    public Account save(Account obj) {
        if (accounts.contains(obj)) {
            accounts.set(accounts.indexOf(obj) , obj);
            return obj;
        }
        obj.setId(accounts.getLast().getId() + 1);
        accounts.add(obj);
        return obj;
    }

    @Override
    public boolean delete(Account obj) {
      return accounts.remove(obj);
    }

    @Override
    public void deleteAll(List<Account> entities) {
        accounts.removeAll(entities);
    }

    @Override
    public void saveAll(List<Account> entities) {
      entities.forEach(this::save);
    }

    @Override
    public List<Account> findAll() {
        return accounts;
    }

    @Override
    public boolean deleteById(long id) {
        return accounts.removeIf(x -> x.getId() == id);
    }

    @Override
    public Account getOne(long id) {
        return accounts.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }
}