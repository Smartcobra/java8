import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test8 {
    public static void main(String[] args) {
        String num = null;
//        int myNum;
//        try {
//            myNum = Integer.parseInt(num);
//        } catch (NumberFormatException e) {
//            myNum = 0;
//        }
//        System.out.println(myNum);

        ///
        Optional<Integer> integer = OptionalUtility.stringToInt(num);
        System.out.println(integer.isPresent());
    }


}
