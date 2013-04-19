package com.pohil.vcards.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.pohil.vcards.model.Card;
import com.pohil.vcards.model.Pile;

public class PileDAO extends BaseDAO{

    public PileDAO(SQLiteDatabase db) {
        super(db);
    }

    @Override
    public String getTableName() {
        return DbOpenHelper.TABLE_PILE;
    }

    public Pile creare(String name, String description) {
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("description", description);
        int id = (int) db.insert(getTableName(), null, cv);
        Pile pile = new Pile();
        pile.setName(name);
        pile.setDescription(description);
        pile.setId(id);
        return pile;
    }
    public void addCard(Pile pile, Card card) {
        CardDAO cardDao = new CardDAO(db);
        cardDao.create(pile.getId(), card);
    }

}