/*
 * Copyright 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.media.tv.tuner.frontend;

import android.annotation.IntDef;
import android.annotation.IntRange;
import android.annotation.NonNull;
import android.annotation.SystemApi;
import android.hardware.tv.tuner.V1_0.Constants;
import android.media.tv.tuner.Lnb;
import android.media.tv.tuner.TunerVersionChecker;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Frontend status.
 *
 * @hide
 */
@SystemApi
public class FrontendStatus {

    /** @hide */
    @IntDef({FRONTEND_STATUS_TYPE_DEMOD_LOCK, FRONTEND_STATUS_TYPE_SNR, FRONTEND_STATUS_TYPE_BER,
            FRONTEND_STATUS_TYPE_PER, FRONTEND_STATUS_TYPE_PRE_BER,
            FRONTEND_STATUS_TYPE_SIGNAL_QUALITY, FRONTEND_STATUS_TYPE_SIGNAL_STRENGTH,
            FRONTEND_STATUS_TYPE_SYMBOL_RATE, FRONTEND_STATUS_TYPE_FEC,
            FRONTEND_STATUS_TYPE_MODULATION, FRONTEND_STATUS_TYPE_SPECTRAL,
            FRONTEND_STATUS_TYPE_LNB_VOLTAGE, FRONTEND_STATUS_TYPE_PLP_ID,
            FRONTEND_STATUS_TYPE_EWBS, FRONTEND_STATUS_TYPE_AGC, FRONTEND_STATUS_TYPE_LNA,
            FRONTEND_STATUS_TYPE_LAYER_ERROR, FRONTEND_STATUS_TYPE_MER,
            FRONTEND_STATUS_TYPE_FREQ_OFFSET, FRONTEND_STATUS_TYPE_HIERARCHY,
            FRONTEND_STATUS_TYPE_RF_LOCK, FRONTEND_STATUS_TYPE_ATSC3_PLP_INFO,
            FRONTEND_STATUS_TYPE_BERS, FRONTEND_STATUS_TYPE_CODERATES,
            FRONTEND_STATUS_TYPE_BANDWIDTH, FRONTEND_STATUS_TYPE_GUARD_INTERVAL,
            FRONTEND_STATUS_TYPE_TRANSMISSION_MODE, FRONTEND_STATUS_TYPE_UEC,
            FRONTEND_STATUS_TYPE_T2_SYSTEM_ID, FRONTEND_STATUS_TYPE_INTERLEAVINGS,
            FRONTEND_STATUS_TYPE_ISDBT_SEGMENTS, FRONTEND_STATUS_TYPE_TS_DATA_RATES,
            FRONTEND_STATUS_TYPE_MODULATIONS_EXT})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FrontendStatusType {}

