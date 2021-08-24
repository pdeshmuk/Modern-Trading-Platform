package com.modern.training.platform.config;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class MetricsConfig {
	
  	private static final String PROFILE_TAG_KEY = "profile";
  	private static final String APP_TAG_KEY = "appname";
	private static final String HOST_TAG_KEY = "host";
  	private static final String IP_TAG_KEY = "ip";
  
  	@Value("${spring.application.name}")
  	private String appName;

  	@Value("${spring.profile:dev}")
  	private String profile;
    
  	@Bean
  	public MeterRegistryCustomizer<MeterRegistry> customize() {
    
      return registry -> {
        registry.config()
        	.commonTags(APP_TAG_KEY, appName)
        	.commonTags(PROFILE_TAG_KEY, profile)
       		.commonTags(HOST_TAG_KEY, getHostname())
       		.commonTags(IP_TAG_KEY, getIpAddress())
//	        .meterFilter(MeterFilter.ignoreTags("too.much.information"))
//	        .meterFilter(MeterFilter.denyNameStartsWith("jvm"))
	        ;
      };
    }
    
    private String getHostname() {
    	
	   String hostname = "Unknown";

	    try {
	        hostname = InetAddress.getLocalHost().getHostName();
	    } catch (UnknownHostException e) {
	        log.error("Hostname can not be resolved", e);
	    }
	    
	    return hostname;
    }
    
    private String getIpAddress() {

    	String ip = "Unknown";
    	
    	try (final DatagramSocket socket = new DatagramSocket()) {
    	  socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
    	  ip = socket.getLocalAddress().getHostAddress();
	    } catch (SocketException | UnknownHostException e) {
	        log.error("Ip address can not be resolved", e);
	    }
    	
    	return ip;
    }
}
