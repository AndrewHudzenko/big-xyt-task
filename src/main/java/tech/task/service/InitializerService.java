package tech.task.service;

import tech.task.model.Order;
import tech.task.model.Record;
import tech.task.model.Type;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class InitializerService {
    DeleteRedundantRecordsService deleteRedundantOrders = new DeleteRedundantRecordsService();

    public List<Record> initialize() {
        List<Record> records = new LinkedList<Record>();

        Record firstRecord = new Record();
        firstRecord.setOrder(Order.BUY);
        firstRecord.setId(1L);
        firstRecord.setType(Type.ADD);
        firstRecord.setPrice(new BigDecimal(20));
        firstRecord.setQuantity(100L);

        Record secondRecord = new Record();
        secondRecord.setOrder(Order.SELL);
        secondRecord.setId(2L);
        secondRecord.setType(Type.ADD);
        secondRecord.setPrice(new BigDecimal(25));
        secondRecord.setQuantity(200L);

        Record thirdRecord = new Record();
        thirdRecord.setOrder(Order.BUY);
        thirdRecord.setId(3L);
        thirdRecord.setType(Type.ADD);
        thirdRecord.setPrice(new BigDecimal(23));
        thirdRecord.setQuantity(50L);

        Record forthRecord = new Record();
        forthRecord.setOrder(Order.BUY);
        forthRecord.setId(4L);
        forthRecord.setType(Type.ADD);
        forthRecord.setPrice(new BigDecimal(23));
        forthRecord.setQuantity(70L);

        Record fifthRecord = new Record();
        fifthRecord.setOrder(Order.BUY);
        fifthRecord.setId(3L);
        fifthRecord.setType(Type.REMOVE);
        fifthRecord.setPrice(new BigDecimal(23));
        fifthRecord.setQuantity(50L);

        Record sixthRecord = new Record();
        sixthRecord.setOrder(Order.SELL);
        sixthRecord.setId(5L);
        sixthRecord.setType(Type.ADD);
        sixthRecord.setPrice(new BigDecimal(28));
        sixthRecord.setQuantity(100L);

        records.add(firstRecord);
        records.add(secondRecord);
        records.add(thirdRecord);
        records.add(forthRecord);
        records.add(fifthRecord);
        records.add(sixthRecord);

        return deleteRedundantOrders.getClearRecords(records);
    }
}

