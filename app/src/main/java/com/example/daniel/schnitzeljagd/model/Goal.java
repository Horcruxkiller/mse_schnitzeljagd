package com.example.daniel.schnitzeljagd.model;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;

/**
 * Created by Daniel on 15.06.2017.
 */

@Entity
public class Goal {

    @Id(autoincrement = true)
    private Long id;

    @Index(unique = true)
    private String name;

    @NotNull
    private int number;

    private String description;

    private String picPath;

    @NotNull
    private Long rallyId;

    @ToOne(joinProperty = "rallyId")
    private Schnitzeljagd rally;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1457320297)
    private transient GoalDao myDao;

    @Generated(hash = 493588258)
    public Goal(Long id, String name, int number, String description,
            String picPath, @NotNull Long rallyId) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.description = description;
        this.picPath = picPath;
        this.rallyId = rallyId;
    }

    @Generated(hash = 1149104271)
    public Goal() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicPath() {
        return this.picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public Long getRallyId() {
        return this.rallyId;
    }

    public void setRallyId(Long rallyId) {
        this.rallyId = rallyId;
    }

    @Generated(hash = 752710240)
    private transient Long rally__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1071533635)
    public Schnitzeljagd getRally() {
        Long __key = this.rallyId;
        if (rally__resolvedKey == null || !rally__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SchnitzeljagdDao targetDao = daoSession.getSchnitzeljagdDao();
            Schnitzeljagd rallyNew = targetDao.load(__key);
            synchronized (this) {
                rally = rallyNew;
                rally__resolvedKey = __key;
            }
        }
        return rally;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2121626215)
    public void setRally(@NotNull Schnitzeljagd rally) {
        if (rally == null) {
            throw new DaoException(
                    "To-one property 'rallyId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.rally = rally;
            rallyId = rally.getId();
            rally__resolvedKey = rallyId;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1503432607)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getGoalDao() : null;
    }

}
