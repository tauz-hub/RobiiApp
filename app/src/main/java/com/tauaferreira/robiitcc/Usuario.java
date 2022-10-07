package com.tauaferreira.robiitcc;

public class Usuario {
    private int id;
    private String username;
    private String email;
    private String password;
    private String bithdate;
    private String name;

    public Usuario(int id, String username, String email, String password, String bithdate, String name){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.bithdate = bithdate;
        this.name = name;
    }
    public Usuario(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getBithdate() {
        return bithdate;
    }

    public void setBithdate(String bithdate) {
        this.bithdate = bithdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
