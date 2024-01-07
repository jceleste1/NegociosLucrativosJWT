package com.brforte;

import java.io.FileInputStream;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

public class Init {

    public static void initAdminSdk() throws IOException {

        String filepath = "files/your file name.json";
        GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(filepath));
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(credentials)
                .setDatabaseUrl("your firebase db url")
                .build();

        FirebaseApp.initializeApp(options);
    }
}