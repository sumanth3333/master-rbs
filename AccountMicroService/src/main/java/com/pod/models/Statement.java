package com.pod.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Statement {

@Id
@GeneratedValue
private int sId;
private LocalDate date;
private String narration;
private String refNo;
private LocalDate valueDate;
private Double withdrawal;
private Double deposit;
private Double closingBalance;

}
