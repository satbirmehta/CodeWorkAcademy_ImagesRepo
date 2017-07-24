package atmPkg;

/**https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-introduction-to-query-methods/
 * Created by student on 6/23/17.
 */

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by student on 6/20/17.
 */


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Integer> {

    public List<Account> findAllByAcctNum(Integer acctNum);
  

    public Account findOneByUserName(String userName);

    public List<Account> findAllByUserName(String userName);

    public Account findOneByAcctNum(Integer acctNum);


}