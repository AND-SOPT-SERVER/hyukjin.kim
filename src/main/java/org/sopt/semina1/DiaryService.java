package org.sopt.semina1;

import java.util.List;

public class DiaryService {
    private final DiaryRepository diaryRepository = new DiaryRepository();

    public List<Diary> getDiariyList() {
        return diaryRepository.findAll();
    }

    public void writeDiary(final String body) {
        Diary diary = new Diary(null, body);
        diaryRepository.save(diary);
    }

    public void deleteDiary(long id) {
        diaryRepository.deleteDiary(id);
    }

    public void patchDiary(long id, String body) {
        Diary diary = new Diary(id, body);
        diaryRepository.updateDiary(id, diary);
    }
}