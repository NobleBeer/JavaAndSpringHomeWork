public class CompanyEntity {
    public String name;
    public String country;
    public String creationDate;
    public int stocksCount;
    public int id;

    CompanyEntity(String name, String country, String creationDate, int stocksCount) {
        this.name = name;
        this.country = country;
        this.creationDate = creationDate;
        this.stocksCount = stocksCount;
    }

    CompanyEntity(int id, String name, String country, String creationDate, int stocksCount) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.creationDate = creationDate;
        this.stocksCount = stocksCount;
    }
}
