package atmPkg;

/** https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
 * Created by student on 6/20/17.
 */


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ATMRepository extends CrudRepository<Transaction, Integer> {

	
	// @Query("SELECT * FROM Transaction t where t.acc_num = :accNum")
    public List<Transaction> findAllByAcctNum(Integer acctNum);



}
