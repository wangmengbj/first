package com.project.first.entity;

import javax.persistence.*;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name="user")
//public class User implements UserDetails{
	public class User{
    @Id
    //@GeneratedValue
    private String id;
    //@Column(name="age")
    //private Integer age;
    @Column(name="name")
    private String name;
    //@Column(name="address")
    //private String address;
    @Column(name="password")
    private String password;
    //@ManyToMany(cascade={CascadeType.REFRESH},fetch= FetchType.EAGER)
    //private List<Role> roles;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}*/
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/*public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}*/
	/*@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List <GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		List<Role> roles = this.getRoles();
		for(Role role:roles){
			auths.add(new SimpleGrantedAuthority(role.getName()));
		}
		return auths;
	}
	@Override
	public String getUsername() {
	
		return name;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
    */
}