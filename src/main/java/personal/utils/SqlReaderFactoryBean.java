package personal.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.core.io.Resource;

public class SqlReaderFactoryBean implements FactoryBean<String> {
    private Resource resource;

    private static final String COMMENT_PREFIX = "--";

    public SqlReaderFactoryBean(Resource resource) {
        this.resource = resource;
    }

    @Override
    public String getObject() throws Exception {
        InputStream is = resource.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        LineNumberReader lineNumberReader = new LineNumberReader(br);

        String currentStatement = lineNumberReader.readLine();
        StringBuilder scriptBuilder = new StringBuilder();

        while (currentStatement != null) {

            // start with "--", go to next line
            if (COMMENT_PREFIX != null && !currentStatement.startsWith(COMMENT_PREFIX)) {

                int position = currentStatement.indexOf(COMMENT_PREFIX);
                if (position > 0) {
                    currentStatement = currentStatement.substring(0, position);
                }

                // after remove "--", is it a empty line?
                if (!currentStatement.trim().isEmpty()) {

                    scriptBuilder.append(currentStatement);
                    // last \n will connect with following conditions in java class
                    scriptBuilder.append('\n');
                }
            }
            currentStatement = lineNumberReader.readLine();
        }
        return scriptBuilder.toString();
    }

    @Override
    public Class<String> getObjectType() {
        return String.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
