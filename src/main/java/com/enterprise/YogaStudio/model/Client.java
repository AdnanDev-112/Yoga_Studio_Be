package com.enterprise.YogaStudio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "client")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false)
    private Integer id;

    @Column(name = "client_name", nullable = false, length = 150)
    private String clientName;

    @Column(name = "email", nullable = false, length = 128)
    private String email;

    @Column(name = "address", nullable = false, length = 512)
    private String address;

    @Column(name = "telnum", nullable = false, length = 16)
    private String telnum;

    @Column(name = "DOB")
    private LocalDate dob;

    @Column(name = "client_discount_status", nullable = false)
    private Boolean clientDiscountStatus = false;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "studio_id", nullable = true)
    private Studio studio;

}


//package com.enterprise.YogaStudio.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.antlr.v4.runtime.misc.NotNull;
//
//import java.time.LocalDate;
//
//@Getter
//@Setter
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "client")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//public class Client {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "client_id", nullable = false)
//    private Integer id;
//
//    @Column(name = "client_name", nullable = false, length = 150)
//    private String clientName;
//
//    @Column(name = "email", nullable = false, length = 128)
//    private String email;
//
//    @Column(name = "address", nullable = false, length = 512)
//    private String address;
//
//    @Column(name = "telnum", nullable = false, length = 16)
//    private String telnum;
//
//    @Column(name = "DOB")
//    private LocalDate dob;
//
//    @Column(name = "client_discount_status", nullable = false)
//    private Boolean clientDiscountStatus = false;
//
//    @JsonIgnore
//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "studio_id", nullable = true)
//    private Studio studio;
//
//}