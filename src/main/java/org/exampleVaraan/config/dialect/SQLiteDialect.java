package org.exampleVaraan.config.dialect;

import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.identity.IdentityColumnSupport;
import org.hibernate.dialect.pagination.LimitHandler;
import org.hibernate.dialect.pagination.LimitOffsetLimitHandler;
import org.hibernate.engine.jdbc.env.spi.NameQualifierSupport;
import org.hibernate.id.PostInsertIdentityPersister;
import org.hibernate.id.insert.GetGeneratedKeysDelegate;

public class SQLiteDialect extends Dialect {

    public SQLiteDialect() {
        super();
    }

    @Override
    public IdentityColumnSupport getIdentityColumnSupport() {
        return new SQLiteIdentityColumnSupport();
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
        return true;  // SQLite unterstützt dies
    }

    @Override
    public boolean supportsIfExistsAfterTableName() {
        return false;  // SQLite unterstützt dies nicht
    }

    @Override
    public boolean supportsValuesList() {
        return true; // SQLite unterstützt dies
    }

    // Benutzerdefinierte IdentityColumnSupport-Klasse für SQLite
    public static class SQLiteIdentityColumnSupport implements IdentityColumnSupport, org.exampleVaraan.config.dialect.SQLiteIdentityColumnSupport {

        @Override
        public boolean supportsIdentityColumns() {
            return true;
        }

        @Override
        public boolean supportsInsertSelectIdentity() {
            return false;
        }

        @Override
        public boolean hasDataTypeInIdentityColumn() {
            return false;
        }

        @Override
        public String appendIdentitySelectToInsert(String s) {
            return "";
        }

        @Override
        public String getIdentitySelectString(String s, String s1, int i) throws MappingException {
            return "";
        }

        @Override
        public String getIdentityColumnString(int i) throws MappingException {
            return "";
        }

        @Override
        public String getIdentityInsertString() {
            return "";
        }

        @Override
        public GetGeneratedKeysDelegate buildGetGeneratedKeysDelegate(PostInsertIdentityPersister postInsertIdentityPersister, Dialect dialect) {
            return null;
        }

        @Override
        public String getIdentitySelectString(String table, String column) {
            return "select last_insert_rowid()"; // SQLite-spezifisch für die letzte eingefügte ID
        }

        @Override
        public String getIdentityColumnString() {
            return "integer primary key autoincrement"; // Definiert den Datentyp für die Identität
        }
    }
}
