package cz.marek.insurance.models.dto;

import jakarta.validation.constraints.*;

public class InsuredDTO {

    private long insuredId;
    @Pattern(regexp = "^[0-9]{9,10}$", message = "Musí obsahovat 9 nebo 10 čísel")
    @NotBlank(message = "Vyplňte rodné číslo")
    @NotNull(message = "Vyplňte rodné číslo")
    private String birthNumber;
    @NotBlank(message = "Vyplňte jméno")
    @NotNull(message = "Vyplňte jméno")
    private String firstName;
    @NotBlank(message = "Vyplňte příjmení")
    @NotNull(message = "Vyplňte příjmení")
    private String lastName;
    @NotBlank(message = "Vyplňte email")
    @NotNull(message = "Vyplňte email")
    private String email;
    @Pattern(regexp = "^[0-9]{9}$", message = "Musí obsahovat 9 čísel")
    @NotBlank(message = "Vyplňte telefon")
    @NotNull(message = "Vyplňte telefon")
    private String phone;
    @NotBlank(message = "Vyplňte ulici")
    @NotNull(message = "Vyplňte ulici")
    private String street;
    @NotBlank(message = "Vyplňte město")
    @NotNull(message = "Vyplňte město")
    private String city;

    @Pattern(regexp = "^[0-9]{5}$", message = "Musí obsahovat 5 čísel")
    @NotBlank(message = "Vyplňte PSČ")
    @NotNull(message = "Vyplňte PSČ")
    private String psc;

    //Getters and Setters

    public long getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(long insuredId) {
        this.insuredId = insuredId;
    }

    public String getBirthNumber() {
        return birthNumber;
    }

    public void setBirthNumber(String birthNumber) {
        this.birthNumber = birthNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }
}
