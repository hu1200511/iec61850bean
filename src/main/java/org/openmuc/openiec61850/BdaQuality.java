/*
 * Copyright 2011-17 Fraunhofer ISE, energy & meteo Systems GmbH and other contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.openmuc.openiec61850;

import java.util.ArrayList;

public final class BdaQuality extends BdaBitString {

    public enum Validity {
        GOOD(0),
        INVALID(1),
        RESERVED(2),
        QUESTIONABLE(3);
        private final int value;

        private Validity(int value) {
            this.value = value;
        }

        public int getIntValue() {
            return value;
        }
    }

    public BdaQuality(ObjectReference objectReference, Fc fc, String sAddr, boolean qchg) {
        super(objectReference, fc, sAddr, 13, false, false);
        this.qchg = qchg;
        basicType = BdaType.QUALITY;
        if (qchg) {
            chgRcbs = new ArrayList<>();
        }
        setDefault();
    }

    @Override
    public void setDefault() {
        value = new byte[] { 0x00, 0x00 };
    }

    @Override
    public BdaQuality copy() {
        BdaQuality copy = new BdaQuality(objectReference, fc, sAddr, qchg);
        byte[] valueCopy = new byte[value.length];
        System.arraycopy(value, 0, valueCopy, 0, value.length);
        copy.setValue(valueCopy);
        if (mirror == null) {
            copy.mirror = this;
        }
        else {
            copy.mirror = mirror;
        }
        return copy;
    }

    public Validity getValidity() {
        if ((value[0] & 0xC0) == 0xC0) {
            return Validity.QUESTIONABLE;
        }

        if ((value[0] & 0x80) == 0x80) {
            return Validity.RESERVED;
        }

        if ((value[0] & 0x40) == 0x40) {
            return Validity.INVALID;
        }

        return Validity.GOOD;
    }

    public boolean isOverflow() {
        return (value[0] & 0x20) == 0x20;
    }

    public boolean isOutOfRange() {
        return (value[0] & 0x10) == 0x10;
    }

    public boolean isBadReference() {
        return (value[0] & 0x08) == 0x08;
    }

    public boolean isOscillatory() {
        return (value[0] & 0x04) == 0x04;
    }

    public boolean isFailure() {
        return (value[0] & 0x02) == 0x02;
    }

    public boolean isOldData() {
        return (value[0] & 0x01) == 0x01;
    }

    public boolean isInconsistent() {
        return (value[1] & 0x80) == 0x80;
    }

    public boolean isInaccurate() {
        return (value[1] & 0x40) == 0x40;
    }

    public boolean isSubstituted() {
        return (value[1] & 0x20) == 0x20;
    }

    public boolean isTest() {
        return (value[1] & 0x10) == 0x10;
    }

    public boolean isOperatorBlocked() {
        return (value[1] & 0x08) == 0x08;
    }

    public void setValidity(Validity validity) {
        if (validity == Validity.QUESTIONABLE) {
            value[0] = (byte) (value[0] | 0xC0);
        }
        else if (validity == Validity.RESERVED) {
            value[0] = (byte) (value[0] | 0x80);
            value[0] = (byte) (value[0] & 0xbf);
        }
        else if (validity == Validity.INVALID) {
            value[0] = (byte) (value[0] & 0x7f);
            value[0] = (byte) (value[0] | 0x40);
        }
        else {
            value[0] = (byte) (value[0] & 0x03);
        }
    }

    public void setOverflow(boolean overflow) {
        if (overflow) {
            value[0] = (byte) (value[0] | 0x20);
        }
        else {
            value[0] = (byte) (value[0] & 0xdf);
        }
    }

    public void setOutOfRange(boolean outOfRange) {
        if (outOfRange) {
            value[0] = (byte) (value[0] | 0x10);
        }
        else {
            value[0] = (byte) (value[0] & 0xef);
        }
    }

    public void setBadReference(boolean badReference) {
        if (badReference) {
            value[0] = (byte) (value[0] | 0x08);
        }
        else {
            value[0] = (byte) (value[0] & 0xf7);
        }
    }

    public void setOscillatory(boolean oscillatory) {
        if (oscillatory) {
            value[0] = (byte) (value[0] | 0x04);
        }
        else {
            value[0] = (byte) (value[0] & 0xfb);
        }
    }

    public void setFailure(boolean failure) {
        if (failure) {
            value[0] = (byte) (value[0] | 0x02);
        }
        else {
            value[0] = (byte) (value[0] & 0xfd);
        }
    }

    public void setOldData(boolean oldData) {
        if (oldData) {
            value[0] = (byte) (value[0] | 0x01);
        }
        else {
            value[0] = (byte) (value[0] & 0xfe);
        }
    }

    public void setInconsistent(boolean inconsistent) {
        if (inconsistent) {
            value[1] = (byte) (value[0] | 0x80);
        }
        else {
            value[1] = (byte) (value[0] & 0x7f);
        }
    }

    public void setInaccurate(boolean inaccurate) {
        if (inaccurate) {
            value[1] = (byte) (value[0] | 0x40);
        }
        else {
            value[1] = (byte) (value[0] & 0xbf);
        }
    }

    public void setSubstituted(boolean substituted) {
        if (substituted) {
            value[1] = (byte) (value[0] | 0x20);
        }
        else {
            value[1] = (byte) (value[0] & 0xdf);
        }
    }

    public void setTest(boolean test) {
        if (test) {
            value[1] = (byte) (value[0] | 0x10);
        }
        else {
            value[1] = (byte) (value[0] & 0xef);
        }
    }

    public void setOperatorBlocked(boolean operatorBlocked) {
        if (operatorBlocked) {
            value[1] = (byte) (value[0] | 0x08);
        }
        else {
            value[1] = (byte) (value[0] & 0xf7);
        }
    }

    @Override
    public String toString() {
        return getReference().toString() + ": " + String.format("0x%x, 0x%x", value[0], value[1]);
    }

}
