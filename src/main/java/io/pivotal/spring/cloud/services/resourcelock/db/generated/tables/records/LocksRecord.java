/*
 * This file is generated by jOOQ.
*/
package io.pivotal.spring.cloud.services.resourcelock.db.generated.tables.records;


import io.pivotal.spring.cloud.services.resourcelock.db.generated.tables.Locks;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


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
public class LocksRecord extends UpdatableRecordImpl<LocksRecord> implements Record4<Integer, Timestamp, String, Integer> {

    private static final long serialVersionUID = 1961890016;

    /**
     * Setter for <code>public.locks.id</code>.
     */
    public LocksRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.locks.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.locks.claimed_time</code>.
     */
    public LocksRecord setClaimedTime(Timestamp value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.locks.claimed_time</code>.
     */
    public Timestamp getClaimedTime() {
        return (Timestamp) get(1);
    }

    /**
     * Setter for <code>public.locks.claimed_by</code>.
     */
    public LocksRecord setClaimedBy(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.locks.claimed_by</code>.
     */
    public String getClaimedBy() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.locks.environment_id</code>.
     */
    public LocksRecord setEnvironmentId(Integer value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.locks.environment_id</code>.
     */
    public Integer getEnvironmentId() {
        return (Integer) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Timestamp, String, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Timestamp, String, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Locks.LOCKS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field2() {
        return Locks.LOCKS.CLAIMED_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Locks.LOCKS.CLAIMED_BY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Locks.LOCKS.ENVIRONMENT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component2() {
        return getClaimedTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getClaimedBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getEnvironmentId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value2() {
        return getClaimedTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getClaimedBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getEnvironmentId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocksRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocksRecord value2(Timestamp value) {
        setClaimedTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocksRecord value3(String value) {
        setClaimedBy(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocksRecord value4(Integer value) {
        setEnvironmentId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocksRecord values(Integer value1, Timestamp value2, String value3, Integer value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LocksRecord
     */
    public LocksRecord() {
        super(Locks.LOCKS);
    }

    /**
     * Create a detached, initialised LocksRecord
     */
    public LocksRecord(Integer id, Timestamp claimedTime, String claimedBy, Integer environmentId) {
        super(Locks.LOCKS);

        set(0, id);
        set(1, claimedTime);
        set(2, claimedBy);
        set(3, environmentId);
    }
}
