package atm;

import java.util.ArrayList;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import antlr.collections.List;

public interface ATMRepository extends CrudRepository<Transaction, Integer>

{
	   /*@Query("order by accid")  */
	
	public ArrayList<Transaction> findAllByAccID(String id);
	 @Query(value = "Select Sum(amt) From transaction where accid = :accid", nativeQuery = true)
	 
      public double sumByAccID( String id);
}