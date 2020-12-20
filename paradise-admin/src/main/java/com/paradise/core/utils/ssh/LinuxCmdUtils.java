package com.paradise.core.utils.ssh;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import com.paradise.core.common.api.Result;
import com.paradise.core.model.PmServerSsh;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * LinuxCmdClient - linux命令行客户端
 *
 * @author Paradise
 */
@Slf4j
public class LinuxCmdUtils {

    private static String DEFAULT_CHARSET = "UTF-8";

    private Connection connection;

    private Session session;

    private PmServerSsh pmServerSsh;

    public LinuxCmdUtils(PmServerSsh pmServerSsh) {
        this.pmServerSsh = pmServerSsh;
    }

    public Result<Object> login() throws IOException {
        boolean flag;
        connection = new Connection(pmServerSsh.getIpAddrPublic(), pmServerSsh.getPort());
        connection.connect();
        flag = connection.authenticateWithPassword(pmServerSsh.getUserName(), pmServerSsh.getPassword());
        if (flag) {
            log.info("SSH - 认证成功！");
            String gbk = "GBK";
            if (locale().contains(gbk)) {
                DEFAULT_CHARSET = "gbk";
            }
            return Result.success("SSH - 认证成功！");
        } else {
            log.info("认证失败！");
            connection.close();
            return Result.failed("认证失败！");
        }

    }

    private String locale() throws IOException {
        session = connection.openSession();
        session.execCommand("echo $LANG");
        String result = processStdout(session.getStdout(), DEFAULT_CHARSET);
        if (StringUtils.isBlank(result)) {
            result = processStdout(session.getStderr(), DEFAULT_CHARSET);
        }
        session.close();
        return result;
    }

    public String date() throws IOException {
        session = connection.openSession();
        session.execCommand("date");
        String result = processStdout(session.getStdout(), DEFAULT_CHARSET);
        if (StringUtils.isBlank(result)) {
            result = processStdout(session.getStderr(), DEFAULT_CHARSET);
        }
        log.info(result);
        session.close();
        return result;
    }

    public void closeClient() {
        if (connection != null) {
            connection.close();
        }
    }

    private static String processStdout(InputStream in, String charset) {
        InputStream stdout = new StreamGobbler(in);
        StringBuilder buffer = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(stdout, charset));
            String line;
            while ((line = br.readLine()) != null) {
                buffer.append(line).append("\n");
            }
        } catch (IOException e) {
            log.error(e.getLocalizedMessage(), e);
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        PmServerSsh serverInfo = new PmServerSsh();
        serverInfo.setIpAddrPublic("111.39.14.4");
        serverInfo.setPort(9022);
        serverInfo.setUserName("root");
        serverInfo.setPassword("xuanchengmas#2016");
        LinuxCmdUtils utils = new LinuxCmdUtils(serverInfo);
        try {
            utils.login();
            System.out.println(utils.date());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            utils.closeClient();
        }

    }

}
