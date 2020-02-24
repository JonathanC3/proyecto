package com.ucr.proyecto.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    @Size(min = 3, max = 20)
    @NotEmpty(message = "*Please provide your name")
    private String name;
    @Column(name = "first_surname")
    @NotEmpty(message = "*Please provide your first surname")
    private String firstSurname;
    @Column(name = "second_surname")
    @NotEmpty(message = "*Please provide your second surname")
    private String secondSurname;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    @Size(min = 6, max = 20)
    private String phone;
    @Column(name="password")
    @NotNull
    private String password;
    @Column(name = "second_contact")
    private String secondContact;
    @Column(name = "email")
    @Email
    @NotNull
    private String email;

    @Column(name = "services")
    private String services;

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstSurname='" + firstSurname + '\'' +
                ", secondSurname='" + secondSurname + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", secondContact='" + secondContact + '\'' +
                ", email='" + email + '\'' +
                ", services='" + services + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id &&
                Objects.equals(name, client.name) &&
                Objects.equals(firstSurname, client.firstSurname) &&
                Objects.equals(secondSurname, client.secondSurname) &&
                Objects.equals(address, client.address) &&
                Objects.equals(phone, client.phone) &&
                Objects.equals(password, client.password) &&
                Objects.equals(secondContact, client.secondContact) &&
                Objects.equals(email, client.email) &&
                Objects.equals(services, client.services);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, firstSurname, secondSurname, address, phone, password, secondContact, email, services);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecondContact() {
        return secondContact;
    }

    public void setSecondContact(String secondContact) {
        this.secondContact = secondContact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }


}
