public class StockEntity {
    public int id;
    public String name;
    public Integer cost;
    public int companyId;

    StockEntity(String name, Integer cost, int companyId) {
        this.name = name;
        this.cost = cost;
        this.companyId = companyId;
    }

    StockEntity(int id, String name, Integer cost, int companyId) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.companyId = companyId;
    }
}
