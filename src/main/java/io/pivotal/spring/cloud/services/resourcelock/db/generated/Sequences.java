/*
 * This file is generated by jOOQ.
*/
package io.pivotal.spring.cloud.services.resourcelock.db.generated;


import javax.annotation.Generated;

import org.jooq.Sequence;
import org.jooq.impl.SequenceImpl;


/**
 * Convenience access to all sequences in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>public.environments_id_seq</code>
     */
    public static final Sequence<Long> ENVIRONMENTS_ID_SEQ = new SequenceImpl<Long>("environments_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.locks_id_seq</code>
     */
    public static final Sequence<Long> LOCKS_ID_SEQ = new SequenceImpl<Long>("locks_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.pools_id_seq</code>
     */
    public static final Sequence<Long> POOLS_ID_SEQ = new SequenceImpl<Long>("pools_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));
}