    /**
     * Lock status for Demod.
     */
    public static final int FRONTEND_STATUS_TYPE_DEMOD_LOCK =
            Constants.FrontendStatusType.DEMOD_LOCK;
    /**
     * Signal to Noise Ratio.
     */
    public static final int FRONTEND_STATUS_TYPE_SNR = Constants.FrontendStatusType.SNR;
    /**
     * Bit Error Ratio.
     */
    public static final int FRONTEND_STATUS_TYPE_BER = Constants.FrontendStatusType.BER;
    /**
     * Packages Error Ratio.
     */
    public static final int FRONTEND_STATUS_TYPE_PER = Constants.FrontendStatusType.PER;
    /**
     * Bit Error Ratio before FEC.
     */
    public static final int FRONTEND_STATUS_TYPE_PRE_BER = Constants.FrontendStatusType.PRE_BER;
    /**
     * Signal Quality (0..100). Good data over total data in percent can be
     * used as a way to present Signal Quality.
     */
    public static final int FRONTEND_STATUS_TYPE_SIGNAL_QUALITY =
            Constants.FrontendStatusType.SIGNAL_QUALITY;
    /**
     * Signal Strength.
     */
    public static final int FRONTEND_STATUS_TYPE_SIGNAL_STRENGTH =
            Constants.FrontendStatusType.SIGNAL_STRENGTH;
    /**
     * Symbol Rate in symbols per second.
     */
    public static final int FRONTEND_STATUS_TYPE_SYMBOL_RATE =
            Constants.FrontendStatusType.SYMBOL_RATE;
    /**
     * Forward Error Correction Type.
     */
    public static final int FRONTEND_STATUS_TYPE_FEC = Constants.FrontendStatusType.FEC;
    /**
     * Modulation Type.
     */
    public static final int FRONTEND_STATUS_TYPE_MODULATION =
            Constants.FrontendStatusType.MODULATION;
    /**
     * Spectral Inversion Type.
     */
    public static final int FRONTEND_STATUS_TYPE_SPECTRAL = Constants.FrontendStatusType.SPECTRAL;
    /**
     * LNB Voltage.
     */
    public static final int FRONTEND_STATUS_TYPE_LNB_VOLTAGE =
            Constants.FrontendStatusType.LNB_VOLTAGE;
    /**
     * Physical Layer Pipe ID.
     */
    public static final int FRONTEND_STATUS_TYPE_PLP_ID = Constants.FrontendStatusType.PLP_ID;
    /**
     * Status for Emergency Warning Broadcasting System.
     */
    public static final int FRONTEND_STATUS_TYPE_EWBS = Constants.FrontendStatusType.EWBS;
    /**
     * Automatic Gain Control.
     */
    public static final int FRONTEND_STATUS_TYPE_AGC = Constants.FrontendStatusType.AGC;
    /**
     * Low Noise Amplifier.
     */
    public static final int FRONTEND_STATUS_TYPE_LNA = Constants.FrontendStatusType.LNA;
    /**
     * Error status by layer.
     */
    public static final int FRONTEND_STATUS_TYPE_LAYER_ERROR =
            Constants.FrontendStatusType.LAYER_ERROR;
    /**
     * Modulation Error Ratio.
     */
    public static final int FRONTEND_STATUS_TYPE_MER = Constants.FrontendStatusType.MER;
    /**
     * Difference between tuning frequency and actual locked frequency.
     */
    public static final int FRONTEND_STATUS_TYPE_FREQ_OFFSET =
            Constants.FrontendStatusType.FREQ_OFFSET;
    /**
     * Hierarchy for DVBT.
     */
    public static final int FRONTEND_STATUS_TYPE_HIERARCHY = Constants.FrontendStatusType.HIERARCHY;
    /**
     * Lock status for RF.
     */
    public static final int FRONTEND_STATUS_TYPE_RF_LOCK = Constants.FrontendStatusType.RF_LOCK;
    /**
     * PLP information in a frequency band for ATSC-3.0 frontend.
     */
    public static final int FRONTEND_STATUS_TYPE_ATSC3_PLP_INFO =
            Constants.FrontendStatusType.ATSC3_PLP_INFO;
    /**
     * BERS Type. Only supported in Tuner HAL 1.1 or higher.
     */
    public static final int FRONTEND_STATUS_TYPE_BERS =
            android.hardware.tv.tuner.V1_1.Constants.FrontendStatusTypeExt1_1.BERS;
    /**
     * Coderate Type. Only supported in Tuner HAL 1.1 or higher.
     */
    public static final int FRONTEND_STATUS_TYPE_CODERATES =
            android.hardware.tv.tuner.V1_1.Constants.FrontendStatusTypeExt1_1.CODERATES;
    /**
     * Bandwidth Type. Only supported in Tuner HAL 1.1 or higher.
     */
    public static final int FRONTEND_STATUS_TYPE_BANDWIDTH =
            android.hardware.tv.tuner.V1_1.Constants.FrontendStatusTypeExt1_1.BANDWIDTH;
    /**
     * Guard Interval Type. Only supported in Tuner HAL 1.1 or higher.
     */
    public static final int FRONTEND_STATUS_TYPE_GUARD_INTERVAL =
            android.hardware.tv.tuner.V1_1.Constants.FrontendStatusTypeExt1_1.GUARD_INTERVAL;
    /**
     * Transmission Mode Type. Only supported in Tuner HAL 1.1 or higher.
     */
    public static final int FRONTEND_STATUS_TYPE_TRANSMISSION_MODE =
            android.hardware.tv.tuner.V1_1.Constants.FrontendStatusTypeExt1_1.TRANSMISSION_MODE;
    /**
     * UEC Type. Only supported in Tuner HAL 1.1 or higher.
     */
    public static final int FRONTEND_STATUS_TYPE_UEC =
            android.hardware.tv.tuner.V1_1.Constants.FrontendStatusTypeExt1_1.UEC;
    /**
     * T2 System Id Type. Only supported in Tuner HAL 1.1 or higher.
     */
    public static final int FRONTEND_STATUS_TYPE_T2_SYSTEM_ID =
            android.hardware.tv.tuner.V1_1.Constants.FrontendStatusTypeExt1_1.T2_SYSTEM_ID;
    /**
     * Interleavings Type. Only supported in Tuner HAL 1.1 or higher.
     */
    public static final int FRONTEND_STATUS_TYPE_INTERLEAVINGS =
            android.hardware.tv.tuner.V1_1.Constants.FrontendStatusTypeExt1_1.INTERLEAVINGS;
    /**
     * ISDBT Segments Type. Only supported in Tuner HAL 1.1 or higher.
     */
    public static final int FRONTEND_STATUS_TYPE_ISDBT_SEGMENTS =
            android.hardware.tv.tuner.V1_1.Constants.FrontendStatusTypeExt1_1.ISDBT_SEGMENTS;
    /**
     * TS Data Rates Type. Only supported in Tuner HAL 1.1 or higher.
     */
    public static final int FRONTEND_STATUS_TYPE_TS_DATA_RATES =
            android.hardware.tv.tuner.V1_1.Constants.FrontendStatusTypeExt1_1.TS_DATA_RATES;
    /**
     * Extended Modulations Type. Only supported in Tuner HAL 1.1 or higher.
     */
    public static final int FRONTEND_STATUS_TYPE_MODULATIONS_EXT =
            android.hardware.tv.tuner.V1_1.Constants.FrontendStatusTypeExt1_1.MODULATIONS;

