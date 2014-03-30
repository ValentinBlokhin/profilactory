package com.profilactory.model.dao.databasefilter;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.dbunit.util.fileloader.FullXmlDataFileLoader;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Created by ValentinBlokhin on 3/27/2014.
 */
public class DataBaseFilter {
    private String fullXmlDataFileName;
    private DataSource dataSource;

    public DataBaseFilter(String fullXmlDataFileName, DataSource dataSource) {
        this.fullXmlDataFileName = fullXmlDataFileName;
        this.dataSource = dataSource;
    }

    public DataBaseFilter() {
    }

    public void fill() throws Exception {
        Connection connect = null;
        try {
            connect = DataSourceUtils.getConnection(dataSource);
            IDatabaseConnection dbUnitConnect = new DatabaseConnection(connect);

            FullXmlDataFileLoader loader = new FullXmlDataFileLoader();
            IDataSet xmlDataSet = loader.load(fullXmlDataFileName);

            DatabaseOperation.CLEAN_INSERT.execute(dbUnitConnect, xmlDataSet);
        } finally {
            DataSourceUtils.releaseConnection(connect, dataSource);
        }
    }
}
