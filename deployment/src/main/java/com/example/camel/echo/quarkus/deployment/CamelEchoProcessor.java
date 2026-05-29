package com.example.camel.echo.quarkus.deployment;


import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.annotations.ExecutionTime;
import io.quarkus.deployment.annotations.Record;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import com.example.camel.echo.quarkus.runtime.CamelEchoRecorder;
import org.apache.camel.quarkus.core.deployment.spi.RuntimeCamelContextCustomizerBuildItem;

class CamelEchoProcessor {

    private static final String FEATURE = "camel-echo";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    @Record(ExecutionTime.RUNTIME_INIT)
    RuntimeCamelContextCustomizerBuildItem configureDirContexts(CamelEchoRecorder camelEchoRecorder) {
        return new RuntimeCamelContextCustomizerBuildItem(camelEchoRecorder.createContexts());
    }

}