    /** @hide */
    @IntDef(value = {
            AtscFrontendSettings.MODULATION_UNDEFINED,
            AtscFrontendSettings.MODULATION_AUTO,
            AtscFrontendSettings.MODULATION_MOD_8VSB,
            AtscFrontendSettings.MODULATION_MOD_16VSB,
            Atsc3FrontendSettings.MODULATION_UNDEFINED,
            Atsc3FrontendSettings.MODULATION_AUTO,
            Atsc3FrontendSettings.MODULATION_MOD_QPSK,
            Atsc3FrontendSettings.MODULATION_MOD_16QAM,
            Atsc3FrontendSettings.MODULATION_MOD_64QAM,
            Atsc3FrontendSettings.MODULATION_MOD_256QAM,
            Atsc3FrontendSettings.MODULATION_MOD_1024QAM,
            Atsc3FrontendSettings.MODULATION_MOD_4096QAM,
            DtmbFrontendSettings.MODULATION_CONSTELLATION_UNDEFINED,
            DtmbFrontendSettings.MODULATION_CONSTELLATION_AUTO,
            DtmbFrontendSettings.MODULATION_CONSTELLATION_4QAM,
            DtmbFrontendSettings.MODULATION_CONSTELLATION_4QAM_NR,
            DtmbFrontendSettings.MODULATION_CONSTELLATION_16QAM,
            DtmbFrontendSettings.MODULATION_CONSTELLATION_32QAM,
            DtmbFrontendSettings.MODULATION_CONSTELLATION_64QAM,
            DvbcFrontendSettings.MODULATION_UNDEFINED,
            DvbcFrontendSettings.MODULATION_AUTO,
            DvbcFrontendSettings.MODULATION_MOD_16QAM,
            DvbcFrontendSettings.MODULATION_MOD_32QAM,
            DvbcFrontendSettings.MODULATION_MOD_64QAM,
            DvbcFrontendSettings.MODULATION_MOD_128QAM,
            DvbcFrontendSettings.MODULATION_MOD_256QAM,
            DvbsFrontendSettings.MODULATION_UNDEFINED,
            DvbsFrontendSettings.MODULATION_AUTO,
            DvbsFrontendSettings.MODULATION_MOD_QPSK,
            DvbsFrontendSettings.MODULATION_MOD_8PSK,
            DvbsFrontendSettings.MODULATION_MOD_16QAM,
            DvbsFrontendSettings.MODULATION_MOD_16PSK,
            DvbsFrontendSettings.MODULATION_MOD_32PSK,
            DvbsFrontendSettings.MODULATION_MOD_ACM,
            DvbsFrontendSettings.MODULATION_MOD_8APSK,
            DvbsFrontendSettings.MODULATION_MOD_16APSK,
            DvbsFrontendSettings.MODULATION_MOD_32APSK,
            DvbsFrontendSettings.MODULATION_MOD_64APSK,
            DvbsFrontendSettings.MODULATION_MOD_128APSK,
            DvbsFrontendSettings.MODULATION_MOD_256APSK,
            DvbsFrontendSettings.MODULATION_MOD_RESERVED,
            DvbtFrontendSettings.CONSTELLATION_UNDEFINED,
            DvbtFrontendSettings.CONSTELLATION_AUTO,
            DvbtFrontendSettings.CONSTELLATION_QPSK,
            DvbtFrontendSettings.CONSTELLATION_16QAM,
            DvbtFrontendSettings.CONSTELLATION_64QAM,
            DvbtFrontendSettings.CONSTELLATION_256QAM,
            DvbtFrontendSettings.CONSTELLATION_QPSK_R,
            DvbtFrontendSettings.CONSTELLATION_16QAM_R,
            DvbtFrontendSettings.CONSTELLATION_64QAM_R,
            DvbtFrontendSettings.CONSTELLATION_256QAM_R,
            IsdbsFrontendSettings.MODULATION_UNDEFINED,
            IsdbsFrontendSettings.MODULATION_AUTO,
            IsdbsFrontendSettings.MODULATION_MOD_BPSK,
            IsdbsFrontendSettings.MODULATION_MOD_QPSK,
            IsdbsFrontendSettings.MODULATION_MOD_TC8PSK,
            Isdbs3FrontendSettings.MODULATION_UNDEFINED,
            Isdbs3FrontendSettings.MODULATION_AUTO,
            Isdbs3FrontendSettings.MODULATION_MOD_BPSK,
            Isdbs3FrontendSettings.MODULATION_MOD_QPSK,
            Isdbs3FrontendSettings.MODULATION_MOD_8PSK,
            Isdbs3FrontendSettings.MODULATION_MOD_16APSK,
            Isdbs3FrontendSettings.MODULATION_MOD_32APSK,
            IsdbtFrontendSettings.MODULATION_UNDEFINED,
            IsdbtFrontendSettings.MODULATION_AUTO,
            IsdbtFrontendSettings.MODULATION_MOD_DQPSK,
            IsdbtFrontendSettings.MODULATION_MOD_QPSK,
            IsdbtFrontendSettings.MODULATION_MOD_16QAM,
            IsdbtFrontendSettings.MODULATION_MOD_64QAM})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FrontendModulation {}

