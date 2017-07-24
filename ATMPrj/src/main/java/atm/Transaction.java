package atm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int transID;

    private String accID;
    
    
    @NotNull
    private double amt;
    
    @Size(max=9000)
    private String reason;

    public int getTransID() {
		return transID;
	}

	public String getAccID() {
		return accID;
	}

	public double getAmt() {
		return amt;
	}

	public String getReason() {
		return reason;
	}

	public void setTransID(int transID) {
		this.transID = transID;
	}

	public void setAccID(String accID) {
		this.accID = accID;
	}

	public void setAmt(double amt) {
		this.amt = amt;
	}

	public void setReason(String reason) {
		this.reason = reason;
		
		
	}
		 public void setNegAmt()
		{
			amt =(-1)  * amt;
		}

		@Override
		public String toString() {
			
			String type = (amt>0)? "Deposit" : "Withdraw";
			return "Transaction [accID=" + accID + ", amt=" + Math.abs( amt) + ", reason="
					+ reason + "]";
		}
		 
		 
	





	
}
