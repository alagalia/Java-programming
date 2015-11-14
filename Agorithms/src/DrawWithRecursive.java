public class DrawWithRecursive {

    public static void printFigure(String str, int times) {
        if (times==0){
            return;
        }
        System.out.println(new String(new char[times]).replace("\0", str));
        printFigure(str, times - 1);
        System.out.println(new String(new char[times]).replace("\0", "#"));
    }
    public static void main(String[] args) {
        printFigure("*", 5);
    }
}
