public class DataProcessor {
    private final DataFetcher fetcher;

    public DataProcessor(DataFetcher fetcher) {
        this.fetcher = fetcher;
    }

    public String processTwice() {
        return fetcher.fetch() + " and " + fetcher.fetch();
    }
}
