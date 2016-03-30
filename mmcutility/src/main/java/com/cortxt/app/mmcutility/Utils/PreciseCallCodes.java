
/*
 * Copyright (C) 2014 The Android Open Source Project
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

package com.cortxt.app.mmcutility.Utils;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Contains precise call state and call fail causes generated by the
 * framework and the RIL.
 *
 * The following call information is included in returned PreciseCallState:
 *
 * <ul>
 *   <li>Ringing call state.
 *   <li>Foreground call state.
 *   <li>Background call state.
 *   <li>Disconnect cause; generated by the framework.
 *   <li>Precise disconnect cause; generated by the RIL.
 * </ul>
 *
 * @hide
 */
public class PreciseCallCodes implements Parcelable {

    /** Call state is not valid (Not received a call state). */
    public static final int PRECISE_CALL_STATE_NOT_VALID =      -1;
    /** Call state: No activity. */
    public static final int PRECISE_CALL_STATE_IDLE =           0;
    /** Call state: Active. */
    public static final int PRECISE_CALL_STATE_ACTIVE =         1;
    /** Call state: On hold. */
    public static final int PRECISE_CALL_STATE_HOLDING =        2;
    /** Call state: Dialing. */
    public static final int PRECISE_CALL_STATE_DIALING =        3;
    /** Call state: Alerting. */
    public static final int PRECISE_CALL_STATE_ALERTING =       4;
    /** Call state: Incoming. */
    public static final int PRECISE_CALL_STATE_INCOMING =       5;
    /** Call state: Waiting. */
    public static final int PRECISE_CALL_STATE_WAITING =        6;
    /** Call state: Disconnected. */
    public static final int PRECISE_CALL_STATE_DISCONNECTED =   7;
    /** Call state: Disconnecting. */
    public static final int PRECISE_CALL_STATE_DISCONNECTING =  8;

    private int mRingingCallState = PRECISE_CALL_STATE_NOT_VALID;
    private int mForegroundCallState = PRECISE_CALL_STATE_NOT_VALID;
    private int mBackgroundCallState = PRECISE_CALL_STATE_NOT_VALID;
    private int mDisconnectCause = PRECISE_CALL_STATE_NOT_VALID;
    private int mPreciseDisconnectCause = PRECISE_CALL_STATE_NOT_VALID;

    /**
     * Constructor
     *
     * @hide
     */
    public PreciseCallCodes(int ringingCall, int foregroundCall, int backgroundCall,
            int disconnectCause, int preciseDisconnectCause) {
        mRingingCallState = ringingCall;
        mForegroundCallState = foregroundCall;
        mBackgroundCallState = backgroundCall;
        mDisconnectCause = disconnectCause;
        mPreciseDisconnectCause = preciseDisconnectCause;
    }

    /**
     * Empty Constructor
     *
     * @hide
     */
    public PreciseCallCodes() {
    }

    /**
     * Construct a PreciseCallState object from the given parcel.
     */
    private PreciseCallCodes(Parcel in) {
        mRingingCallState = in.readInt();
        mForegroundCallState = in.readInt();
        mBackgroundCallState = in.readInt();
        mDisconnectCause = in.readInt();
        mPreciseDisconnectCause = in.readInt();
    }

    public String[] strCallStates = {
    		"IDLE", // 0
    		"ACTIVE", // 1
    		"HOLDING", // 2
    		"DIALING", // 3
    		"ALERTING", // 4
    		"INCOMING", // 5
    		"WAITING", // 6
    		"DISCONNECTED", // 7
    		"DISCONNECTING" // 8
    		}; 
    
    public String getCallStateString (int state)
    {
    	if (state < 0)
    		return "INVALID";
    	else if (state < 37)
    		return strCallStates[state];
    	else
    		return "STATE " + Integer.toString(state);
    }
    
    /**
     * Get precise ringing call state
     *
     */
    public int getRingingCallState() {
        return mRingingCallState;
    }
    public String getRingingCallStateString ()
    {
    	return getCallStateString (mRingingCallState);
    }
    
    /**
     * Get precise foreground call state
     *
     */
    public int getForegroundCallState() {
        return mForegroundCallState;
    }
    public String getForegroundCallStateString ()
    {
    	return getCallStateString (mForegroundCallState);
    }
    
