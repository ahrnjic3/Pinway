package com.example.userservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String guid;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 20, message = "Name must contain less than 20 characters")
    private String name;

    @NotBlank(message = "Surname is mandatory")
    @Size(max = 20, message = "Surname must contain less than 20 characters")
    private String surname;

    @NotBlank(message = "Username is mandatory")
    @Size(max = 20, message = "Username must contain less than 20 characters")
    private String username;

    @Email(regexp = ".+[@].+[\\.].+")
    @Email(message="Please provide a valid email address")
    private String email;

    @NotEmpty
    //@Pattern(regexp = "^(0$|[^0]\\d{0,19}$)", flags = Pattern.Flag.MULTILINE)
    @Size(min = 5, max = 20, message = "Password must contain minimum 5 characters")
    private String password;


    @CreatedDate
    private LocalDate createdAt;


    @NotNull
    @ManyToOne
    @JoinColumn(name="typeId")
    private UserVisibilityType userVisibilityType;


//    @ManyToMany(cascade={CascadeType.ALL})
//    @JoinTable(name="EMPLOYEE_COLLEAGUE",
//            joinColumns={@JoinColumn(name="EMPLOYEE_ID")},
//            inverseJoinColumns={@JoinColumn(name="COLLEAGUE_ID")})
//    private Set<User> colleagues = new HashSet<User>();
//
//    @ManyToMany(mappedBy="colleagues")
//    private Set<User> teammates = new HashSet<User>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "relation",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "following_id"))
    private List<User> following;

    @JsonIgnoreProperties("following")
    @ManyToMany(mappedBy = "following")
    private List<User> followers;

    private Integer numOfFollowing;
    private Integer numOfFollowers;

    @JsonIgnoreProperties("user")
    @OneToMany(mappedBy = "user")
    private List<UserCollection> userCollections;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public UserVisibilityType getUserVisibilityType() {
        return userVisibilityType;
    }

    public void setUserVisibilityType(UserVisibilityType userVisibilityType) {
        this.userVisibilityType = userVisibilityType;
    }

    public Integer getNumOfFollowing() {
        return numOfFollowing;
    }

    public void setNumOfFollowing(Integer numOfFollowing) {
        this.numOfFollowing = numOfFollowing;
    }

    public Integer getNumOfFollowers() {
        return numOfFollowers;
    }

    public void setNumOfFollowers(Integer numOfFollowers) {
        this.numOfFollowers = numOfFollowers;
    }

    public List<UserCollection> getUserCollections() {
        return userCollections;
    }

    public void setUserCollections(List<UserCollection> userCollections) {
        this.userCollections = userCollections;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }
}