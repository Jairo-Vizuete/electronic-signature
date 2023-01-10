package com.bigdataca.electronicsignatureservice;

import com.bigdataca.electronicsignatureservice.service.SignatureService;
import com.bigdataca.electronicsignatureservice.utilities.CertificateInformation;
import com.bigdataca.electronicsignatureservice.utilities.ValidateSignaturePDF;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.StampingProperties;
import com.itextpdf.signatures.*;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.*;
import java.util.Date;
import java.util.Enumeration;

import static com.bigdataca.electronicsignatureservice.utilities.ValidateSignaturePDF.getAlias;

//@SpringBootApplication
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ElectronicSignatureServiceApplication {
//    public static final String DEST = "C:/Test/response/";
//
//    public static final String KEYSTORE = "C:/Test/request/certificate.p12";
//    public static final String SRC = "C:/Test/request/input.pdf";
//
//    public static final char[] PASSWORD = "Bigdata2021".toCharArray();
//
////    public static final String[] RESULT_FILES = new String[]{"test_signed1.pdf", "test_signed2.pdf", "test_signed3.pdf", "test_signed4.pdf"};
//
//    public static final String RESULT_FILES = "test_signed1.pdf";
//
//    public void sign(String src, String dest, Certificate[] chain, PrivateKey pk, String digestAlgorithm, String provider, PdfSigner.CryptoStandard signatureType, String reason, String location) throws GeneralSecurityException, IOException {
//        PdfReader reader = new PdfReader(src);
//        PdfSigner signer = new PdfSigner(reader, new FileOutputStream(dest), new StampingProperties());
//
//        // Create the signature appearance
//        Rectangle rect = new Rectangle(36, 648, 200, 50);
//        PdfSignatureAppearance appearance = signer.getSignatureAppearance();
//        appearance.setReason(reason).setLocation(location)
//
//                // Specify if the appearance before field is signed will be used
//                // as a background for the signed field. The "false" value is the default value.
//                .setReuseAppearance(false).setPageRect(rect).setPageNumber(1);
//        signer.setFieldName("mySignature");
//
//        IExternalSignature pks = new PrivateKeySignature(pk, digestAlgorithm, provider);
//        IExternalDigest digest = new BouncyCastleDigest();
//
//        // Sign the document using the detached mode, CMS or CAdES equivalent.
//
//        signer.signDetached(digest, pks, chain, null, null, null, 0, signatureType);
//
//    }

    public static void main(String[] args) throws GeneralSecurityException, IOException {
		SpringApplication.run(ElectronicSignatureServiceApplication.class, args);

//        File file = new File(DEST);
//        file.mkdirs();
//
//
//        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
//        System.out.println(KeyStore.getDefaultType().toString());
//        ks.load(new FileInputStream(KEYSTORE), PASSWORD);
//
//        String alias = getAlias(ks);
////        String alias = ks.aliases().nextElement();
//        PrivateKey pk = (PrivateKey) ks.getKey(alias, PASSWORD);
//        Certificate[] chain = ks.getCertificateChain(alias);

//        X509Certificate certificate = (X509Certificate) ks.getCertificate(alias);
//        CertificateInformation ic = new ValidateSignaturePDF().obtenerInformacionFirmante(certificate);
//        System.out.println(ic);
//
//        Date fechaEmision = certificate.getNotBefore();
//        Date fechaCaducidad = certificate.getNotAfter();
//
//        String rucCertificado = ic.getRuc();
//        String cedulaCertificado = ic.getCedulaRepresentante();
//        boolean validarRuc = "1792547164001" != null && !"1792547164001".trim().equals("");
//
//        if (validarRuc && !rucCertificado.equals("1792547164001")) {
//            System.out.println("El RUC del Certificado de Firma no coincide con el RUC de la empresa relacionada al usuario Firmante.");
//        } else if (!cedulaCertificado.equals("1751154715")) {
//            System.out.println("La Cédula o Pasaporte del Certificado de Firma no coincide con la Cédula o Pasaporte relacionado al usuario Firmante.");
//        } else if (!validarRuc && !rucCertificado.equals("") && !rucCertificado.contains(cedulaCertificado)) {
//            System.out.println("El Certificado de Firma no corresponde a una Persona Natural.");
//        } else if (!fechaEmision.before(new Date())) {
//            System.out.println("La Fecha de Emisión del Certificado de Firma no es válida.");
//        } else if (!fechaCaducidad.after(new Date())) {
//            System.out.println("El Certificado de Firma ha caducado..");
//        } else {
//            BouncyCastleProvider provider = new BouncyCastleProvider();
//            Security.addProvider(provider);
//            ElectronicSignatureServiceApplication app = new ElectronicSignatureServiceApplication();
//            app.sign(SRC, DEST + RESULT_FILES, chain, pk, "SHA-256", provider.getName(), PdfSigner.CryptoStandard.CMS, "Test 1", "Quito");

//        }
//
//
////        ElectronicSignatureServiceApplication app = new ElectronicSignatureServiceApplication();
//        app.sign(SRC, DEST + RESULT_FILES[0], chain, pk, DigestAlgorithms.SHA1, provider.getName(),
//                PdfSigner.CryptoStandard.CMS, "Test 1", "Quito");
//        app.sign(SRC, DEST + RESULT_FILES[1], chain, pk, DigestAlgorithms.SHA256, provider.getName(),
//                PdfSigner.CryptoStandard.CMS, "Test 2", "Quito");
//        app.sign(SRC, DEST + RESULT_FILES[2], chain, pk, DigestAlgorithms.SHA384, provider.getName(),
//                PdfSigner.CryptoStandard.CMS, "Test 3", "Quito");
//        app.sign(SRC, DEST + RESULT_FILES[3], chain, pk, DigestAlgorithms.SHA512, provider.getName(),
//                PdfSigner.CryptoStandard.CMS, "Test 4", "Quito");
//        System.out.println("The pdf file was successfully created!");
    }

}