    /** @hide */
    @IntDef(value = {
            Atsc3FrontendSettings.TIME_INTERLEAVE_MODE_UNDEFINED,
            Atsc3FrontendSettings.TIME_INTERLEAVE_MODE_AUTO,
            Atsc3FrontendSettings.TIME_INTERLEAVE_MODE_CTI,
            Atsc3FrontendSettings.TIME_INTERLEAVE_MODE_HTI,
            DtmbFrontendSettings.TIME_INTERLEAVE_MODE_UNDEFINED,
            DtmbFrontendSettings.TIME_INTERLEAVE_MODE_AUTO,
            DtmbFrontendSettings.TIME_INTERLEAVE_MODE_TIMER_INT_240,
            DtmbFrontendSettings.TIME_INTERLEAVE_MODE_TIMER_INT_720,
            DvbcFrontendSettings.TIME_INTERLEAVE_MODE_UNDEFINED,
            DvbcFrontendSettings.TIME_INTERLEAVE_MODE_AUTO,
            DvbcFrontendSettings.TIME_INTERLEAVE_MODE_128_1_0,
            DvbcFrontendSettings.TIME_INTERLEAVE_MODE_128_1_1,
            DvbcFrontendSettings.TIME_INTERLEAVE_MODE_64_2,
            DvbcFrontendSettings.TIME_INTERLEAVE_MODE_32_4,
            DvbcFrontendSettings.TIME_INTERLEAVE_MODE_16_8,
            DvbcFrontendSettings.TIME_INTERLEAVE_MODE_8_16,
            DvbcFrontendSettings.TIME_INTERLEAVE_MODE_128_2,
            DvbcFrontendSettings.TIME_INTERLEAVE_MODE_128_3,
            DvbcFrontendSettings.TIME_INTERLEAVE_MODE_128_4})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FrontendInterleaveMode {}

