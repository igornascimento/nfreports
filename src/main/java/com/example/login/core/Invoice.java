package com.example.login.core;


import java.time.LocalDateTime;

/**
 * Invoice object definition
 * @author Igor Nascimento <igornascimento@gmail.com>
 * @version 1.0
 */
@Entity
public class Invoice {

    /**
     * Invoice identification
     */
    @Column(name="cUF")
    private Integer emmiterAreaCode;
    @Column(name="natOp")
    private Integer operationNature; //venda, compra, transferência, devolução, importação, consignação, remessa
    @Column(name="indPag")
    private Integer paymentMethodCode;
    @Column(name="mod")
    private Integer invoiceModelCode;
    @Column(name="serie")
    private Integer documentSerieNumber;
    @Column(name="nNF")
    private Integer invoiceNumber;
    @Column(name="dhEmi")
    private LocalDateTime emissionDateTime;
    @Column(name="dhSaiEnt")
    private LocalDateTime movimentationDateTime;
    @Column(name="tpNF")
    private Integer operationType; // 0=entrada; 1=saida;
    @Column(name="idDest")
    private Integer operationDestination; //1=Operação interna; 2=Operação interestadual; 3=Operação com exterior.
    @Column(name="finNFe")
    private Integer invoiceGoal; // normal; complementar; ajuste; devolucao;

    /**
     * Emitter information
     */
    private Emitter emit;


    public Integer getEmmiterAreaCode() {
        return emmiterAreaCode;
    }

    public void setEmmiterAreaCode(Integer emmiterAreaCode) {
        this.emmiterAreaCode = emmiterAreaCode;
    }

    public Integer getOperationNature() {
        return operationNature;
    }

    public void setOperationNature(Integer operationNature) {
        this.operationNature = operationNature;
    }

    public Integer getPaymentMethodCode() {
        return paymentMethodCode;
    }

    public void setPaymentMethodCode(Integer paymentMethodCode) {
        this.paymentMethodCode = paymentMethodCode;
    }

    public Integer getInvoiceModelCode() {
        return invoiceModelCode;
    }

    public void setInvoiceModelCode(Integer invoiceModelCode) {
        this.invoiceModelCode = invoiceModelCode;
    }

    public Integer getDocumentSerieNumber() {
        return documentSerieNumber;
    }

    public void setDocumentSerieNumber(Integer documentSerieNumber) {
        this.documentSerieNumber = documentSerieNumber;
    }

    public Integer getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Integer invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public LocalDateTime getEmissionDateTime() {
        return emissionDateTime;
    }

    public void setEmissionDateTime(LocalDateTime emissionDateTime) {
        this.emissionDateTime = emissionDateTime;
    }

    public LocalDateTime getMovimentationDateTime() {
        return movimentationDateTime;
    }

    public void setMovimentationDateTime(LocalDateTime movimentationDateTime) {
        this.movimentationDateTime = movimentationDateTime;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }

    public Integer getOperationDestination() {
        return operationDestination;
    }

    public void setOperationDestination(Integer operationDestination) {
        this.operationDestination = operationDestination;
    }

    public Integer getInvoiceGoal() {
        return invoiceGoal;
    }

    public void setInvoiceGoal(Integer invoiceGoal) {
        this.invoiceGoal = invoiceGoal;
    }

    public Emitter getEmitter() {
        return emit;
    }

    public void setEmitter(Emitter emitter) {
        this.emit = emitter;
    }
}
