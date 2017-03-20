package com.example.login.core;

/**
 * Address object definition
 * @author Igor Nascimento <igornascimento@gmail.com>
 * @version 1.0
 */
public class Address {

    /**
     * Address info
     */
    @Column(name="xLgr")
    private String address;
    @Column(name="nro")
    private Integer number;
    @Column(name="xBairro")
    private String neighborhood;
    @Column(name="xMun")
    private String city;
    @Column(name="UF")
    private String state;
    @Column(name="CEP")
    private Integer zipCode;
    @Column(name="xPais")
    private String country;
    @Column(name="fone")
    private Integer phone;

}
