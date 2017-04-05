package com.example.aisling.finalprojectaislingstafford;


public class Config
{

        //Address of our scripts of the CRUD
       //COLLEGE IP ADDRESS: 10.102.11.96

        public static final String URL_ADD="http://192.168.1.5/addUser.php";
        public static final String URL_GET_USER = "http://192.168.1.5/getUser.php?id=";
        public static final String URL_UPDATE_USER = "http://192.168.1.5/updateUser.php?id=";
        public static final String URL_LOGIN = "http://192.168.1.5/login1.php";


        //Keys that will be used to send the request to php scripts
        public static final String KEY_USER_ID = "id";
        public static final String KEY_FIRST_NAME = "firstName";
        public static final String KEY_LAST_NAME = "lastName";
        public static final String KEY_EMAIL = "email";
        public static final String KEY_PASSWORD = "password";
        public static final String KEY_PROFILE_IMAGE_URL = "profileImageUrl";

        //JSON Tags
        public static final String TAG_JSON_ARRAY="result";
        public static final String TAG_ID = "userId";
        public static final String TAG_FIRST_NAME = "firstName";
        public static final String TAG_LAST_NAME = "lastName";
        public static final String TAG_EMAIL = "email";
        public static final String TAG_PASSWORD = "password";
        public static final String TAG_PROFILE_IMAGE_URL= "profileImageURL";

        //employee id to pass with intent
        public static final String USER_ID = "user_id";
}
