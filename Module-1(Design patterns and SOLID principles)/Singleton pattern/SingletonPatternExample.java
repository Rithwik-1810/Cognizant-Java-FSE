public class SingletonPatternExample{
    public static void main(String[] args){
        Logger logger1=Logger.getInstance();
        logger1.log("First Log");
        Logger logger2=Logger.getInstance();
        logger2.log("Second log");
        System.out.println(logger1==logger2);
    }
}