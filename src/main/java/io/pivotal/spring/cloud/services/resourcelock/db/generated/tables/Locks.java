/*
 * This file is generated by jOOQ.
*/
package io.pivotal.spring.cloud.services.resourcelock.db.generated.tables;


import io.pivotal.spring.cloud.services.resourcelock.db.generated.Indexes;
import io.pivotal.spring.cloud.services.resourcelock.db.generated.Keys;
import io.pivotal.spring.cloud.services.resourcelock.db.generated.Public;
import io.pivotal.spring.cloud.services.resourcelock.db.generated.tables.records.LocksRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * A single lock exists when an environment is claimed by a job or person. 
 * When the lock is released, the lock is deleted
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Locks extends TableImpl<LocksRecord> {

    private static final long serialVersionUID = -1313452362;

    /**
     * The reference instance of <code>public.locks</code>
     */
    public static final Locks LOCKS = new Locks();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LocksRecord> getRecordType() {
        return LocksRecord.class;
    }

    /**
     * The column <code>public.locks.id</code>.
     */
    public final TableField<LocksRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('locks_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.locks.claimed_time</code>.
     */
    public final TableField<LocksRecord, Timestamp> CLAIMED_TIME = createField("claimed_time", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("timezone('utc'::text, now())", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>public.locks.claimed_by</code>.
     */
    public final TableField<LocksRecord, String> CLAIMED_BY = createField("claimed_by", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.locks.environment_id</code>.
     */
    public final TableField<LocksRecord, Integer> ENVIRONMENT_ID = createField("environment_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>public.locks</code> table reference
     */
    public Locks() {
        this(DSL.name("locks"), null);
    }

    /**
     * Create an aliased <code>public.locks</code> table reference
     */
    public Locks(String alias) {
        this(DSL.name(alias), LOCKS);
    }

    /**
     * Create an aliased <code>public.locks</code> table reference
     */
    public Locks(Name alias) {
        this(alias, LOCKS);
    }

    private Locks(Name alias, Table<LocksRecord> aliased) {
        this(alias, aliased, null);
    }

    private Locks(Name alias, Table<LocksRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "A single lock exists when an environment is claimed by a job or person. When the lock is released, the lock is deleted");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.LOCKS_ENVIRONMENT_ID_UINDEX, Indexes.LOCKS_ID_UINDEX, Indexes.LOCKS_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<LocksRecord, Integer> getIdentity() {
        return Keys.IDENTITY_LOCKS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<LocksRecord> getPrimaryKey() {
        return Keys.LOCKS_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<LocksRecord>> getKeys() {
        return Arrays.<UniqueKey<LocksRecord>>asList(Keys.LOCKS_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Locks as(String alias) {
        return new Locks(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Locks as(Name alias) {
        return new Locks(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Locks rename(String name) {
        return new Locks(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Locks rename(Name name) {
        return new Locks(name, null);
    }
}