    /**
     * Get precise background call state
     */
    public int getBackgroundCallState() {
        return mBackgroundCallState;
    }
    public String getBackgroundCallStateString ()
    {
    	return getCallStateString (mBackgroundCallState);
    }

    /**
     * Get disconnect cause generated by the framework
     */
    public int getDisconnectCause() {
        return mDisconnectCause;
    }
    public String getDisconnectCauseString ()
    {
    	if (mDisconnectCause < 0)
    		return "INVALID";
    	else if (mDisconnectCause < 37)
    		return strDisconnectCauses[mDisconnectCause];
    	else
    		return "CAUSE " + Integer.toString(mDisconnectCause);
    }
    public String[] strDisconnectCauses = {
    		"NOT_DISCONNECTED", // 0
    		"INCOMING_MISSED", // 1
    		"NORMAL", // 2
    		"LOCAL", // 3
    		"BUSY", // 4
    		"CONGESTION", // 5
    		"MMI", // 6
    		"INVALID_NUMBER", // 7
    		"NUMBER_UNREACHABLE", // 8
    		"SERVER_UNREACHABLE", // 9
    		"INVALID_CREDENTIALS", // 10
    		"OUT_OF_NETWORK", // 11
    		"SERVER_ERROR", // 12
    		"TIMED_OUT", // 13
    		"LOST_SIGNAL", // 14
    		"LIMIT_EXCEEDED", // 15
    		"INCOMING_REJECTED", // 16
    		"POWER_OFF", // 17
    		"OUT_OF_SERVICE", // 18
    		"ICC_ERROR", // 19
    		"CALL_BARRED", // 20
    		"FDN_BLOCKED", // 21
    		"CS_RESTRICTED", // 22
    		"CS_RESTRICTED_NORMAL", // 23
    		"CS_RESTRICTED_EMERGENCY", // 24
    		"UNOBTAINABLE_NUMBER", // 25
    		"CDMA_LOCKED_UNTIL_POWER_CYCLE", // 26
    		"CDMA_DROP", // 27
    		"CDMA_INTERCEPT", // 28
    		"CDMA_REORDER", // 29
    		"CDMA_SO_REJECT", // 30
    		"CDMA_RETRY_ORDER", // 31
    		"CDMA_ACCESS_FAILURE", // 32
    		"CDMA_PREEMPTED", // 33
    		"CDMA_NOT_EMERGENCY", // 34
    		"CDMA_ACCESS_BLOCKED", // 35
    		"ERROR_UNSPECIFIED" // 36
    		}; 


    /**
     * Get disconnect cause generated by the RIL
     */
    public int getPreciseDisconnectCause() {
        return mPreciseDisconnectCause;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mRingingCallState);
        out.writeInt(mForegroundCallState);
        out.writeInt(mBackgroundCallState);
        out.writeInt(mDisconnectCause);
        out.writeInt(mPreciseDisconnectCause);
    }

    public static final Parcelable.Creator<PreciseCallCodes> CREATOR
            = new Parcelable.Creator<PreciseCallCodes>() {

        public PreciseCallCodes createFromParcel(Parcel in) {
            return new PreciseCallCodes(in);
        }

        public PreciseCallCodes[] newArray(int size) {
            return new PreciseCallCodes[size];
        }
    };

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + mRingingCallState;
        result = prime * result + mForegroundCallState;
        result = prime * result + mBackgroundCallState;
        result = prime * result + mDisconnectCause;
        result = prime * result + mPreciseDisconnectCause;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PreciseCallCodes other = (PreciseCallCodes) obj;
        return (mRingingCallState != other.mRingingCallState &&
            mForegroundCallState != other.mForegroundCallState &&
            mBackgroundCallState != other.mBackgroundCallState &&
            mDisconnectCause != other.mDisconnectCause &&
            mPreciseDisconnectCause != other.mPreciseDisconnectCause);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("ring state: " + getRingingCallStateString());
        sb.append(", foreground state: " + getForegroundCallStateString());
        sb.append(", background state: " + getBackgroundCallStateString());
        if (mDisconnectCause != -1)
        	sb.append(", DISCONNECT CAUSE: " + getDisconnectCauseString());
        sb.append(", Precise cause: " + mPreciseDisconnectCause);

        return sb.toString();
    }
}
