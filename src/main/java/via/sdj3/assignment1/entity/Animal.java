package via.sdj3.assignment1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table
public class Animal {
    @Id
    @Column private int registrationNum;
    @Column
    private LocalDate dateReceived;
    @Column
    private double weight;
    @Column
    private String origin;

    public Animal(int registrationNum, LocalDate dateReceived, double weight, String origin) {
        this.registrationNum = registrationNum;
        this.dateReceived = dateReceived;
        this.weight = weight;
        this.origin = origin;
    }

    public Animal() {
    }


    public int getRegistrationNum() {
        return registrationNum;
    }

    public void setRegistrationNum(int registrationNum) {
        this.registrationNum = registrationNum;
    }

    public LocalDate getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(LocalDate dateReceived) {
        this.dateReceived = dateReceived;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
