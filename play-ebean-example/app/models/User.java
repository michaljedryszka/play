package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.avaje.ebean.Model;

import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.Required;

@Entity
@Table(name="t_user")
public class User extends Model{
	
	@Id
	@Email
	@Required
	public String email;
	
	@Required
	public String password;
	
    /**
     * Generic query helper for entity Company with id Long
     */
    public static Find<String,User> find = new Find<String,User>(){};
	
}