    /** @hide */
    @IntDef(value = {
            Atsc3FrontendSettings.BANDWIDTH_UNDEFINED,
            Atsc3FrontendSettings.BANDWIDTH_AUTO,
            Atsc3FrontendSettings.BANDWIDTH_BANDWIDTH_6MHZ,
            Atsc3FrontendSettings.BANDWIDTH_BANDWIDTH_7MHZ,
            Atsc3FrontendSettings.BANDWIDTH_BANDWIDTH_8MHZ,
            DtmbFrontendSettings.BANDWIDTH_UNDEFINED,
            DtmbFrontendSettings.BANDWIDTH_AUTO,
            DtmbFrontendSettings.BANDWIDTH_6MHZ,
            DtmbFrontendSettings.BANDWIDTH_8MHZ,
            DvbtFrontendSettings.BANDWIDTH_UNDEFINED,
            DvbtFrontendSettings.BANDWIDTH_AUTO,
            DvbtFrontendSettings.BANDWIDTH_8MHZ,
            DvbtFrontendSettings.BANDWIDTH_7MHZ,
            DvbtFrontendSettings.BANDWIDTH_6MHZ,
            DvbtFrontendSettings.BANDWIDTH_5MHZ,
            DvbtFrontendSettings.BANDWIDTH_1_7MHZ,
            DvbtFrontendSettings.BANDWIDTH_10MHZ,
            IsdbtFrontendSettings.BANDWIDTH_UNDEFINED,
            IsdbtFrontendSettings.BANDWIDTH_AUTO,
            IsdbtFrontendSettings.BANDWIDTH_8MHZ,
            IsdbtFrontendSettings.BANDWIDTH_7MHZ,
            IsdbtFrontendSettings.BANDWIDTH_6MHZ})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FrontendBandwidth {}

    /** @hide */
    @IntDef(value = {
            DtmbFrontendSettings.TRANSMISSION_MODE_UNDEFINED,
            DtmbFrontendSettings.TRANSMISSION_MODE_AUTO,
            DtmbFrontendSettings.TRANSMISSION_MODE_C1,
            DtmbFrontendSettings.TRANSMISSION_MODE_C3780,
            DvbtFrontendSettings.TRANSMISSION_MODE_UNDEFINED,
            DvbtFrontendSettings.TRANSMISSION_MODE_AUTO,
            DvbtFrontendSettings.TRANSMISSION_MODE_2K,
            DvbtFrontendSettings.TRANSMISSION_MODE_8K,
            DvbtFrontendSettings.TRANSMISSION_MODE_4K,
            DvbtFrontendSettings.TRANSMISSION_MODE_1K,
            DvbtFrontendSettings.TRANSMISSION_MODE_16K,
            DvbtFrontendSettings.TRANSMISSION_MODE_32K,
            IsdbtFrontendSettings.MODE_UNDEFINED,
            IsdbtFrontendSettings.MODE_AUTO,
            IsdbtFrontendSettings.MODE_1,
            IsdbtFrontendSettings.MODE_2,
            IsdbtFrontendSettings.MODE_3})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FrontendTransmissionMode {}

    /** @hide */
    @IntDef(value = {
            DtmbFrontendSettings.GUARD_INTERVAL_UNDEFINED,
            DtmbFrontendSettings.GUARD_INTERVAL_AUTO,
            DtmbFrontendSettings.GUARD_INTERVAL_PN_420_VARIOUS,
            DtmbFrontendSettings.GUARD_INTERVAL_PN_595_CONST,
            DtmbFrontendSettings.GUARD_INTERVAL_PN_945_VARIOUS,
            DtmbFrontendSettings.GUARD_INTERVAL_PN_420_CONST,
            DtmbFrontendSettings.GUARD_INTERVAL_PN_945_CONST,
            DtmbFrontendSettings.GUARD_INTERVAL_PN_RESERVED,
            DvbtFrontendSettings.GUARD_INTERVAL_UNDEFINED,
            DvbtFrontendSettings.GUARD_INTERVAL_AUTO,
            DvbtFrontendSettings.GUARD_INTERVAL_1_32,
            DvbtFrontendSettings.GUARD_INTERVAL_1_16,
            DvbtFrontendSettings.GUARD_INTERVAL_1_8,
            DvbtFrontendSettings.GUARD_INTERVAL_1_4,
            DvbtFrontendSettings.GUARD_INTERVAL_1_128,
            DvbtFrontendSettings.GUARD_INTERVAL_19_128,
            DvbtFrontendSettings.GUARD_INTERVAL_19_256,
            DvbtFrontendSettings.GUARD_INTERVAL_19_128})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FrontendGuardInterval {}

