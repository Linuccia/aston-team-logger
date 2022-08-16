package org.aston.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "log")
public class Log{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "message")
    private String message;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;
}
