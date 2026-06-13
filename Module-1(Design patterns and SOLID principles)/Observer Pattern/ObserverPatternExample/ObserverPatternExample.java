public class ObserverPatternExample {
    public static void main(String[] args) {
        // Create stock market (Subject) for Google stock
        StockMarket googleStock = new StockMarket("Google (GOOGL)", 175.50);

        // Create observers (Clients)
        Observer mobileClient = new MobileApp("TradingPro Mobile");
        Observer webClient = new WebApp("Finance portal Web");

        // Register observers to the stock
        googleStock.register(mobileClient);
        googleStock.register(webClient);

        // Change price, notifying registered clients
        System.out.println("--- Update 1: Stock price changes to $180.25 ---");
        googleStock.setPrice(180.25);

        System.out.println("\n--- Update 2: Stock price changes to $178.00 ---");
        googleStock.setPrice(178.00);

        // Deregister the web client
        System.out.println("\nDeregistering the Web App client...");
        googleStock.deregister(webClient);

        // Change price again, only the mobile client should get the update
        System.out.println("\n--- Update 3: Stock price changes to $182.50 ---");
        googleStock.setPrice(182.50);
    }
}
