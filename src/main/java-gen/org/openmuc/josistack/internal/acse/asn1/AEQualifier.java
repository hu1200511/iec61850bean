/**
 * This class file was automatically generated by jASN1 v1.8.0 (http://www.openmuc.org)
 */

package org.openmuc.josistack.internal.acse.asn1;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import org.openmuc.jasn1.ber.BerByteArrayOutputStream;
import org.openmuc.jasn1.ber.BerTag;
import org.openmuc.jasn1.ber.types.BerInteger;

public class AEQualifier implements Serializable {

    private static final long serialVersionUID = 1L;

    public byte[] code = null;
    private AEQualifierForm2 aeQualifierForm2 = null;

    public AEQualifier() {
    }

    public AEQualifier(byte[] code) {
        this.code = code;
    }

    public void setAeQualifierForm2(AEQualifierForm2 aeQualifierForm2) {
        this.aeQualifierForm2 = aeQualifierForm2;
    }

    public AEQualifierForm2 getAeQualifierForm2() {
        return aeQualifierForm2;
    }

    public int encode(BerByteArrayOutputStream os) throws IOException {

        if (code != null) {
            for (int i = code.length - 1; i >= 0; i--) {
                os.write(code[i]);
            }
            return code.length;
        }

        int codeLength = 0;
        if (aeQualifierForm2 != null) {
            codeLength += aeQualifierForm2.encode(os, true);
            return codeLength;
        }

        throw new IOException("Error encoding CHOICE: No element of CHOICE was selected.");
    }

    public int decode(InputStream is) throws IOException {
        return decode(is, null);
    }

    public int decode(InputStream is, BerTag berTag) throws IOException {

        int codeLength = 0;
        BerTag passedTag = berTag;

        if (berTag == null) {
            berTag = new BerTag();
            codeLength += berTag.decode(is);
        }

        if (berTag.equals(BerInteger.tag)) {
            aeQualifierForm2 = new AEQualifierForm2();
            codeLength += aeQualifierForm2.decode(is, false);
            return codeLength;
        }

        if (passedTag != null) {
            return 0;
        }

        throw new IOException("Error decoding CHOICE: Tag " + berTag + " matched to no item.");
    }

    public void encodeAndSave(int encodingSizeGuess) throws IOException {
        BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
        encode(os);
        code = os.getArray();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        appendAsString(sb, 0);
        return sb.toString();
    }

    public void appendAsString(StringBuilder sb, int indentLevel) {

        if (aeQualifierForm2 != null) {
            sb.append("aeQualifierForm2: ").append(aeQualifierForm2);
            return;
        }

        sb.append("<none>");
    }

}
