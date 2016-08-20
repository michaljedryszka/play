package ebeanmodel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.avaje.ebean.Model;

import play.data.validation.Constraints;

@Entity
public class SalesMan extends Model {
	
	@Id
    public Long id;
    
    @Constraints.Required
    public String name;

	@Constraints.Required
	@ManyToOne
	public Reseller reseller;
}
