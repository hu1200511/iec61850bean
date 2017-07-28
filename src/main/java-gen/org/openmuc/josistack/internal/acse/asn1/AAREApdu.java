/**
 * This class file was automatically generated by jASN1 v1.8.0 (http://www.openmuc.org)
 */

package org.openmuc.josistack.internal.acse.asn1;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import org.openmuc.jasn1.ber.BerByteArrayOutputStream;
import org.openmuc.jasn1.ber.BerLength;
import org.openmuc.jasn1.ber.BerTag;
import org.openmuc.jasn1.ber.types.BerBitString;
import org.openmuc.jasn1.ber.types.BerObjectIdentifier;

public class AAREApdu implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final BerTag tag = new BerTag(BerTag.APPLICATION_CLASS, BerTag.CONSTRUCTED, 1);

    public byte[] code = null;
    private BerBitString protocolVersion = null;
    private BerObjectIdentifier applicationContextName = null;
    private AssociateResult result = null;
    private AssociateSourceDiagnostic resultSourceDiagnostic = null;
    private APTitle respondingAPTitle = null;
    private AEQualifier respondingAEQualifier = null;
    private APInvocationIdentifier respondingAPInvocationIdentifier = null;
    private AEInvocationIdentifier respondingAEInvocationIdentifier = null;
    private ACSERequirements responderAcseRequirements = null;
    private MechanismName mechanismName = null;
    private AuthenticationValue respondingAuthenticationValue = null;
    private ApplicationContextNameList applicationContextNameList = null;
    private ImplementationData implementationInformation = null;
    private AssociationInformation userInformation = null;

    public AAREApdu() {
    }

    public AAREApdu(byte[] code) {
        this.code = code;
    }

    public void setProtocolVersion(BerBitString protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public BerBitString getProtocolVersion() {
        return protocolVersion;
    }

    public void setApplicationContextName(BerObjectIdentifier applicationContextName) {
        this.applicationContextName = applicationContextName;
    }

    public BerObjectIdentifier getApplicationContextName() {
        return applicationContextName;
    }

    public void setResult(AssociateResult result) {
        this.result = result;
    }

    public AssociateResult getResult() {
        return result;
    }

    public void setResultSourceDiagnostic(AssociateSourceDiagnostic resultSourceDiagnostic) {
        this.resultSourceDiagnostic = resultSourceDiagnostic;
    }

    public AssociateSourceDiagnostic getResultSourceDiagnostic() {
        return resultSourceDiagnostic;
    }

    public void setRespondingAPTitle(APTitle respondingAPTitle) {
        this.respondingAPTitle = respondingAPTitle;
    }

    public APTitle getRespondingAPTitle() {
        return respondingAPTitle;
    }

    public void setRespondingAEQualifier(AEQualifier respondingAEQualifier) {
        this.respondingAEQualifier = respondingAEQualifier;
    }

    public AEQualifier getRespondingAEQualifier() {
        return respondingAEQualifier;
    }

    public void setRespondingAPInvocationIdentifier(APInvocationIdentifier respondingAPInvocationIdentifier) {
        this.respondingAPInvocationIdentifier = respondingAPInvocationIdentifier;
    }

    public APInvocationIdentifier getRespondingAPInvocationIdentifier() {
        return respondingAPInvocationIdentifier;
    }

    public void setRespondingAEInvocationIdentifier(AEInvocationIdentifier respondingAEInvocationIdentifier) {
        this.respondingAEInvocationIdentifier = respondingAEInvocationIdentifier;
    }

    public AEInvocationIdentifier getRespondingAEInvocationIdentifier() {
        return respondingAEInvocationIdentifier;
    }

    public void setResponderAcseRequirements(ACSERequirements responderAcseRequirements) {
        this.responderAcseRequirements = responderAcseRequirements;
    }

    public ACSERequirements getResponderAcseRequirements() {
        return responderAcseRequirements;
    }

    public void setMechanismName(MechanismName mechanismName) {
        this.mechanismName = mechanismName;
    }

    public MechanismName getMechanismName() {
        return mechanismName;
    }

    public void setRespondingAuthenticationValue(AuthenticationValue respondingAuthenticationValue) {
        this.respondingAuthenticationValue = respondingAuthenticationValue;
    }

    public AuthenticationValue getRespondingAuthenticationValue() {
        return respondingAuthenticationValue;
    }

    public void setApplicationContextNameList(ApplicationContextNameList applicationContextNameList) {
        this.applicationContextNameList = applicationContextNameList;
    }

    public ApplicationContextNameList getApplicationContextNameList() {
        return applicationContextNameList;
    }

    public void setImplementationInformation(ImplementationData implementationInformation) {
        this.implementationInformation = implementationInformation;
    }

    public ImplementationData getImplementationInformation() {
        return implementationInformation;
    }

    public void setUserInformation(AssociationInformation userInformation) {
        this.userInformation = userInformation;
    }

    public AssociationInformation getUserInformation() {
        return userInformation;
    }

    public int encode(BerByteArrayOutputStream os) throws IOException {
        return encode(os, true);
    }

    public int encode(BerByteArrayOutputStream os, boolean withTag) throws IOException {

        if (code != null) {
            for (int i = code.length - 1; i >= 0; i--) {
                os.write(code[i]);
            }
            if (withTag) {
                return tag.encode(os) + code.length;
            }
            return code.length;
        }

        int codeLength = 0;
        int sublength;

        if (userInformation != null) {
            codeLength += userInformation.encode(os, false);
            // write tag: CONTEXT_CLASS, CONSTRUCTED, 30
            os.write(0xBE);
            codeLength += 1;
        }

        if (implementationInformation != null) {
            codeLength += implementationInformation.encode(os, false);
            // write tag: CONTEXT_CLASS, PRIMITIVE, 29
            os.write(0x9D);
            codeLength += 1;
        }

        if (applicationContextNameList != null) {
            codeLength += applicationContextNameList.encode(os, false);
            // write tag: CONTEXT_CLASS, CONSTRUCTED, 11
            os.write(0xAB);
            codeLength += 1;
        }

        if (respondingAuthenticationValue != null) {
            sublength = respondingAuthenticationValue.encode(os);
            codeLength += sublength;
            codeLength += BerLength.encodeLength(os, sublength);
            // write tag: CONTEXT_CLASS, CONSTRUCTED, 10
            os.write(0xAA);
            codeLength += 1;
        }

        if (mechanismName != null) {
            codeLength += mechanismName.encode(os, false);
            // write tag: CONTEXT_CLASS, PRIMITIVE, 9
            os.write(0x89);
            codeLength += 1;
        }

        if (responderAcseRequirements != null) {
            codeLength += responderAcseRequirements.encode(os, false);
            // write tag: CONTEXT_CLASS, PRIMITIVE, 8
            os.write(0x88);
            codeLength += 1;
        }

        if (respondingAEInvocationIdentifier != null) {
            sublength = respondingAEInvocationIdentifier.encode(os, true);
            codeLength += sublength;
            codeLength += BerLength.encodeLength(os, sublength);
            // write tag: CONTEXT_CLASS, CONSTRUCTED, 7
            os.write(0xA7);
            codeLength += 1;
        }

        if (respondingAPInvocationIdentifier != null) {
            sublength = respondingAPInvocationIdentifier.encode(os, true);
            codeLength += sublength;
            codeLength += BerLength.encodeLength(os, sublength);
            // write tag: CONTEXT_CLASS, CONSTRUCTED, 6
            os.write(0xA6);
            codeLength += 1;
        }

        if (respondingAEQualifier != null) {
            sublength = respondingAEQualifier.encode(os);
            codeLength += sublength;
            codeLength += BerLength.encodeLength(os, sublength);
            // write tag: CONTEXT_CLASS, CONSTRUCTED, 5
            os.write(0xA5);
            codeLength += 1;
        }

        if (respondingAPTitle != null) {
            sublength = respondingAPTitle.encode(os);
            codeLength += sublength;
            codeLength += BerLength.encodeLength(os, sublength);
            // write tag: CONTEXT_CLASS, CONSTRUCTED, 4
            os.write(0xA4);
            codeLength += 1;
        }

        sublength = resultSourceDiagnostic.encode(os);
        codeLength += sublength;
        codeLength += BerLength.encodeLength(os, sublength);
        // write tag: CONTEXT_CLASS, CONSTRUCTED, 3
        os.write(0xA3);
        codeLength += 1;

        sublength = result.encode(os, true);
        codeLength += sublength;
        codeLength += BerLength.encodeLength(os, sublength);
        // write tag: CONTEXT_CLASS, CONSTRUCTED, 2
        os.write(0xA2);
        codeLength += 1;

        sublength = applicationContextName.encode(os, true);
        codeLength += sublength;
        codeLength += BerLength.encodeLength(os, sublength);
        // write tag: CONTEXT_CLASS, CONSTRUCTED, 1
        os.write(0xA1);
        codeLength += 1;

        if (protocolVersion != null) {
            codeLength += protocolVersion.encode(os, false);
            // write tag: CONTEXT_CLASS, PRIMITIVE, 0
            os.write(0x80);
            codeLength += 1;
        }

        codeLength += BerLength.encodeLength(os, codeLength);

        if (withTag) {
            codeLength += tag.encode(os);
        }

        return codeLength;

    }

    public int decode(InputStream is) throws IOException {
        return decode(is, true);
    }

    public int decode(InputStream is, boolean withTag) throws IOException {
        int codeLength = 0;
        int subCodeLength = 0;
        BerTag berTag = new BerTag();

        if (withTag) {
            codeLength += tag.decodeAndCheck(is);
        }

        BerLength length = new BerLength();
        codeLength += length.decode(is);

        int totalLength = length.val;
        codeLength += totalLength;

        subCodeLength += berTag.decode(is);
        if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 0)) {
            protocolVersion = new BerBitString();
            subCodeLength += protocolVersion.decode(is, false);
            subCodeLength += berTag.decode(is);
        }

        if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 1)) {
            subCodeLength += length.decode(is);
            applicationContextName = new BerObjectIdentifier();
            subCodeLength += applicationContextName.decode(is, true);
            subCodeLength += berTag.decode(is);
        }
        else {
            throw new IOException("Tag does not match the mandatory sequence element tag.");
        }

        if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 2)) {
            subCodeLength += length.decode(is);
            result = new AssociateResult();
            subCodeLength += result.decode(is, true);
            subCodeLength += berTag.decode(is);
        }
        else {
            throw new IOException("Tag does not match the mandatory sequence element tag.");
        }

        if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 3)) {
            subCodeLength += length.decode(is);
            resultSourceDiagnostic = new AssociateSourceDiagnostic();
            subCodeLength += resultSourceDiagnostic.decode(is, null);
            if (subCodeLength == totalLength) {
                return codeLength;
            }
            subCodeLength += berTag.decode(is);
        }
        else {
            throw new IOException("Tag does not match the mandatory sequence element tag.");
        }

        if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 4)) {
            subCodeLength += length.decode(is);
            respondingAPTitle = new APTitle();
            subCodeLength += respondingAPTitle.decode(is, null);
            if (subCodeLength == totalLength) {
                return codeLength;
            }
            subCodeLength += berTag.decode(is);
        }

        if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 5)) {
            subCodeLength += length.decode(is);
            respondingAEQualifier = new AEQualifier();
            subCodeLength += respondingAEQualifier.decode(is, null);
            if (subCodeLength == totalLength) {
                return codeLength;
            }
            subCodeLength += berTag.decode(is);
        }

        if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 6)) {
            subCodeLength += length.decode(is);
            respondingAPInvocationIdentifier = new APInvocationIdentifier();
            subCodeLength += respondingAPInvocationIdentifier.decode(is, true);
            if (subCodeLength == totalLength) {
                return codeLength;
            }
            subCodeLength += berTag.decode(is);
        }

        if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 7)) {
            subCodeLength += length.decode(is);
            respondingAEInvocationIdentifier = new AEInvocationIdentifier();
            subCodeLength += respondingAEInvocationIdentifier.decode(is, true);
            if (subCodeLength == totalLength) {
                return codeLength;
            }
            subCodeLength += berTag.decode(is);
        }

        if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 8)) {
            responderAcseRequirements = new ACSERequirements();
            subCodeLength += responderAcseRequirements.decode(is, false);
            if (subCodeLength == totalLength) {
                return codeLength;
            }
            subCodeLength += berTag.decode(is);
        }

        if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 9)) {
            mechanismName = new MechanismName();
            subCodeLength += mechanismName.decode(is, false);
            if (subCodeLength == totalLength) {
                return codeLength;
            }
            subCodeLength += berTag.decode(is);
        }

        if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 10)) {
            subCodeLength += length.decode(is);
            respondingAuthenticationValue = new AuthenticationValue();
            subCodeLength += respondingAuthenticationValue.decode(is, null);
            if (subCodeLength == totalLength) {
                return codeLength;
            }
            subCodeLength += berTag.decode(is);
        }

        if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 11)) {
            applicationContextNameList = new ApplicationContextNameList();
            subCodeLength += applicationContextNameList.decode(is, false);
            if (subCodeLength == totalLength) {
                return codeLength;
            }
            subCodeLength += berTag.decode(is);
        }

        if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 29)) {
            implementationInformation = new ImplementationData();
            subCodeLength += implementationInformation.decode(is, false);
            if (subCodeLength == totalLength) {
                return codeLength;
            }
            subCodeLength += berTag.decode(is);
        }

        if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 30)) {
            userInformation = new AssociationInformation();
            subCodeLength += userInformation.decode(is, false);
            if (subCodeLength == totalLength) {
                return codeLength;
            }
        }
        throw new IOException("Unexpected end of sequence, length tag: " + totalLength + ", actual sequence length: "
                + subCodeLength);

    }

    public void encodeAndSave(int encodingSizeGuess) throws IOException {
        BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
        encode(os, false);
        code = os.getArray();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        appendAsString(sb, 0);
        return sb.toString();
    }

    public void appendAsString(StringBuilder sb, int indentLevel) {

        sb.append("{");
        boolean firstSelectedElement = true;
        if (protocolVersion != null) {
            sb.append("\n");
            for (int i = 0; i < indentLevel + 1; i++) {
                sb.append("\t");
            }
            sb.append("protocolVersion: ").append(protocolVersion);
            firstSelectedElement = false;
        }

        if (!firstSelectedElement) {
            sb.append(",\n");
        }
        for (int i = 0; i < indentLevel + 1; i++) {
            sb.append("\t");
        }
        if (applicationContextName != null) {
            sb.append("applicationContextName: ").append(applicationContextName);
        }
        else {
            sb.append("applicationContextName: <empty-required-field>");
        }

        sb.append(",\n");
        for (int i = 0; i < indentLevel + 1; i++) {
            sb.append("\t");
        }
        if (result != null) {
            sb.append("result: ").append(result);
        }
        else {
            sb.append("result: <empty-required-field>");
        }

        sb.append(",\n");
        for (int i = 0; i < indentLevel + 1; i++) {
            sb.append("\t");
        }
        if (resultSourceDiagnostic != null) {
            sb.append("resultSourceDiagnostic: ");
            resultSourceDiagnostic.appendAsString(sb, indentLevel + 1);
        }
        else {
            sb.append("resultSourceDiagnostic: <empty-required-field>");
        }

        if (respondingAPTitle != null) {
            sb.append(",\n");
            for (int i = 0; i < indentLevel + 1; i++) {
                sb.append("\t");
            }
            sb.append("respondingAPTitle: ");
            respondingAPTitle.appendAsString(sb, indentLevel + 1);
        }

        if (respondingAEQualifier != null) {
            sb.append(",\n");
            for (int i = 0; i < indentLevel + 1; i++) {
                sb.append("\t");
            }
            sb.append("respondingAEQualifier: ");
            respondingAEQualifier.appendAsString(sb, indentLevel + 1);
        }

        if (respondingAPInvocationIdentifier != null) {
            sb.append(",\n");
            for (int i = 0; i < indentLevel + 1; i++) {
                sb.append("\t");
            }
            sb.append("respondingAPInvocationIdentifier: ").append(respondingAPInvocationIdentifier);
        }

        if (respondingAEInvocationIdentifier != null) {
            sb.append(",\n");
            for (int i = 0; i < indentLevel + 1; i++) {
                sb.append("\t");
            }
            sb.append("respondingAEInvocationIdentifier: ").append(respondingAEInvocationIdentifier);
        }

        if (responderAcseRequirements != null) {
            sb.append(",\n");
            for (int i = 0; i < indentLevel + 1; i++) {
                sb.append("\t");
            }
            sb.append("responderAcseRequirements: ").append(responderAcseRequirements);
        }

        if (mechanismName != null) {
            sb.append(",\n");
            for (int i = 0; i < indentLevel + 1; i++) {
                sb.append("\t");
            }
            sb.append("mechanismName: ").append(mechanismName);
        }

        if (respondingAuthenticationValue != null) {
            sb.append(",\n");
            for (int i = 0; i < indentLevel + 1; i++) {
                sb.append("\t");
            }
            sb.append("respondingAuthenticationValue: ");
            respondingAuthenticationValue.appendAsString(sb, indentLevel + 1);
        }

        if (applicationContextNameList != null) {
            sb.append(",\n");
            for (int i = 0; i < indentLevel + 1; i++) {
                sb.append("\t");
            }
            sb.append("applicationContextNameList: ");
            applicationContextNameList.appendAsString(sb, indentLevel + 1);
        }

        if (implementationInformation != null) {
            sb.append(",\n");
            for (int i = 0; i < indentLevel + 1; i++) {
                sb.append("\t");
            }
            sb.append("implementationInformation: ").append(implementationInformation);
        }

        if (userInformation != null) {
            sb.append(",\n");
            for (int i = 0; i < indentLevel + 1; i++) {
                sb.append("\t");
            }
            sb.append("userInformation: ");
            userInformation.appendAsString(sb, indentLevel + 1);
        }

        sb.append("\n");
        for (int i = 0; i < indentLevel; i++) {
            sb.append("\t");
        }
        sb.append("}");
    }

}
