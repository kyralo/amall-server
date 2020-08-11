//package online.kyralo.amall.common.config;
//
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.http.Header;
//import org.apache.http.HttpHost;
//import org.apache.http.auth.AuthScope;
//import org.apache.http.auth.UsernamePasswordCredentials;
//import org.apache.http.client.CredentialsProvider;
//import org.apache.http.impl.client.BasicCredentialsProvider;
//import org.apache.http.message.BasicHeader;
//import org.elasticsearch.client.Node;
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestClientBuilder;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import tk.mybatis.mapper.util.StringUtil;
//
//import java.util.Arrays;
//import java.util.Objects;
//
///**
// * \* Created with Intellij IDEA.
// * \* Author: wangchen
// * \* Date: 2020/6/28
// * \* Time: 8:54
// * \* Description:
// * \
// */
//
//@Slf4j
//@Configuration
//public class ElasticsearchConfig {
//
//    private static final Integer ADDRESS_LENGTH = 2;
//    private static final String HTTP_SCHEME = "http";
//
//    @Value("${elasticsearch.username}")
//    private String username;
//
//    @Value("${elasticsearch.password}")
//    private String password;
//
//    /**
//     * 使用冒号隔开ip和端口1 ip:port
//     */
//    @Value("${elasticsearch.ip}")
//    String[] ip;
//
//    private HttpHost makeHttpHost(String s) {
//        assert StringUtil.isNotEmpty(s);
//        String[] address = s.split(":");
//        if (address.length == ADDRESS_LENGTH) {
//            String ip = address[0];
//            int port = Integer.parseInt(address[1]);
//            return new HttpHost(ip, port, HTTP_SCHEME);
//        } else {
//            return null;
//        }
//    }
//
//    @Bean
//    public RestClientBuilder restClientBuilder() {
//        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
//        credentialsProvider.setCredentials(AuthScope.ANY,
//                //es账号密码（默认用户名为elastic）
//                new UsernamePasswordCredentials(username, password));
//
//        HttpHost[] hosts = Arrays.stream(ip)
//                .map(this::makeHttpHost)
//                .filter(Objects::nonNull)
//                .toArray(HttpHost[]::new);
//        log.debug("hosts:{}", Arrays.toString(hosts));
//
////        Header[] defaultHeaders = new Header[]{new BasicHeader("header", "value")};
//
//        return RestClient.builder(hosts).setHttpClientConfigCallback(httpClientBuilder -> {
//            httpClientBuilder.disableAuthCaching();
//            return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
//        }).setFailureListener(new RestClient.FailureListener(){
//            @SneakyThrows
//            @Override
//            public void onFailure(Node node) {
//                super.onFailure(node);
//                HttpHost host = node.getHost();
//                log.error(" {} request failed ...", host.getAddress());
//                throw new Exception("request failed ...");
//            }
//        });
//    }
//
////    @Bean(name = "highLevelClient")
////    public RestHighLevelClient highLevelClient() {
////        return new RestHighLevelClient(restClientBuilder());
////    }
//
////    @Bean(name = "highLevelClient")
////    public RestHighLevelClient highLevelClient() {
////        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
////        credentialsProvider.setCredentials(AuthScope.ANY,
////                //es账号密码（默认用户名为elastic）
////                new UsernamePasswordCredentials(username, password));
////
////        return new RestHighLevelClient(
////                RestClient.builder(
////                        new HttpHost("localhost", 9200, HTTP_SCHEME))
////                        .setHttpClientConfigCallback(httpClientBuilder -> {
////                            httpClientBuilder.disableAuthCaching();
////                            return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
////                        }));
////    }
//
//}
//
