package com.toy.shop.code;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DBLength {

    public final static int YN_LENGTH = 1;

    public final static int EMAIL_LENGTH = 100;

    public final static int PASSWORD_LENGTH = 255;

    public final static int NAME_LENGTH = 20;

    public final static int PHONE_LENGTH = 15;

    public final static int ZIPCODE_LENGTH = 10;

    public final static int ADDRESS_LENGTH = 10;

    public final static int CODE_LENGTH = 20;

    public final static int ITEM_CD_LENGTH = 30;

    public final static int ITEM_NM_LENGTH = 100;
}
