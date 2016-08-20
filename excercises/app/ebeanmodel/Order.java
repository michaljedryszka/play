package ebeanmodel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.data.format.Formats;

@Entity
@Table(name="o_order")
public class Order {

	@Id
	@Column(name="id")
    public Long id;

    @Formats.DateTime(pattern="yyyy-MM-dd")
    public Date created;
    
    @Formats.DateTime(pattern="yyyy-MM-dd")
    public Date shipped;

    @OneToMany(cascade=CascadeType.ALL)
    public List<OrderItem> items;
    
    public BigDecimal discountedPrice;
    
    @ManyToOne
    public SalesMan salesMan;
}
