package com.rasel.registration.model;

import android.os.Parcel;
import android.os.Parcelable;

public class UserInfo implements Parcelable {

    private String Name, Email, Address, Phone, Gender, ProfilePic, AuthStatus,
            LastAction, MakeDate, LastUpdateDate, MakeBy, UpdatedBy;

    private int ID;


    protected UserInfo(Parcel in) {
        Name = in.readString();
        Email = in.readString();
        Address = in.readString();
        Phone = in.readString();
        Gender = in.readString();
        ProfilePic = in.readString();
        AuthStatus = in.readString();
        LastAction = in.readString();
        MakeDate = in.readString();
        LastUpdateDate = in.readString();
        MakeBy = in.readString();
        UpdatedBy = in.readString();
        ID = in.readInt();
    }

    public static final Creator<UserInfo> CREATOR = new Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(Parcel in) {
            return new UserInfo(in);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getAddress() {
        return Address;
    }

    public String getPhone() {
        return Phone;
    }

    public String getGender() {
        return Gender;
    }

    public String getProfilePic() {
        return ProfilePic;
    }

    public String getAuthStatus() {
        return AuthStatus;
    }

    public String getLastAction() {
        return LastAction;
    }

    public String getMakeDate() {
        return MakeDate;
    }

    public String getLastUpdateDate() {
        return LastUpdateDate;
    }

    public String getMakeBy() {
        return MakeBy;
    }

    public String getUpdatedBy() {
        return UpdatedBy;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Name);
        dest.writeString(Email);
        dest.writeString(Address);
        dest.writeString(Phone);
        dest.writeString(Gender);
        dest.writeString(ProfilePic);
        dest.writeString(AuthStatus);
        dest.writeString(LastAction);
        dest.writeString(MakeDate);
        dest.writeString(LastUpdateDate);
        dest.writeString(MakeBy);
        dest.writeString(UpdatedBy);
        dest.writeInt(ID);
    }
}
