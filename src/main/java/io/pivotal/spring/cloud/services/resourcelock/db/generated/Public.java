/*
 * This file is generated by jOOQ.
*/
package io.pivotal.spring.cloud.services.resourcelock.db.generated;


import io.pivotal.spring.cloud.services.resourcelock.db.generated.tables.EnvironmentMetaSchema;
import io.pivotal.spring.cloud.services.resourcelock.db.generated.tables.Environments;
import io.pivotal.spring.cloud.services.resourcelock.db.generated.tables.FlywaySchemaHistory;
import io.pivotal.spring.cloud.services.resourcelock.db.generated.tables.Locks;
import io.pivotal.spring.cloud.services.resourcelock.db.generated.tables.Pools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = -641477269;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * This table has a single row describing the schema that decribes an environments metadata
     */
    public final EnvironmentMetaSchema ENVIRONMENT_META_SCHEMA = io.pivotal.spring.cloud.services.resourcelock.db.generated.tables.EnvironmentMetaSchema.ENVIRONMENT_META_SCHEMA;

    /**
     * Each environment represents a managed test PCF environment
     */
    public final Environments ENVIRONMENTS = io.pivotal.spring.cloud.services.resourcelock.db.generated.tables.Environments.ENVIRONMENTS;

    /**
     * The table <code>public.flyway_schema_history</code>.
     */
    public final FlywaySchemaHistory FLYWAY_SCHEMA_HISTORY = io.pivotal.spring.cloud.services.resourcelock.db.generated.tables.FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY;

    /**
     * A single lock exists when an environment is claimed by a job or person. When the lock is released, the lock is deleted
     */
    public final Locks LOCKS = io.pivotal.spring.cloud.services.resourcelock.db.generated.tables.Locks.LOCKS;

    /**
     * A pool is a logical grouping of environments eg all environments having version 1.12
     */
    public final Pools POOLS = io.pivotal.spring.cloud.services.resourcelock.db.generated.tables.Pools.POOLS;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Sequence<?>> getSequences() {
        List result = new ArrayList();
        result.addAll(getSequences0());
        return result;
    }

    private final List<Sequence<?>> getSequences0() {
        return Arrays.<Sequence<?>>asList(
            Sequences.ENVIRONMENTS_ID_SEQ,
            Sequences.LOCKS_ID_SEQ,
            Sequences.POOLS_ID_SEQ);
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            EnvironmentMetaSchema.ENVIRONMENT_META_SCHEMA,
            Environments.ENVIRONMENTS,
            FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY,
            Locks.LOCKS,
            Pools.POOLS);
    }
}
