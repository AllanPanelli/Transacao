package com.ProcessoSeletivo.ProcessoSeletivo.domain;

import com.ProcessoSeletivo.ProcessoSeletivo.hardcode.CardApplication;
import com.ProcessoSeletivo.ProcessoSeletivo.hardcode.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Transaction {

    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Id
    private Long id;


    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

    @Column(name = "time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime time;

    private BigDecimal value;

    private CardApplication cardApplication;

    private PaymentStatus status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public CardApplication getCardApplication() {
        return cardApplication;
    }

    public void setCardApplication(CardApplication cardApplication) {
        this.cardApplication = cardApplication;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}