    private Boolean mIsDemodLocked;
    private Integer mSnr;
    private Integer mBer;
    private Integer mPer;
    private Integer mPerBer;
    private Integer mSignalQuality;
    private Integer mSignalStrength;
    private Integer mSymbolRate;
    private Long mInnerFec;
    private Integer mModulation;
    private Integer mInversion;
    private Integer mLnbVoltage;
    private Integer mPlpId;
    private Boolean mIsEwbs;
    private Integer mAgc;
    private Boolean mIsLnaOn;
    private boolean[] mIsLayerErrors;
    private Integer mMer;
    private Integer mFreqOffset;
    private Integer mHierarchy;
    private Boolean mIsRfLocked;
    private Atsc3PlpTuningInfo[] mPlpInfo;
    private int[] mBers;
    private int[] mCodeRates;
    private Integer mBandwidth;
    private Integer mGuardInterval;
    private Integer mTransmissionMode;
    private Integer mUec;
    private Integer mSystemId;
    private int[] mInterleaving;
    private int[] mTsDataRate;
    private int[] mIsdbtSegment;
    private int[] mModulationsExt;


    // Constructed and fields set by JNI code.
    private FrontendStatus() {
    }

    /**
     * Lock status for Demod.
     */
    public boolean isDemodLocked() {
        if (mIsDemodLocked == null) {
            throw new IllegalStateException();
        }
        return mIsDemodLocked;
    }
    /**
     * Gets Signal to Noise Ratio in thousandths of a deciBel (0.001dB).
     */
    public int getSnr() {
        if (mSnr == null) {
            throw new IllegalStateException();
        }
        return mSnr;
    }
    /**
     * Gets Bit Error Ratio.
     *
     * <p>The number of error bit per 1 billion bits.
     */
    public int getBer() {
        if (mBer == null) {
            throw new IllegalStateException();
        }
        return mBer;
    }

    /**
     * Gets Packages Error Ratio.
     *
     * <p>The number of error package per 1 billion packages.
     */
    public int getPer() {
        if (mPer == null) {
            throw new IllegalStateException();
        }
        return mPer;
    }
    /**
     * Gets Bit Error Ratio before Forward Error Correction (FEC).
     *
     * <p>The number of error bit per 1 billion bits before FEC.
     */
    public int getPerBer() {
        if (mPerBer == null) {
            throw new IllegalStateException();
        }
        return mPerBer;
    }
    /**
     * Gets Signal Quality in percent.
     */
    public int getSignalQuality() {
        if (mSignalQuality == null) {
            throw new IllegalStateException();
        }
        return mSignalQuality;
    }
    /**
     * Gets Signal Strength in thousandths of a dBm (0.001dBm).
     */
    public int getSignalStrength() {
        if (mSignalStrength == null) {
            throw new IllegalStateException();
        }
        return mSignalStrength;
    }
    /**
     * Gets symbol rate in symbols per second.
     */
    public int getSymbolRate() {
        if (mSymbolRate == null) {
            throw new IllegalStateException();
        }
        return mSymbolRate;
    }
    /**
     *  Gets Inner Forward Error Correction type as specified in ETSI EN 300 468 V1.15.1
     *  and ETSI EN 302 307-2 V1.1.1.
     */
    @FrontendSettings.InnerFec
    public long getInnerFec() {
        if (mInnerFec == null) {
            throw new IllegalStateException();
        }
        return mInnerFec;
    }
    /**
     * Gets modulation.
     */
    @FrontendModulation
    public int getModulation() {
        if (mModulation == null) {
            throw new IllegalStateException();
        }
        return mModulation;
    }
    /**
     * Gets Spectral Inversion for DVBC.
     */
    @FrontendSettings.FrontendSpectralInversion
    public int getSpectralInversion() {
        if (mInversion == null) {
            throw new IllegalStateException();
        }
        return mInversion;
    }
    /**
     * Gets Power Voltage Type for LNB.
     */
    @Lnb.Voltage
    public int getLnbVoltage() {
        if (mLnbVoltage == null) {
            throw new IllegalStateException();
        }
        return mLnbVoltage;
    }
    /**
     * Gets Physical Layer Pipe ID.
     */
    public int getPlpId() {
        if (mPlpId == null) {
            throw new IllegalStateException();
        }
        return mPlpId;
    }
    /**
     * Checks whether it's Emergency Warning Broadcasting System
     */
    public boolean isEwbs() {
        if (mIsEwbs == null) {
            throw new IllegalStateException();
        }
        return mIsEwbs;
    }
    /**
     * Gets Automatic Gain Control value which is normalized from 0 to 255.
     */
    public int getAgc() {
        if (mAgc == null) {
            throw new IllegalStateException();
        }
        return mAgc;
    }
    /**
     * Checks LNA (Low Noise Amplifier) is on or not.
     */
    public boolean isLnaOn() {
        if (mIsLnaOn == null) {
            throw new IllegalStateException();
        }
        return mIsLnaOn;
    }
    /**
     * Gets Error status by layer.
     */
    @NonNull
    public boolean[] getLayerErrors() {
        if (mIsLayerErrors == null) {
            throw new IllegalStateException();
        }
        return mIsLayerErrors;
    }
    /**
     * Gets Modulation Error Ratio in thousandths of a deciBel (0.001dB).
     */
    public int getMer() {
        if (mMer == null) {
            throw new IllegalStateException();
        }
        return mMer;
    }
    /**
     * Gets frequency difference in Hz.
     *
     * <p>Difference between tuning frequency and actual locked frequency.
     */
    public int getFreqOffset() {
        if (mFreqOffset == null) {
            throw new IllegalStateException();
        }
        return mFreqOffset;
    }
    /**
     * Gets hierarchy Type for DVBT.
     */
    @DvbtFrontendSettings.Hierarchy
    public int getHierarchy() {
        if (mHierarchy == null) {
            throw new IllegalStateException();
        }
        return mHierarchy;
    }
    /**
     * Gets lock status for RF.
     */
    public boolean isRfLocked() {
        if (mIsRfLocked == null) {
            throw new IllegalStateException();
        }
        return mIsRfLocked;
    }
    /**
     * Gets an array of PLP status for tuned PLPs for ATSC3 frontend.
     */
    @NonNull
    public Atsc3PlpTuningInfo[] getAtsc3PlpTuningInfo() {
        if (mPlpInfo == null) {
            throw new IllegalStateException();
        }
        return mPlpInfo;
    }

