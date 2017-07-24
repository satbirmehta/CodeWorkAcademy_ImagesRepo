package atm;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository  extends CrudRepository<Account, String>
{

	
	   @Query( value = "select name from account where accountNo = :accid", nativeQuery = true)

       public String findNameByAccount(String acc);
}


