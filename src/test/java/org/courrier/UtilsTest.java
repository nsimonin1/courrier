package org.courrier;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by SimonPascal on 04/18/2016.
 */
public class UtilsTest {


    @Test
    public void contextLoads() {
        final PasswordEncoder encoder = new BCryptPasswordEncoder(8);
        System.out.println(encoder.encode("admin"));
    }
}
