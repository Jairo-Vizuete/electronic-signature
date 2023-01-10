package com.bigdataca.electronicsignatureservice.utilities;

import java.io.Serializable;
import java.util.Date;

public class CertificateInformation implements Serializable {
    private String titulo;
    private String identificadorXML;
    private String razonSocial;
    private String ruc;
    private String cedulaRepresentante;
    private String nombresRepresentante;
    private String primerApellidoRepresentante;
    private String segundoApellidoRepresentante;
    private String cargoRepresentante;
    private String direccionEmpresa;
    private String telefonoEmpresa;
    private String ciudadEmpresa;
    private String paisEmpresa;
    private String tipoCertificado;
    private String validezFirma;
    private String informacionAutoridadCertificacion;
    private String algoritmoFirma;
    private Date fechaFirma;
    private Date validoDesde;
    private Date validoHasta;

    public CertificateInformation() {
    }

    public CertificateInformation(String titulo, String identificadorXML, String razonSocial, String ruc, String cedulaRepresentante, String nombresRepresentante, String primerApellidoRepresentante, String segundoApellidoRepresentante, String cargoRepresentante, String direccionEmpresa, String telefonoEmpresa, String ciudadEmpresa, String paisEmpresa, String tipoCertificado, String validezFirma, String informacionAutoridadCertificacion, String algoritmoFirma, Date fechaFirma, Date validoDesde, Date validoHasta) {
        this.titulo = titulo;
        this.identificadorXML = identificadorXML;
        this.razonSocial = razonSocial;
        this.ruc = ruc;
        this.cedulaRepresentante = cedulaRepresentante;
        this.nombresRepresentante = nombresRepresentante;
        this.primerApellidoRepresentante = primerApellidoRepresentante;
        this.segundoApellidoRepresentante = segundoApellidoRepresentante;
        this.cargoRepresentante = cargoRepresentante;
        this.direccionEmpresa = direccionEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
        this.ciudadEmpresa = ciudadEmpresa;
        this.paisEmpresa = paisEmpresa;
        this.tipoCertificado = tipoCertificado;
        this.validezFirma = validezFirma;
        this.informacionAutoridadCertificacion = informacionAutoridadCertificacion;
        this.algoritmoFirma = algoritmoFirma;
        this.fechaFirma = fechaFirma;
        this.validoDesde = validoDesde;
        this.validoHasta = validoHasta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdentificadorXML() {
        return identificadorXML;
    }

    public void setIdentificadorXML(String identificadorXML) {
        this.identificadorXML = identificadorXML;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getCedulaRepresentante() {
        return cedulaRepresentante;
    }

    public void setCedulaRepresentante(String cedulaRepresentante) {
        this.cedulaRepresentante = cedulaRepresentante;
    }

    public String getNombresRepresentante() {
        return nombresRepresentante;
    }

    public void setNombresRepresentante(String nombresRepresentante) {
        this.nombresRepresentante = nombresRepresentante;
    }

    public String getPrimerApellidoRepresentante() {
        return primerApellidoRepresentante;
    }

    public void setPrimerApellidoRepresentante(String primerApellidoRepresentante) {
        this.primerApellidoRepresentante = primerApellidoRepresentante;
    }

    public String getSegundoApellidoRepresentante() {
        return segundoApellidoRepresentante;
    }

    public void setSegundoApellidoRepresentante(String segundoApellidoRepresentante) {
        this.segundoApellidoRepresentante = segundoApellidoRepresentante;
    }

    public String getCargoRepresentante() {
        return cargoRepresentante;
    }

    public void setCargoRepresentante(String cargoRepresentante) {
        this.cargoRepresentante = cargoRepresentante;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public String getCiudadEmpresa() {
        return ciudadEmpresa;
    }

    public void setCiudadEmpresa(String ciudadEmpresa) {
        this.ciudadEmpresa = ciudadEmpresa;
    }

    public String getPaisEmpresa() {
        return paisEmpresa;
    }

    public void setPaisEmpresa(String paisEmpresa) {
        this.paisEmpresa = paisEmpresa;
    }

    public String getTipoCertificado() {
        return tipoCertificado;
    }

    public void setTipoCertificado(String tipoCertificado) {
        this.tipoCertificado = tipoCertificado;
    }

    public String getValidezFirma() {
        return validezFirma;
    }

    public void setValidezFirma(String validezFirma) {
        this.validezFirma = validezFirma;
    }

    public String getInformacionAutoridadCertificacion() {
        return informacionAutoridadCertificacion;
    }

    public void setInformacionAutoridadCertificacion(String informacionAutoridadCertificacion) {
        this.informacionAutoridadCertificacion = informacionAutoridadCertificacion;
    }

    public String getAlgoritmoFirma() {
        return algoritmoFirma;
    }

    public void setAlgoritmoFirma(String algoritmoFirma) {
        this.algoritmoFirma = algoritmoFirma;
    }

    public Date getFechaFirma() {
        return fechaFirma;
    }

    public void setFechaFirma(Date fechaFirma) {
        this.fechaFirma = fechaFirma;
    }

    public Date getValidoDesde() {
        return validoDesde;
    }

    public void setValidoDesde(Date validoDesde) {
        this.validoDesde = validoDesde;
    }

    public Date getValidoHasta() {
        return validoHasta;
    }

    public void setValidoHasta(Date validoHasta) {
        this.validoHasta = validoHasta;
    }

    @Override
    public String toString() {
        return "CertificateInformation{" +
                "titulo='" + titulo + '\'' +
                ", identificadorXML='" + identificadorXML + '\'' +
                ", razonSocial='" + razonSocial + '\'' +
                ", ruc='" + ruc + '\'' +
                ", cedulaRepresentante='" + cedulaRepresentante + '\'' +
                ", nombresRepresentante='" + nombresRepresentante + '\'' +
                ", primerApellidoRepresentante='" + primerApellidoRepresentante + '\'' +
                ", segundoApellidoRepresentante='" + segundoApellidoRepresentante + '\'' +
                ", cargoRepresentante='" + cargoRepresentante + '\'' +
                ", direccionEmpresa='" + direccionEmpresa + '\'' +
                ", telefonoEmpresa='" + telefonoEmpresa + '\'' +
                ", ciudadEmpresa='" + ciudadEmpresa + '\'' +
                ", paisEmpresa='" + paisEmpresa + '\'' +
                ", tipoCertificado='" + tipoCertificado + '\'' +
                ", validezFirma='" + validezFirma + '\'' +
                ", informacionAutoridadCertificacion='" + informacionAutoridadCertificacion + '\'' +
                ", algoritmoFirma='" + algoritmoFirma + '\'' +
                ", fechaFirma=" + fechaFirma +
                ", validoDesde=" + validoDesde +
                ", validoHasta=" + validoHasta +
                '}';
    }
}
