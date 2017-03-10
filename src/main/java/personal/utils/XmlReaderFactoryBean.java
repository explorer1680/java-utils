package personal.utils;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.core.io.Resource;

public class XmlReaderFactoryBean implements FactoryBean<String> {

    private Resource resource;

    private static final String COMMENT_BEGIN = "<!--";
    private static final String COMMENT_END = "-->";

    private static final String EMPTY = "";

    public XmlReaderFactoryBean(Resource resource) {
        this.resource = resource;
    }

    @Override
    public String getObject() throws Exception {
        InputStream is = resource.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        LineNumberReader lineNumberReader = new LineNumberReader(br);

        String currentStatement = lineNumberReader.readLine();
        StringBuilder scriptBuilder = new StringBuilder();

        boolean commentHasStarted = false;

        while (currentStatement != null) {

            // Note: the order matters here for the 2 while clause
            while (commentHasStarted) {
                int positionOfEndComment = currentStatement.indexOf(COMMENT_END);
                if (positionOfEndComment >= 0) {
                    currentStatement = currentStatement.substring(positionOfEndComment + COMMENT_END.length());
                    commentHasStarted = false;
                }
                else {
                    currentStatement = EMPTY;
                    break; // skip this line
                }
            }

            while (!commentHasStarted) {

                int positionOfStartComment = currentStatement.indexOf(COMMENT_BEGIN);
                if (positionOfStartComment >= 0) {
                    int positionOfEndComment = currentStatement.indexOf(COMMENT_END,
                            positionOfStartComment + COMMENT_BEGIN.length());
                    if (positionOfEndComment >= 0) {
                        currentStatement = removePairOfComment(currentStatement);
                    }
                    else {
                        currentStatement = beforeStartComment(currentStatement);
                        commentHasStarted = true; // it also break
                    }
                }
                else {
                    break;
                }

            }

            if (currentStatement.trim().length() > 0) {
                scriptBuilder.append(currentStatement);
                scriptBuilder.append('\n');

            }

            currentStatement = lineNumberReader.readLine();

        }
        return scriptBuilder.toString();

    }

    private String beforeStartComment(String input) {
        int beforeCommentPosition = input.indexOf(COMMENT_BEGIN);
        return input.substring(0, beforeCommentPosition);
    }

    private String removePairOfComment(String input) {
        int beforeCommentPosition = input.indexOf(COMMENT_BEGIN);
        String beforeCommentStr = input.substring(0, beforeCommentPosition);

        int afterCommentPosition = input.indexOf(COMMENT_END, beforeCommentPosition);
        String afterCommentStr = input.substring(afterCommentPosition + COMMENT_END.length());

        return beforeCommentStr + afterCommentStr;
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
