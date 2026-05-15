package java12;

public class SwitchCaseYieldExample1 {

    void switchExample(int day) {
        String dayName = switch(day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            default -> "other day";
        };
        System.out.println("selected day name : " + dayName);
    }

    void swtichYeildExample(String day) {
        String dayName = switch(day) {
            case "1","2" -> "week starting";
            case "3","4","5" -> {
                System.out.println("mid week day");
                yield "MidWeek"; //yield returns the value
            }
            case "6","7" -> {
                System.out.println("weekend day");
                yield "weekend";
            }
            default -> "day is out of a week range";
        };
        System.out.println("selected day :" + day + " : " + dayName);
    }

    public static void main(String[] args) {
        SwitchCaseYieldExample1 je = new SwitchCaseYieldExample1();
        je.switchExample(1);
        je.swtichYeildExample("1");
        je.swtichYeildExample("11");
        je.swtichYeildExample("3");
        je.swtichYeildExample("6");
        je.swtichYeildExample("4");
    }
}
