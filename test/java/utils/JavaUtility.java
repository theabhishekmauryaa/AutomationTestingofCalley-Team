package utils;




import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;


public class JavaUtility {

	public String getRandomString() {
        String random = RandomStringUtils.randomAlphanumeric(100);
        return random;
    }
	

    public String generateRandomEmail() {
        String uuid = UUID.randomUUID().toString().substring(0, 8);
        return "user_" + uuid + "@testmail.com";
    }
    
    public String generateRandomMobileNumber() {
        Random rand = new Random();
        
        // Start with a valid prefix (6, 7, 8, or 9)
        int firstDigit = 6 + rand.nextInt(4);  // Generates 6 to 9

        // Generate the remaining 9 digits
        long remainingDigits = 100000000L + (long)(rand.nextDouble() * 900000000L);

        return firstDigit + String.valueOf(remainingDigits);
    }

}
