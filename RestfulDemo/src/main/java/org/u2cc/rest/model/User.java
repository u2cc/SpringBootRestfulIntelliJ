package org.u2cc.rest.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="User Model",description="Holds user criteria")
public class User {

    //@JsonInclude(Include.NON_NULL) having this Jackson annotation will make the id
    //attribute disappear in case of null if intance is used as response object
    private Long id = null;
    private String firstName;
    private String lastName;

    public User(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //dataType can override the derived return type, not mandatory and used only if deemed necessary
    @ApiModelProperty(value="User id", dataType="long",required = false)
    public Long getId() {
        return id;
    }

    @ApiModelProperty(value="User's first name",dataType="String",required = true)
    public String getFirstName() {
        return firstName;
    }

    @ApiModelProperty(value="User's last name",dataType = "String",required = true)
    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
