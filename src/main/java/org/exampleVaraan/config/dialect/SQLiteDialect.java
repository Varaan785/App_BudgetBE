package org.exampleVaraan.config.dialect;

import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.identity.IdentityColumnSupport;
import org.hibernate.dialect.identity.IdentityColumnSupportImpl;
import org.hibernate.dialect.pagination.LimitHandler;
import org.hibernate.dialect.pagination.LimitOffsetLimitHandler;
import org.hibernate.engine.jdbc.env.spi.NameQualifierSupport;

public class SQLiteDialect extends Dialect {

    public SQLiteDialect() {
        super();
    }

    @Override
    public IdentityColumnSupport getIdentityColumnSupport() {
        return new IdentityColumnSupportImpl() {
            @Override
            public boolean supportsIdentityColumns() {
                return true;
            }

            @Override
            public String getIdentitySelectString(String table, String column, int type) throws MappingException {
                return "select last_insert_rowid()";
            }

            @Override
            public String getIdentityColumnString(int type) throws MappingException {
                return "INTEGER";
            }

            @Override
            public boolean hasDataTypeInIdentityColumn() {
                return false;
            }

            @Override
            public boolean supportsInsertSelectIdentity() {
                return false;
            }
        };
    }

    @Override
    public NameQualifierSupport getNameQualifierSupport() {
        return NameQualifierSupport.NONE;
    }

    @Override
    public LimitHandler getLimitHandler() {
        return new LimitOffsetLimitHandler();
    }

    @Override
    public boolean supportsIfExistsBeforeTableName() {
        return true;
    }

    @Override
    public boolean supportsIfExistsAfterTableName() {
        return false;
    }

    @Override
    public boolean supportsValuesList() {
        return true;
    }

    @Override
    public boolean supportsTemporaryTables() {
        return true;
    }



    @Override
    public boolean supportsCurrentTimestampSelection() {
        return true;
    }

    @Override
    public boolean isCurrentTimestampSelectStringCallable() {
        return false;
    }

    @Override
    public String getCurrentTimestampSelectString() {
        return "select current_timestamp";
    }
}
