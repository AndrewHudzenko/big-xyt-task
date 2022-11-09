package tech.task;

import tech.task.model.Record;
import tech.task.service.DeleteRedundantRecordsService;
import tech.task.service.FindBetterPricesService;
import tech.task.service.InitializerService;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InitializerService initializerService = new InitializerService();
        DeleteRedundantRecordsService deleteRedundantRecordsService = new DeleteRedundantRecordsService();
        FindBetterPricesService betterPricesService = new FindBetterPricesService();

        List<Record> records = initializerService.initialize();

        System.out.println("At the start we have a list of records: ");
        records.forEach(System.out::println);

        /**
        *  Then we have to find records with the operation type REMOVE, if exist,
         *  delete them, and their copies of ADD type which were declared before:
         *  */
        List<Record> clearRecords = deleteRedundantRecordsService.getClearRecords(records);

        betterPricesService.getRecordWithBetterPrice(clearRecords);
    }
}
