package ebeanmodel;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.avaje.ebean.Model;

import play.data.validation.Constraints;

@Entity
public class ResellerStockItem extends Model {

	@Id
	public Long id;

	@Constraints.Required
	@Constraints.Min(value = 0)
	public BigDecimal price;

	@Constraints.Required
	@ManyToOne
	public Computer computer;
}
