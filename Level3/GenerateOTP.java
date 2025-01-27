import java.util.*;
public class GenerateOTP {
    public static int generateOTP() {
        return (int)(Math.random() * 900000) + 100000;
    }

    public static boolean areOTPsUnique(List<Integer> otps) {
        return new HashSet<>(otps).size() == otps.size();
    }

    public static void main(String[] args) {
        List<Integer> otps = new ArrayList<>();
        for (int i = 0; i < 10; i++) otps.add(generateOTP());
        System.out.println("Generated OTPs: " + otps);
        System.out.println("All OTPs Unique: " + areOTPsUnique(otps));
    }
} 
