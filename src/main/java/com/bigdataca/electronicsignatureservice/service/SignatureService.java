package com.bigdataca.electronicsignatureservice.service;

import com.bigdataca.electronicsignatureservice.ElectronicSignatureServiceApplication;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.StampingProperties;
import com.itextpdf.signatures.*;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.stereotype.Service;

import java.io.*;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Enumeration;

import static com.bigdataca.electronicsignatureservice.utilities.ValidateSignaturePDF.getAlias;

@Service
public class SignatureService {

    public static final String DEST = "C:/Test/response/";
//    public static final String DEST = "Descargas";

    public static final String KEYSTORE = "C:/Test/request/certificate.p12";
    public static final String SRC = "C:/Test/request/input1.pdf";

    public static final char[] PASSWORD = "Bigdata2021".toCharArray();

    public static final String RESULT_FILES = "test_signed1.pdf";

//    public void sign(String src, String dest, Certificate[] chain, PrivateKey pk, String digestAlgorithm,
//                     String provider, PdfSigner.CryptoStandard signatureType, String reason, String location)
//            throws GeneralSecurityException, IOException {
    public void sign(byte[] src, String dest, Certificate[] chain, PrivateKey pk, String digestAlgorithm,
                     String provider, PdfSigner.CryptoStandard signatureType, String reason, String location)
            throws GeneralSecurityException, IOException {
        InputStream pdfFile = new ByteArrayInputStream(src);
        PdfReader reader = new PdfReader(pdfFile);
        PdfSigner signer = new PdfSigner(reader, new FileOutputStream(dest), new StampingProperties());

        // Create the signature appearance
        Rectangle rect = new Rectangle(36, 648, 200, 50);
        PdfSignatureAppearance appearance = signer.getSignatureAppearance();
        appearance.setReason(reason).setLocation(location)

                // Specify if the appearance before field is signed will be used
                // as a background for the signed field. The "false" value is the default value.
                .setReuseAppearance(false).setPageRect(rect).setPageNumber(1);
        signer.setFieldName("mySignature");

        IExternalSignature pks = new PrivateKeySignature(pk, digestAlgorithm, provider);
        IExternalDigest digest = new BouncyCastleDigest();

        // Sign the document using the detached mode, CMS or CAdES equivalent.
        signer.signDetached(digest, pks, chain, null, null, null, 0, signatureType);
    }

    public void signerService(byte[] pdfFile,byte[] p12File, String password) throws GeneralSecurityException, IOException {
        System.out.println(pdfFile);
        System.out.println(p12File);
        System.out.println(password);

        File file = new File(DEST);
        file.mkdirs();

        InputStream inputStream = new ByteArrayInputStream(p12File);
        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
//        System.out.println(KeyStore.getDefaultType().toString());
//        ks.load(new FileInputStream(KEYSTORE), PASSWORD);
        ks.load(inputStream, password.toCharArray());

        String alias = getAlias(ks);

//        PrivateKey pk = (PrivateKey) ks.getKey(alias, PASSWORD);
        PrivateKey pk = (PrivateKey) ks.getKey(alias, password.toCharArray());
        Certificate[] chain = ks.getCertificateChain(alias);
        BouncyCastleProvider provider = new BouncyCastleProvider();
        Security.addProvider(provider);
        System.out.println("Provider name: "+provider.getName());
        SignatureService app = new SignatureService();
        app.sign(pdfFile, DEST + RESULT_FILES, chain, pk, "SHA-256", provider.getName(), PdfSigner.CryptoStandard.CMS, "Test with API REST 1", "Quito");
        System.out.println("The pdf file was successfully created!");
    }
}
