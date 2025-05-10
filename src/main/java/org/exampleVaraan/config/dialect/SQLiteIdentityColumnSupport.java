package org.exampleVaraan.config.dialect;

public interface SQLiteIdentityColumnSupport {
    String getIdentitySelectString(String table, String column);

    String getIdentityColumnString();
}