    /**
     * Gets an array of extended bit error ratio status.
     *
     * <p>This status query is only supported by Tuner HAL 1.1 or higher. Use
     * {@link TunerVersionChecker.getTunerVersion()} to check the version.
     */
    @NonNull
    public int[] getBers() {
        TunerVersionChecker.checkHigherOrEqualVersionTo(
                TunerVersionChecker.TUNER_VERSION_1_1, "getBers status");
        if (mBers == null) {
            throw new IllegalStateException();
        }
        return mBers;
    }

    /**
     * Gets an array of code rates status. The {@link FrontendSettings.InnerFec} would be used to
     * show the code rate.
     *
     * <p>This status query is only supported by Tuner HAL 1.1 or higher. Use
     * {@link TunerVersionChecker.getTunerVersion()} to check the version.
     */
    @NonNull
    @FrontendSettings.InnerFec
    public int[] getCodeRates() {
        TunerVersionChecker.checkHigherOrEqualVersionTo(
                TunerVersionChecker.TUNER_VERSION_1_1, "getCodeRates status");
        if (mCodeRates == null) {
            throw new IllegalStateException();
        }
        return mCodeRates;
    }

    /**
     * Gets bandwidth status.
     *
     * <p>This status query is only supported by Tuner HAL 1.1 or higher. Use
     * {@link TunerVersionChecker.getTunerVersion()} to check the version.
     */
    @FrontendBandwidth
    public int getBandwidth() {
        TunerVersionChecker.checkHigherOrEqualVersionTo(
                TunerVersionChecker.TUNER_VERSION_1_1, "getBandwidth status");
        if (mBandwidth == null) {
            throw new IllegalStateException();
        }
        return mBandwidth;
    }

    /**
     * Gets guard interval status.
     *
     * <p>This status query is only supported by Tuner HAL 1.1 or higher. Use
     * {@link TunerVersionChecker.getTunerVersion()} to check the version.
     */
    @FrontendGuardInterval
    public int getGuardInterval() {
        TunerVersionChecker.checkHigherOrEqualVersionTo(
                TunerVersionChecker.TUNER_VERSION_1_1, "getGuardInterval status");
        if (mGuardInterval == null) {
            throw new IllegalStateException();
        }
        return mGuardInterval;
    }

    /**
     * Gets tansmission mode status.
     *
     * <p>This status query is only supported by Tuner HAL 1.1 or higher. Use
     * {@link TunerVersionChecker.getTunerVersion()} to check the version.
     */
    @FrontendTransmissionMode
    public int getTransmissionMode() {
        TunerVersionChecker.checkHigherOrEqualVersionTo(
                TunerVersionChecker.TUNER_VERSION_1_1, "getTransmissionMode status");
        if (mTransmissionMode == null) {
            throw new IllegalStateException();
        }
        return mTransmissionMode;
    }

