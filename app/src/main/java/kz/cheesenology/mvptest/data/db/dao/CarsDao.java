package kz.cheesenology.mvptest.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import kz.cheesenology.mvptest.data.db.LocalCars;
import kz.cheesenology.mvptest.data.db.LocalCarsMark;

@Dao
public interface CarsDao {
    @Query("SELECT t.*, t1.* FROM cars t LEFT JOIN mark t1 ON t.mark_id = t1.id ")
    List<LocalCarsMark> getCarsData();

    @Query("SELECT * FROM cars WHERE car_id = :id")
    LocalCars getCarName(Integer id);

    @Query("UPDATE cars SET car_name = :carName WHERE car_id = :id")
    int updateCarName(Integer id, String carName);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(LocalCars... cars);
}
