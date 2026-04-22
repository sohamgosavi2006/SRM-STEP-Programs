import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementSystem {

    static class Validator {

        static boolean validateTrainID(String trainID) {
            Pattern pattern = Pattern.compile("TRN-\\d{4}");
            Matcher matcher = pattern.matcher(trainID);
            return matcher.matches();
        }

        static boolean validateCargoCode(String cargoCode) {
            Pattern pattern = Pattern.compile("PET-[A-Z]{2}");
            Matcher matcher = pattern.matcher(cargoCode);
            return matcher.matches();
        }
    }

    public static void main(String[] args) {
        System.out.println("==================================");
        System.out.println(" UC11 - Validate Train ID & Cargo Code ");
        System.out.println("==================================");

        String[] trainIDs = {
                "TRN-1234",
                "TRAIN12",
                "TRN12A",
                "1234-TRN",
                "TRN-123",
                "TRN-12345",
                "",
                "TRN-1234EXTRA"
        };

        String[] cargoCodes = {
                "PET-AB",
                "PET-ab",
                "PET123",
                "AB-PET",
                "PET-Ab",
                "PET-aB",
                "",
                "PET-ABCD"
        };

        System.out.println("\nTrain ID Validation:");
        for (String id : trainIDs) {
            boolean result = Validator.validateTrainID(id);
            System.out.println("Input: " + id + " -> " + (result ? "Valid" : "Invalid"));
        }

        System.out.println("\nCargo Code Validation:");
        for (String code : cargoCodes) {
            boolean result = Validator.validateCargoCode(code);
            System.out.println("Input: " + code + " -> " + (result ? "Valid" : "Invalid"));
        }
    }

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(Validator.validateTrainID("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(Validator.validateTrainID("TRAIN12"));
        assertFalse(Validator.validateTrainID("TRN12A"));
        assertFalse(Validator.validateTrainID("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(Validator.validateCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(Validator.validateCargoCode("PET-ab"));
        assertFalse(Validator.validateCargoCode("PET123"));
        assertFalse(Validator.validateCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(Validator.validateTrainID("TRN-123"));
        assertFalse(Validator.validateTrainID("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(Validator.validateCargoCode("PET-Ab"));
        assertFalse(Validator.validateCargoCode("PET-aB"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(Validator.validateTrainID(""));
        assertFalse(Validator.validateCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(Validator.validateTrainID("TRN-1234EXTRA"));
        assertFalse(Validator.validateCargoCode("PET-ABCD"));
    }
}