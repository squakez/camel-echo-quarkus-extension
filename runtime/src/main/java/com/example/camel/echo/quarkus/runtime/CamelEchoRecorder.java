package com.example.camel.echo.quarkus.runtime;

import io.quarkus.runtime.RuntimeValue;
import io.quarkus.runtime.annotations.Recorder;
import org.apache.camel.CamelContext;
import org.apache.camel.spi.CamelContextCustomizer;
import org.apache.camel.component.echo.EchoComponent;

@Recorder
public class CamelEchoRecorder {

    public RuntimeValue<CamelContextCustomizer> createContexts() {
        return new RuntimeValue<CamelContextCustomizer>(new CamelContextCustomizer() {
            public void configure(CamelContext camelContext) {
                camelContext.addComponent("echo", new EchoComponent());
                System.out.println("Echo component now available!!");
            }
        });
    }
}