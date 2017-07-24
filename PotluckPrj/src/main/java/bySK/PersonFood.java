package bySK;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class PersonFood 
{


	  @NotNull
	    @Id
	    
	    @Size(min=2, max=30)
	    private String name;
	    @NotNull
	    @Size(min=2, max=30)
	    private String food;

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getFood() {
	        return food;
	    }

	    public void setFood(String food) {
	        this.food = food;
	    }
	}

