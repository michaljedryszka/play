package ebeanmodel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints;

@Entity
public class OrderItem {
	
	@Id
	public Long id;
	
    @Constraints.Required
    @Constraints.Min(value=0)
    public Long amount;

    @ManyToOne
    public ResellerStockItem stockItem;
}
