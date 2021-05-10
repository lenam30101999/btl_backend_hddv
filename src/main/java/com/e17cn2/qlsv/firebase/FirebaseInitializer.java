package com.e17cn2.qlsv.firebase;

import com.e17cn2.qlsv.QlsvApplication;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
@Log4j2
public class FirebaseInitializer {


    @PostConstruct
    public void initFB(){
        try {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(QlsvApplication.class.getResourceAsStream("/point-management-4f28d-firebase-adminsdk-14rt5-01802becac.json")))
                    .setDatabaseUrl("https://testing-project-291f4.firebaseio.com")
                    .build();
            FirebaseApp defaultApp = FirebaseApp.initializeApp(options);
            FirebaseAuth defaultAuth = FirebaseAuth.getInstance(defaultApp);
            String token = defaultAuth.createCustomToken("CoBeNguoiTay");
            log.debug(token);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
        }
    }

}
