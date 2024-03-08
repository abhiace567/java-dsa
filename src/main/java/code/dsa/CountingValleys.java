package code.dsa;


// https://www.hackerrank.com/challenges/counting-valleys/problem?isFullScreen=true
public class CountingValleys {

    public static void main(String[] args) {
        System.out.println(countingValleys(8, "UDDDUDUU"));
        System.out.println(countingValleys(12, "DDUUDDUDUUUD"));
        System.out.println(countingValleys(100,
                "DUDUUUUUUUUDUDDUUDUUDDDUUDDDDDUUDUUUUDDDUUUUUUUDDUDUDUUUDDDDUUDDDUDDDDUUDDUDDUUUDUUUDUUDUDUDDDDDDDDD"));
    }

    public static int countingValleys(int steps, String path) {
        int lvl = 0;
        int valleyCount = 0;
        boolean passSeaLvl = true;
        int i = 0;
        while (i < steps) {
            char terrain = path.charAt(i);
            if(terrain == 'U') {
                if(i >= 1 && path.charAt(i-1) == 'D') {
                    if (passSeaLvl && lvl < 0) {
                        valleyCount++;
                        passSeaLvl = false;
                    }
                }
                lvl++;
            } else lvl--;
            if(lvl == 0) passSeaLvl = true;
            i++;
        }

    return valleyCount;
    }
}
