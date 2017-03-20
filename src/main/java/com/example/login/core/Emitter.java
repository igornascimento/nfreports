package com.example.login.core;

/**
 * Emitter object definition
 * @author Igor Nascimento <igornascimento@gmail.com>
 * @version 1.0
 */
public class Emitter {

    /**
     * Emitter information
     */
    @Column(name="CNPJ")
    private Integer documentNumber;
    @Column(name="xNome")
    private Integer name;
    @Column(name="xFant")
    private Integer fantasyName;
    @Column(name="IE")
    private Integer stateRegistration;

    /**
     * Emitter address
     */
    private Address enderEmit;


    public Integer getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(Integer documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Integer getFantasyName() {
        return fantasyName;
    }

    public void setFantasyName(Integer fantasyName) {
        this.fantasyName = fantasyName;
    }

    public Integer getStateRegistration() {
        return stateRegistration;
    }

    public void setStateRegistration(Integer stateRegistration) {
        this.stateRegistration = stateRegistration;
    }

    public Address getEnderEmit() {
        return enderEmit;
    }

    public void setEnderEmit(Address enderEmit) {
        this.enderEmit = enderEmit;
    }
}
