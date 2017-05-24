package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mail_template")
public class Email {
	@Id
	@Column(name="template_id",nullable=false,unique=true)
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	public String getAdd_userid() {
		return add_userid;
	}
	public void setAdd_userid(String add_userid) {
		this.add_userid = add_userid;
	}
	public String getTemplate_name() {
		return template_name;
	}
	public void setTemplate_name(String template_name) {
		this.template_name = template_name;
	}
	public String getTemplate_cont() {
		return template_cont;
	}
	public void setTemplate_cont(String template_cont) {
		this.template_cont = template_cont;
	}
	private String template_id;  
    private String add_userid;
    private String template_name;  
    private String template_cont;
    
}
