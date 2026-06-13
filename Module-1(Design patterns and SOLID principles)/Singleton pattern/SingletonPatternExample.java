public class SingletonPatternExample{
    public static void main(String[] args){
        Logger logger1=Logger.getInstance();
        logger1.log("Log1:");
        Logger logger2=Logger.getInstance();
        logger2.log("log2:");
        System.out.println(logger1==logger2);
    }
}