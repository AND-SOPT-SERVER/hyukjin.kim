package org.sopt.semina1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class DiaryRepository {
    private final Map<Long, String> storage = new ConcurrentHashMap<>();
    private final AtomicLong numbering = new AtomicLong();

    List<Diary> findAll() {
        final List<Diary> diaryList = new ArrayList<>();
        for (long index = 1; index <= numbering.intValue(); index++) {
            final String body = storage.get(index);
            if (body != null) {
                diaryList.add(new Diary(index, body));
            }
        }
        return diaryList;
    }

    public void save(final Diary diary) {
        // 채번 과정
        final long id = numbering.addAndGet(1);
        storage.put(id, diary.getBody());

    }

    public void deleteDiary(long id) {
        storage.remove(id);
    }

    public void updateDiary(long id, final Diary diary) {
        storage.put(id, diary.getBody());
    }
}