package org.exampleVaraan.config.dialect;

import org.hibernate.dialect.Dialect;

import java.sql.Types;

public class SQLiteDialect extends Dialect {
    public SQLiteDialect() {
        super();
        registerColumnType(Types.INTEGER, "integer");
        registerColumnType(Types.VARCHAR, "text");
        // usw.
    }

    //->(wird benutzt, wenn man was überschreibt dann wird Override gemacht)<- @Override
    public boolean supportsIdentityColumns() {
        return true;
    }

    // Weitere Methoden je nach Bedarf
}