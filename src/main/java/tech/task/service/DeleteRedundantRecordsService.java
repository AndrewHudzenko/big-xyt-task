package tech.task.service;

import tech.task.model.Record;
import tech.task.model.Type;
import java.util.List;

public class DeleteRedundantRecordsService {
    public List<Record> getClearRecords(List<Record> list) {
        List<Record> records = list;
        for (Record record : records) {
            if (record.getType().equals(Type.REMOVE)) {
                for (Record value : records) {
                    if (value.getId().equals(record.getId()) && (value.getType().equals(Type.ADD))) {
                        records.remove(record);
                        records.remove(value);
                        break;
                    }
                }
            }
        }
        return records;
    }
}
