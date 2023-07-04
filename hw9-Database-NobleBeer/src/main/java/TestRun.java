import java.util.Optional;

public class TestRun {
    public static void main(String[] args) {
        StockRepository repositoryStock = new StockRepository();
        CompanyRepository repositoryCompany = new CompanyRepository();
        CompanyEntity companyDefault = new CompanyEntity("testFFF", "Russian",
                "2001-02-04", 28);
        CompanyEntity companyUp = new CompanyEntity("Aboba", "World",
                "2001-12-11", 1337);
        StockEntity stockDefault = new StockEntity("testAboba", 337,
                8);
        StockEntity stockUp = new StockEntity("test1337", 488,
                2);

        // company
        // repositoryCompany.createCompany(companyDefault);
        // repositoryCompany.createCompany(companyUp);
        // repositoryCompany.deleteSQL(companyUp);
        // repositoryCompany.updateSQL(companyDefault, companyUp);
        // repositoryCompany.deleteSQL(companyUp);
        // repositoryCompany.createCompany(companyDefault);
        // repositoryCompany.deleteSQL(companyDefault);

        // stock
        // repositoryStock.updateSQL(stockDefault, stockUp);
        Optional<CompanyEntity> findCompany = repositoryCompany.find(12);
        findCompany.map(comp -> comp.creationDate).ifPresent(System.out::println);
        Optional<StockEntity> findResult = repositoryStock.find(563);
        findResult.map(stock -> stock.name).ifPresent(System.out::println);
        // repositoryStock.update(5, stockDefault);
        System.out.println(findResult.map(stock -> stock.name));

    }
}
