package com.bigdataca.electronicsignatureservice.utilities;

import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERUTF8String;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.Principal;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

public class ValidateSignaturePDF {

    public static String getAlias(KeyStore keyStore) {
        String alias = null;
        Enumeration nombres;
        try {
            nombres = keyStore.aliases();
            while (nombres.hasMoreElements()) {
                String tmpAlias = (String) nombres.nextElement();

                if (keyStore.isKeyEntry(tmpAlias) && tmpAlias.contains("signing key")) {
                    alias = tmpAlias;
                    break;
                } else {
                    alias = tmpAlias;
                }
            }
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return alias;
    }

    public CertificateInformation obtenerInformacionFirmante(X509Certificate xc) {
        CertificateInformation ic = new CertificateInformation();
        Principal issuerDN = xc.getIssuerX500Principal();
        System.out.println("issuerDN: " + issuerDN);
        try {
            if (xc.getIssuerDN().getName().contains("BANCO CENTRAL DEL ECUADOR")) {
                System.out.println("YES");
                ic.setTitulo("");
                ic.setRazonSocial(getExtensionValue(xc, "1.3.6.1.4.1.37947.3.10"));
                ic.setRuc(getExtensionValue(xc, "1.3.6.1.4.1.37947.3.11"));
                ic.setCedulaRepresentante(getExtensionValue(xc, "1.3.6.1.4.1.37947.3.1"));
                ic.setNombresRepresentante(getExtensionValue(xc, "1.3.6.1.4.1.37947.3.2"));
                ic.setPrimerApellidoRepresentante(getExtensionValue(xc, "1.3.6.1.4.1.37947.3.3"));
                ic.setSegundoApellidoRepresentante(getExtensionValue(xc, "1.3.6.1.4.1.37947.3.4"));
                ic.setCargoRepresentante(getExtensionValue(xc, "1.3.6.1.4.1.37947.3.5"));
                ic.setDireccionEmpresa(getExtensionValue(xc, "1.3.6.1.4.1.37947.3.7"));
                ic.setTelefonoEmpresa(getExtensionValue(xc, "1.3.6.1.4.1.37947.3.8"));
                ic.setCiudadEmpresa(getExtensionValue(xc, "1.3.6.1.4.1.37947.3.9"));
                ic.setPaisEmpresa(getExtensionValue(xc, "1.3.6.1.4.1.37947.3.12"));
                ic.setTipoCertificado(getExtensionValue(xc, "1.3.6.1.4.1.37947.3.51"));
                ic.setInformacionAutoridadCertificacion(xc.getIssuerDN().toString().split("CN=")[1]);
                ic.setAlgoritmoFirma(xc.getSigAlgName());
                ic.setValidoDesde(xc.getNotBefore());
                ic.setValidoHasta(xc.getNotAfter());
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }

        return ic;
    }

    private String getExtensionValue(X509Certificate X509Certificate, String oid) throws IOException {
        String decoded = "-";
        byte[] extensionValue = X509Certificate.getExtensionValue(oid);

        if (extensionValue != null) {
            ASN1Primitive derObject = toDERObject(extensionValue);
            if (derObject instanceof DEROctetString) {
                DEROctetString derOctetString = (DEROctetString) derObject;

                derObject = toDERObject(derOctetString.getOctets());
                decoded = derObject.toString();
                if (derObject instanceof DERUTF8String) {
                    DERUTF8String s = DERUTF8String.getInstance(derObject);
                    decoded = s.getString();
                }

            }
        }
        return decoded;
    }


    private ASN1Primitive toDERObject(byte[] data) throws IOException {
        ByteArrayInputStream inStream = new ByteArrayInputStream(data);
        ASN1InputStream asnInputStream = new ASN1InputStream(inStream);
        return asnInputStream.readObject();
    }

}
