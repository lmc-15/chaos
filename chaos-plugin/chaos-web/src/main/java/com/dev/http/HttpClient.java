package com.dev.http;

import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * <code>HttpClient</code>
 *
 * @author dengrijin
 * @version v0.1 2020/06/28
 * <p>
 * 继承RestTemplate
 * @see
 * @since JDK1.8
 */
public class HttpClient extends RestTemplate {
    public HttpClient() {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new ByteArrayHttpMessageConverter());
        messageConverters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
        messageConverters.add(new ResourceHttpMessageConverter(false));

        DefaultUriBuilderFactory uriFactory = new DefaultUriBuilderFactory();
        uriFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.URI_COMPONENT);
        setUriTemplateHandler(uriFactory);
    }

    public HttpClient(ClientHttpRequestFactory requestFactory) {
        super(requestFactory);
    }

    public HttpClient(List<HttpMessageConverter<?>> messageConverters) {
        super(messageConverters);
    }

    public HttpClient(int connectTimeout, int readTimeout) {
        this();
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(connectTimeout);
        requestFactory.setReadTimeout(readTimeout);
        setRequestFactory(requestFactory);
    }
}
