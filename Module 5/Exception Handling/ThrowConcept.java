import java.nio.channels.ScatteringByteChannel;
import java.text.ParseException;

public class ThrowConcept {

    public static void main(String[] args) {

        int age = 10;
        checkAge(age);


    }

    public static boolean checkAge(int age){
        if(age<18) {
            throw new UnderAgeException("You are underage");
        }
        return true;
    }
}
