package com.example.demo.config;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.DatabaseVersion;
import org.hibernate.dialect.identity.IdentityColumnSupport;
import org.hibernate.dialect.identity.IdentityColumnSupportImpl;
import org.hibernate.engine.jdbc.env.spi.NameQualifierSupport;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.model.TypeContributions;
import org.hibernate.type.descriptor.jdbc.spi.JdbcTypeRegistry;
import org.hibernate.type.descriptor.sql.spi.DdlTypeRegistry;
import org.hibernate.type.descriptor.sql.internal.DdlTypeImpl;
import org.hibernate.type.SqlTypes;

public class SQLiteDialect extends Dialect {

    public SQLiteDialect() {
        super(DatabaseVersion.make(3));
    }

    @Override
    public IdentityColumnSupport getIdentityColumnSupport() {
        return new IdentityColumnSupportImpl() {
            @Override
            public boolean supportsIdentityColumns() {
                return true;
            }

            @Override
            public String getIdentitySelectString(String table, String column, int type) {
                return "select last_insert_rowid()";
            }

            @Override
            public String getIdentityColumnString(int type) {
                return "integer";
            }
        };
    }

    @Override
    public void contributeTypes(TypeContributions typeContributions, ServiceRegistry serviceRegistry) {
        DdlTypeRegistry ddlTypeRegistry = typeContributions.getTypeConfiguration().getDdlTypeRegistry();

        ddlTypeRegistry.addDescriptor(new DdlTypeImpl(SqlTypes.INTEGER, "integer", this));
        ddlTypeRegistry.addDescriptor(new DdlTypeImpl(SqlTypes.VARCHAR, "text", this));
        ddlTypeRegistry.addDescriptor(new DdlTypeImpl(SqlTypes.FLOAT, "float", this));
        ddlTypeRegistry.addDescriptor(new DdlTypeImpl(SqlTypes.DOUBLE, "double", this));
        ddlTypeRegistry.addDescriptor(new DdlTypeImpl(SqlTypes.BOOLEAN, "boolean", this));
        ddlTypeRegistry.addDescriptor(new DdlTypeImpl(SqlTypes.BLOB, "blob", this));
        ddlTypeRegistry.addDescriptor(new DdlTypeImpl(SqlTypes.CLOB, "clob", this));
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
    public boolean supportsCascadeDelete() {
        return false;
    }

    @Override
    public NameQualifierSupport getNameQualifierSupport() {
        return NameQualifierSupport.NONE;
    }
}
