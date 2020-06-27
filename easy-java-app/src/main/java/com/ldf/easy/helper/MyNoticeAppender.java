package com.ldf.easy.helper;

import ch.qos.logback.classic.net.SMTPAppender;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.helpers.CyclicBuffer;
import ch.qos.logback.core.pattern.PatternLayoutBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 自定义错误邮件
 * @author lidefu
 * @date 2020年03月16日10:51
 **/
public class MyNoticeAppender extends SMTPAppender {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyNoticeAppender.class);


    @Override
    protected void sendBuffer(CyclicBuffer cb, ILoggingEvent lastEventObject){
        try {
            String title = subjectLayout.doLayout(lastEventObject);
            String[] toAddress = toAddress(lastEventObject);
            String content = content(cb);
            LOGGER.debug("自定义错误邮件,title:{}, toAddress:{}, content:{}", title, toAddress, content);
        }catch (Exception e){
            LOGGER.error("错误日志通知异常", e);
        }
    }

    private String[] toAddress(ILoggingEvent event){
        List<PatternLayoutBase<ILoggingEvent>> toList = getToList();
        String[] toAddress = new String[toList.size()];
        for(int i=0; i<toList.size(); i++){
            toAddress[i] = toList.get(i).doLayout(event);
        }
        return toAddress;
    }

    private String content(CyclicBuffer cb){
            StringBuffer sbuf = new StringBuffer();

            String header = layout.getFileHeader();
        if (header != null) {
            sbuf.append(header);
        }
        String presentationHeader = layout.getPresentationHeader();
        if (presentationHeader != null) {
            sbuf.append(presentationHeader);
        }
        fillBuffer(cb, sbuf);
        String presentationFooter = layout.getPresentationFooter();
        if (presentationFooter != null) {
            sbuf.append(presentationFooter);
        }
        String footer = layout.getFileFooter();
        if (footer != null) {
            sbuf.append(footer);
        }
        return sbuf.toString();

    }

}
