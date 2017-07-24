

package com.example.demo.models;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

/**
 * Created by student on 7/11/17.
 */
@Entity
@Table(name = "userData")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "email", nullable = false, unique = true)
    @Email
    private String email;

    @Column(name = "password")
    @org.springframework.data.annotation.Transient
    private String password;

    @Column(name = "roleName")
    @Size(max=50)
    @NotNull
    private String roleName;


    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "username")
    private String username;

    @ManyToMany//(fetch = FetchType.EAGER)
    @JoinTable(name="follows",joinColumns = @JoinColumn(name = "followed_id"),inverseJoinColumns = @JoinColumn(name = "following_id"))
    private Collection<User> followed;

    @ManyToMany//(fetch = FetchType.EAGER)
    @JoinTable(name="follows",joinColumns = @JoinColumn(name = "following_id"),inverseJoinColumns = @JoinColumn(name = "followed_id"))
    private Collection<User> follower;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="likes",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "image_id"))
    private Collection<Image> likes;

    public User(String email, String password, boolean enabled, String username) {
        this.email = email;
        this.password = password;

        this.enabled = enabled;
        this.username = username;
    }

    public User() {
    }

    //  Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Collection<User> getFollowed() {
        return followed;
    }

    public void setFollowed(Collection<User> followed) {
        this.followed = followed;
    }

    public Collection<User> getFollower() {
        return follower;
    }

    public void setFollower(Collection<User> follower) {
        this.follower = follower;
    }

    public Collection<Image> getLikes() {
        return likes;
    }

    public void setLikes(Collection<Image> likes) {
        this.likes = likes;
    }
}