    /**
     * Gets the Uncorrectable Error Counts of the frontend's Physical Layer Pipe (PLP) since the
     * last tune operation.
     *
     * <p>This status query is only supported by Tuner HAL 1.1 or higher. Use
     * {@link TunerVersionChecker.getTunerVersion()} to check the version.
     */
    public int getUec() {
        TunerVersionChecker.checkHigherOrEqualVersionTo(
                TunerVersionChecker.TUNER_VERSION_1_1, "getUec status");
        if (mUec == null) {
            throw new IllegalStateException();
        }
        return mUec;
    }

    /**
     * Gets the current DVB-T2 system id status.
     *
     * <p>This status query is only supported by Tuner HAL 1.1 or higher. Use
     * {@link TunerVersionChecker.getTunerVersion()} to check the version.
     */
    @IntRange(from = 0, to = 0xffff)
    public int getSystemId() {
        TunerVersionChecker.checkHigherOrEqualVersionTo(
                TunerVersionChecker.TUNER_VERSION_1_1, "getSystemId status");
        if (mSystemId == null) {
            throw new IllegalStateException();
        }
        return mSystemId;
    }

    /**
     * Gets an array of interleaving status. Array value should be within {@link
     * FrontendInterleaveMode}.
     *
     * <p>This status query is only supported by Tuner HAL 1.1 or higher. Use
     * {@link TunerVersionChecker.getTunerVersion()} to check the version.
     */
    @NonNull
    @FrontendInterleaveMode
    public int[] getInterleaving() {
        TunerVersionChecker.checkHigherOrEqualVersionTo(
                TunerVersionChecker.TUNER_VERSION_1_1, "getInterleaving status");
        if (mInterleaving == null) {
            throw new IllegalStateException();
        }
        return mInterleaving;
    }

    /**
     * Gets an array of the segments status in ISDB-T Specification of all the channels.
     *
     * <p>This status query is only supported by Tuner HAL 1.1 or higher. Use
     * {@link TunerVersionChecker.getTunerVersion()} to check the version.
     */
    @NonNull
    @IntRange(from = 0, to = 0xff)
    public int[] getIsdbtSegment() {
        TunerVersionChecker.checkHigherOrEqualVersionTo(
                TunerVersionChecker.TUNER_VERSION_1_1, "getIsdbtSegment status");
        if (mIsdbtSegment == null) {
            throw new IllegalStateException();
        }
        return mIsdbtSegment;
    }

    /**
     * Gets an array of the Transport Stream Data Rate in BPS of the current channel.
     *
     * <p>This status query is only supported by Tuner HAL 1.1 or higher. Use
     * {@link TunerVersionChecker.getTunerVersion()} to check the version.
     */
    @NonNull
    public int[] getTsDataRate() {
        TunerVersionChecker.checkHigherOrEqualVersionTo(
                TunerVersionChecker.TUNER_VERSION_1_1, "getTsDataRate status");
        if (mTsDataRate == null) {
            throw new IllegalStateException();
        }
        return mTsDataRate;
    }

    /**
     * Gets an array of the extended modulations status. Array value should be withink {@link
     * FrontendModulation}.
     *
     * <p>This status query is only supported by Tuner HAL 1.1 or higher. Use
     * {@link TunerVersionChecker.getTunerVersion()} to check the version.
     */
    @NonNull
    public int[] getExtendedModulations() {
        TunerVersionChecker.checkHigherOrEqualVersionTo(
                TunerVersionChecker.TUNER_VERSION_1_1, "getExtendedModulations status");
        if (mModulationsExt == null) {
            throw new IllegalStateException();
        }
        return mModulationsExt;
    }

    /**
     * Status for each tuning Physical Layer Pipes.
     */
    public static class Atsc3PlpTuningInfo {
        private final int mPlpId;
        private final boolean mIsLocked;
        private final int mUec;

        private Atsc3PlpTuningInfo(int plpId, boolean isLocked, int uec) {
            mPlpId = plpId;
            mIsLocked = isLocked;
            mUec = uec;
        }

        /**
         * Gets Physical Layer Pipe ID.
         */
        public int getPlpId() {
            return mPlpId;
        }
        /**
         * Gets Demod Lock/Unlock status of this particular PLP.
         */
        public boolean isLocked() {
            return mIsLocked;
        }
        /**
         * Gets Uncorrectable Error Counts (UEC) of this particular PLP since last tune operation.
         */
        public int getUec() {
            return mUec;
        }
    }
}
