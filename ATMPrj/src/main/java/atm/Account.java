package atm;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;





@Entity
public class Account 
{
	@Id
	
	@Size(min=7, max=7)
	private String accountNo;
	
	@NotNull
	private String name;
	
	@NotNull
	private String pin;

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public String getName() {
		return name;
	}
	public String getPin() {
		return pin;
	}
	

}
