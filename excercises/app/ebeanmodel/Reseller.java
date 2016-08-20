package ebeanmodel;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.avaje.ebean.Model;

import play.data.validation.Constraints;

@Entity
public class Reseller extends Model {
	
	@Id
    public Long id;

    @Constraints.Required
    public String name;
    
    @ManyToMany
    public List<Company> companies;
    
    @OneToMany(cascade=CascadeType.ALL)
    public List<ResellerStockItem> items;
    
    @OneToMany(cascade=CascadeType.ALL)
    public List<SalesMan> sales;
}
